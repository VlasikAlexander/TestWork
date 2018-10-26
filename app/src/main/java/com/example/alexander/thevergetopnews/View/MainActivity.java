package com.example.alexander.thevergetopnews.View;

import android.arch.lifecycle.LifecycleOwner;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.alexander.thevergetopnews.ApiClient;
import com.example.alexander.thevergetopnews.IApiInterface;
import com.example.alexander.thevergetopnews.MainContract;
import com.example.alexander.thevergetopnews.MainPresenter;
import com.example.alexander.thevergetopnews.Model.Article;
import com.example.alexander.thevergetopnews.Model.News;
import com.example.alexander.thevergetopnews.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String TAG = "LOOOOOOOOOG";
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    List<Article> articles;
    MainContract.Presenter mPresenter;
    SwipeRefreshLayout swipeRefreshLayout;
    FragmentManager fragmentManager;





    @Override
    public void showList(News news) {

//        fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.fragment_container, ListFragment.getNewInstance(news));
//        fragmentTransaction.commit();

        adapter = new RecyclerViewAdapter(news.getArticles(), getApplicationContext());
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setRefreshing(false);


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




     mPresenter = new MainPresenter(this);

       getLifecycle().addObserver((MainPresenter) mPresenter);

        swipeRefreshLayout = findViewById(R.id.swipeRefresh);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               ((MainPresenter) mPresenter).getNews();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




        }
}
