package com.example.sande.mvvmrecyclerjava.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofitJson;
    private static Retrofit retrofitString;

    public static final String BASE_URL = "http://rjtmobile.com";


    public static Retrofit getRetrofitJsonInstance()
    {
        if(retrofitJson == null)
        {
            retrofitJson = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofitJson;
    }

}
