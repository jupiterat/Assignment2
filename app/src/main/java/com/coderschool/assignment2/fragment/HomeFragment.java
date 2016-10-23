package com.coderschool.assignment2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.coderschool.assignment2.R;
import com.coderschool.assignment2.model.Article;
import com.coderschool.assignment2.presenter.ArticleContract;
import com.coderschool.assignment2.presenter.ArticlePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by duongthoai on 10/22/16.
 */

public class HomeFragment extends Fragment implements ArticleContract.View {

    @BindView(R.id.articleList)
    RecyclerView recyclerView;

    ArticlePresenter presenter;




    public static HomeFragment makeInstance() {
        return new HomeFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        presenter = new ArticlePresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, v);
        setHasOptionsMenu(true);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
//        presenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
//        presenter.unsubscribe();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_filter:
                break;
            case R.id.action_search:
                break;
            case R.id.action_setting:
                break;
        }
        return true;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_home, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                presenter.loadArticles(false);
                //TODO: call function here
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void showArticles(List<Article> articles) {

    }

    @Override
    public void showFilteringPopUpMenu() {

    }

    @Override
    public void setPresenter(ArticleContract.Presenter presenter) {

    }
}
