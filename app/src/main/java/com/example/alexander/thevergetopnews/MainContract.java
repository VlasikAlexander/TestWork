package com.example.alexander.thevergetopnews;

import com.example.alexander.thevergetopnews.Model.dto.News;

public interface MainContract {

    interface View {
        void showList(News news);
        void showMessage(String s);
    }

    interface Presenter {
        void getData();
        void refresh();
        void subscribe(View view);
        void unSubscribe();
    }
}
