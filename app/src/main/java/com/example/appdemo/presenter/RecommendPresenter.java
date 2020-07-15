package com.example.appdemo.presenter;

import com.example.appdemo.bean.DemoInfo;
import com.example.appdemo.data.RecommendModel;
import com.example.appdemo.presenter.contract.RecommendContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommendPresenter implements RecommendContract.Presenter {
    private RecommendModel mModel;
    private RecommendContract.View mview;
    public RecommendPresenter(RecommendContract.View view){
        this.mview=view;
        mModel=new RecommendModel();
    }


    @Override
    public void requestDemo() {
        mview.showloading();
        mModel.getDemo(new Callback<DemoInfo>() {
            @Override
            public void onResponse(Call<DemoInfo> call, Response<DemoInfo> response) {
                if(response!=null){
                    mview.showDemo(response.body());

                }
                else {
                    mview.showNodata();
                }
                mview.dismissload();
            }


            @Override
            public void onFailure(Call<DemoInfo> call, Throwable t) {
                mview.dismissload();
                mview.showerror(t.getMessage());
            }
        });

    }
}
