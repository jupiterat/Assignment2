package com.coderschool.assignment2.presenter;

import android.support.annotation.NonNull;

import com.coderschool.assignment2.model.Article;
import com.coderschool.assignment2.utils.BaseSchedulerProvider;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Func1;
import rx.subscriptions.CompositeSubscription;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by duongthoai on 10/23/16.
 */

public class ArticlePresenter implements ArticleContract.Presenter {

    private String mQuery;

    @NonNull
    private final ArticlesRepository mArticleRepository;

    @NonNull
    private final ArticleContract.View mArticlesView;

    @NonNull
    private final BaseSchedulerProvider mSchedulerProvider;

    @NonNull
    private CompositeSubscription mSubscriptions;

    public ArticlePresenter(@NonNull ArticlesRepository articlesRepository,
                            @NonNull ArticleContract.View articlesView,
                            @NonNull BaseSchedulerProvider schedulerProvider) {
        mArticleRepository = checkNotNull(articlesRepository);
        mArticlesView = checkNotNull(articlesView);
        mSchedulerProvider = checkNotNull(schedulerProvider);
        mSubscriptions = new CompositeSubscription();
        mArticlesView.setPresenter(this);
    }

    @Override
    public void loadArticles(boolean forceUpdate) {
        mSubscriptions.clear();
        Subscription subscription = mArticleRepository
                .getArticles()
                .flatMap(new Func1<List<Article>, Observable<Article>>() {
                    @Override
                    public Observable<Article> call(List<Article> article) {
                        return Observable.from(article);
                    }
                })
                .toList()
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Observer<List<Article>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(List<Article> tasks) {
                    }
                });
        mSubscriptions.add(subscription);
    }

    @Override
    public void setQuery(String query) {
        mQuery = query;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
