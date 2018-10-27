package com.example.alexander.thevergetopnews.Model.network;

import com.example.alexander.thevergetopnews.Model.dto.News;

import retrofit2.Call;
import retrofit2.http.GET;


public interface IApiInterface {

        @GET("top-headlines?country=us&apiKey=23e308f40dc4407f8d3d743173e66218")
        Call<News> getHeadliners();

        @GET("everything?sources=the-verge?country=us&apiKey=23e308f40dc4407f8d3d743173e66218")
        Call<News> getAllNews();
    }


