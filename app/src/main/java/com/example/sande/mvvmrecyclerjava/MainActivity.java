package com.example.sande.mvvmrecyclerjava;


import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sande.mvvmrecyclerjava.databinding.ActivityMainBinding;
import com.example.sande.mvvmrecyclerjava.viewmodel.MyViewModel;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;


public class MainActivity extends AppCompatActivity {

    private MyViewModel viewModel;

   private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //setContentView(R.layout.activity_main);

        View view = bind();
        initRecyclerView(view);

    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.setTaskData();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    private View bind() {
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new MyViewModel();
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }
    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_TaskList);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), VERTICAL));
    }
}
