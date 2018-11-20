package com.example.sande.mvvmrecyclerjava;

import android.app.Application;
import android.databinding.DataBindingUtil;

import com.example.sande.mvvmrecyclerjava.databinding.AppDataBindingComponent;

public class MyApplication extends Application {

    //MyComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        /*component = DaggerMyComponent.builder()
                .apiModule(new ApiModule("http://rjtmobile.com"))
                .build();*/
        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
    }

   /* public MyComponent getComponentInstance()
    {
        return component;
    }*/
}
