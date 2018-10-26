package com.example.alexander.thevergetopnews;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.alexander.thevergetopnews.MainContract;
import com.example.alexander.thevergetopnews.Model.News;

public class MainPresenter implements MainContract.Presenter, LifecycleObserver, MainContract.Repository.OnFinishedListener {

    private MainContract.View mView;
    private MainContract.Repository mRepository;

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void getNews(){
        Log.d("------------", "MainPresenter");
        mRepository.getNews(this);
    }






    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        this.mRepository = new MainRepository();
    }


    @Override
    public void onFinished(News news) {
        mView.showList(news);
    }

    @Override
    public void onFailure(Throwable t) {

    }
}
