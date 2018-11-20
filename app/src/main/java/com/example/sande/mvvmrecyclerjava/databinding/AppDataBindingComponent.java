package com.example.sande.mvvmrecyclerjava.databinding;

public class AppDataBindingComponent implements android.databinding.DataBindingComponent {

    @Override
    public RecyclerViewDataBinding getRecyclerViewDataBinding() {
        return new RecyclerViewDataBinding();
    }
}
