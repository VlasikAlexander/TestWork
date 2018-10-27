package com.example.alexander.thevergetopnews.Model;

public interface RepositoryListener<T> {

    void onFinished(T data);
    void onFailure(Throwable t);
}
