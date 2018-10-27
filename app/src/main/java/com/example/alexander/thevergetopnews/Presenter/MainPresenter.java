package com.example.alexander.thevergetopnews.Presenter;



import com.example.alexander.thevergetopnews.MainContract;
import com.example.alexander.thevergetopnews.Model.MainRepository;
import com.example.alexander.thevergetopnews.Model.dto.News;
import com.example.alexander.thevergetopnews.Model.RepositoryListener;


public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private MainRepository mRepository;
    private RepositoryListener<News> mRepositoryCallback;
    private News dataStore;
    private static final long UPRATE_TRIGGER = 1000*60*10;
    private long timeStamp = 0;


    public MainPresenter() {
        this.mRepository = new MainRepository();
        initRepoListener();
    }

    @Override
    public void getData() {
        if(dataStore == null || (!isCurrentDataActual())){
            mView.showMessage("Data is loading");
            mRepository.getNews(mRepositoryCallback);
            return;
        }
        mView.showList(dataStore);
    }

    @Override
    public void refresh() {
        if(dataStore == null || (!isCurrentDataActual())){
            mView.showMessage("Data is loading");
            mRepository.getNews(mRepositoryCallback);
            return;
        }
        mView.showMessage("No data to update");
    }

    @Override
    public void subscribe(MainContract.View view) {
        mView = view;
        getData();
    }

    @Override
    public void unSubscribe() {
        mView = null;
    }

    private void initRepoListener(){
       mRepositoryCallback = new RepositoryListener<News>() {
           @Override
           public void onFinished(News data) {
               dataStore = data;
               mView.showList(data);
               timeStamp = System.currentTimeMillis();
           }

           @Override
           public void onFailure(Throwable t) {
               mView.showMessage("Error loading");
           }
       };
    }

    private boolean isCurrentDataActual(){

        return (System.currentTimeMillis() - timeStamp) < UPRATE_TRIGGER;
    }
}
