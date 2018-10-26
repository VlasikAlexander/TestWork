package com.example.alexander.thevergetopnews;



import com.example.alexander.thevergetopnews.Model.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository implements MainContract.Repository {

     public static IApiInterface mApiInterface;
     News news;


    public  void getNews(final OnFinishedListener onFinishedListener) {


            mApiInterface = ApiClient.getApiClient().create(IApiInterface.class);
            Call<News> newsCall = mApiInterface.getHeadliners();
            newsCall.enqueue(new Callback<News>() {
                @Override
                public void onResponse(Call<News> call, Response<News> response) {
                    news = response.body();
                   onFinishedListener.onFinished(news);


                }

                @Override
                public void onFailure(Call<News> call, Throwable t) {
                    onFinishedListener.onFailure(t);
                }
            });


    }



}
