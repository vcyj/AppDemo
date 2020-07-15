package com.example.appdemo.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.example.appdemo.R;
import com.example.appdemo.bean.DemoInfo;
import com.example.appdemo.databinding.FragmentRecomendBinding;
import com.example.appdemo.http.ApiService;
import com.example.appdemo.http.HttpManger;
import com.example.appdemo.presenter.RecommendPresenter;
import com.example.appdemo.presenter.contract.RecommendContract;
import com.example.appdemo.ui.adapter.RecommendAppAdapter;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecomendFragment extends Fragment implements RecommendContract.View{
    private FragmentRecomendBinding rbinding;
    private RecommendAppAdapter madapter;
    private RecommendContract.Presenter mPresenter;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rbinding=FragmentRecomendBinding.inflate(inflater,container,false);
        mPresenter=new RecommendPresenter(this);
        initData();
        return rbinding.getRoot();


    }
    public void initData(){
        mPresenter.requestDemo();
    }
    private void initaRecyclerview(DemoInfo demoInfo){

//        rbinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rbinding.recyclerView.setLayoutManager(manager);
        rbinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        madapter=new RecommendAppAdapter(getActivity(),demoInfo);
        rbinding.recyclerView.setAdapter(madapter);


    }

    @Override
    public void showDemo(DemoInfo demoInfo) {
        initaRecyclerview(demoInfo);
    }

    @Override
    public void showNodata() {
        Toast.makeText(getActivity(),"暂时无数据",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showerror(String msg) {
        Toast.makeText(getActivity(),"no return"+msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showloading() {

    }

    @Override
    public void dismissload() {

    }
}
