package com.example.alexander.thevergetopnews.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alexander.thevergetopnews.MainContract;
import com.example.alexander.thevergetopnews.MainPresenter;
import com.example.alexander.thevergetopnews.Model.Article;
import com.example.alexander.thevergetopnews.Model.News;
import com.example.alexander.thevergetopnews.R;


import java.util.List;

public class ListFragment extends Fragment {

//    List<Article> articles;
//    RecyclerViewAdapter adapter;
//    RecyclerView recyclerView;
//    News news;
//    MainContract.Presenter mPresenter;
//
//    public  static ListFragment getNewInstance(News news) {
//        ListFragment listFragment = new ListFragment();
//
//
//        return listFragment;
//
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.recyclerview_fragment, container, false);
//        recyclerView = v.findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//
//
//
//        return v;
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//
//        articles = (List<Article>) getArguments().getSparseParcelableArray("NEWS");
//        adapter = new RecyclerViewAdapter(articles, getContext());
//        recyclerView.setAdapter(adapter);
//        super.onCreate(savedInstanceState);
//
//    }



}
