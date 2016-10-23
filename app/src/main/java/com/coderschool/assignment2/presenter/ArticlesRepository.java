package com.coderschool.assignment2.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.coderschool.assignment2.model.Article;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.Observer;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by duongthoai on 10/23/16.
 */

public class ArticlesRepository implements ArticlesDataSource {

    @Nullable
    private static ArticlesRepository instance = null;

    boolean mCacheIsDirty = false;

    @NonNull
    private final ArticlesDataSource mArticlesRemoteDataSource;

    @NonNull
    private final ArticlesDataSource mArticlesLocalDataSource;

    Map<String, Article> mCachedTasks;

    public static ArticlesRepository getInstance(@NonNull ArticlesDataSource remoteDatasource,
                                                 @NonNull ArticlesDataSource localDatasource) {
        if (instance == null) {
            instance = new ArticlesRepository(remoteDatasource, localDatasource);
        }
        return instance;
    }

    private ArticlesRepository(@NonNull ArticlesDataSource remoteDatasource,
                               @NonNull ArticlesDataSource localDatasource) {
        mArticlesRemoteDataSource = remoteDatasource;
        mArticlesLocalDataSource = localDatasource;
    }

    public static void destroyInstance() {
        instance = null;
    }

    @Override
    public Observable<List<Article>> getArticles() {
        if (mCachedTasks != null) {
            return Observable.from(mCachedTasks.values()).toList();
        } else {
            mCachedTasks = new LinkedHashMap<>();
        }
        Observable<List<Article>> remoteArticles = getAndSaveRemoteTasks();
        if (mCacheIsDirty) {
            return remoteArticles;
        } else {
            Observable<List<Article>> localArticles = getAndCacheLocalTasks();
            return Observable.concat(localArticles, remoteArticles).filter(new Func1<List<Article>, Boolean>() {
                @Override
                public Boolean call(List<Article> articles) {
                    return !articles.isEmpty();
                }
            }).first();
        }
    }

    @Override
    public void saveArticle(@NonNull Article article) {
        checkNotNull(article);
        mArticlesLocalDataSource.saveArticle(article);
        mArticlesRemoteDataSource.saveArticle(article);

        // Do in memory cache update to keep the app UI up to date
        if (mCachedTasks == null) {
            mCachedTasks = new LinkedHashMap<>();
        }
        mCachedTasks.put(article.get_id(), article);
    }

    private Observable<List<Article>> getAndSaveRemoteTasks() {
        return mArticlesRemoteDataSource.getArticles()
                .flatMap(new Func1<List<Article>, Observable<List<Article>>>() {
                    @Override
                    public Observable<List<Article>> call(List<Article> articles) {
                        return Observable.from(articles).doOnNext(new Action1<Article>() {
                            @Override
                            public void call(Article article) {
                                mArticlesLocalDataSource.saveArticle(article);
                                mCachedTasks.put(article.get_id(), article);
                            }
                        }).toList();
                    }
                }).doOnCompleted(new Action0() {
                    @Override
                    public void call() {
                        mCacheIsDirty = false;
                    }
                });
    }

    private Observable<List<Article>> getAndCacheLocalTasks() {
        return mArticlesLocalDataSource.getArticles().flatMap(new Func1<List<Article>, Observable<List<Article>>>() {
            @Override
            public Observable<List<Article>> call(List<Article> articles) {
                return Observable.from(articles).doOnNext(new Action1<Article>() {
                    @Override
                    public void call(Article article) {
                        mCachedTasks.put(article.get_id(), article);
                    }
                }).toList();
            }
        });
    }
}
