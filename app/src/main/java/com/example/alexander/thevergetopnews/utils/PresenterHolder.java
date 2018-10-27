package com.example.alexander.thevergetopnews.utils;

import com.example.alexander.thevergetopnews.Presenter.MainPresenter;

public class PresenterHolder {

    private static PresenterHolder instance;
    private MainPresenter mainPresenter;

    private PresenterHolder(){

    }

    public static PresenterHolder getInstance(){

        if(instance == null){
            instance = new PresenterHolder();
        }
        return instance;
    }

    public MainPresenter provideMainPresenter(){

        if(mainPresenter == null){

            mainPresenter = new MainPresenter();
        }

        return  mainPresenter;
    }

    public void clearMainPresenter(){
        mainPresenter.unSubscribe();
        mainPresenter = null;
    }
}
