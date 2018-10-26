package com.example.alexander.thevergetopnews;

import com.example.alexander.thevergetopnews.Model.News;

public interface MainContract {

    interface View {

        void showList(News news);



    }

    interface Presenter {
    }

    interface Repository {

       public void   getNews(OnFinishedListener onFinishedListener);

       interface OnFinishedListener {
           void onFinished(News news);
           void onFailure(Throwable t);
       }

    }

}
