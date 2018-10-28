package com.example.alexander.thevergetopnews.Model;


import com.example.alexander.thevergetopnews.Model.dto.News;
import com.example.alexander.thevergetopnews.Model.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
    private News news;
    // is listener null-able?
    public void getNews(final RepositoryListener onFinishedListener) {

        Call<News> newsCall = ApiClient.getInstance().getService().getHeadliners();
        newsCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                news = response.body();
                onFinishedListener.onFinished(news);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                onFinishedListener.onFailure(t);
                t.printStackTrace();
            }
        });

    }

}
