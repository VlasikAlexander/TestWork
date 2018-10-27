package com.example.alexander.thevergetopnews.View;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.alexander.thevergetopnews.MainContract;
import com.example.alexander.thevergetopnews.Presenter.MainPresenter;
import com.example.alexander.thevergetopnews.Model.dto.News;
import com.example.alexander.thevergetopnews.utils.PresenterHolder;
import com.example.alexander.thevergetopnews.R;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private MainPresenter mPresenter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenter();
        initViews();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.refresh();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.subscribe(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.unSubscribe();
    }

    private void initViews() {
        swipeRefreshLayout = findViewById(R.id.swipeRefresh);
        recyclerView = findViewById(R.id.recyclerView);
    }

    private void initPresenter() {
        mPresenter = PresenterHolder.getInstance().provideMainPresenter();
    }

    @Override
    public void showList(News news) {
        adapter = new RecyclerViewAdapter(news.getArticles(), getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        swipeRefreshLayout.setRefreshing(false);
    }


}
