package com.example.appdemo.http;

import com.example.appdemo.bean.DemoInfo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    public static final String BASE_URL="http://t.weather.sojson.com/";
    @GET("api/weather/city/101030100")
    public Call<DemoInfo>getDemo();
}
