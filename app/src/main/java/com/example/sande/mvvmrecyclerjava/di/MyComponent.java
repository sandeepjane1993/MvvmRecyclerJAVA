package com.example.sande.mvvmrecyclerjava.di;

import com.example.sande.mvvmrecyclerjava.viewmodel.MyViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class})
public interface MyComponent {


    void injectRetro(MyViewModel viewModel);
}
