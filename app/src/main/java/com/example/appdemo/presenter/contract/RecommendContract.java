package com.example.appdemo.presenter.contract;

import com.example.appdemo.bean.DemoInfo;
import com.example.appdemo.presenter.BasePresenter;
import com.example.appdemo.ui.BaseView;

public interface RecommendContract {
    interface View extends BaseView{

        void showDemo(DemoInfo demoInfo);
        void showNodata();
        void showerror(String msg);

    }
    interface Presenter extends BasePresenter{
        public void requestDemo();
    }
}
