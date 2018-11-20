package com.example.sande.mvvmrecyclerjava.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;


import com.example.sande.mvvmrecyclerjava.BR;
import com.example.sande.mvvmrecyclerjava.adapter.TaskListAdapter;
import com.example.sande.mvvmrecyclerjava.model.TaskListPOJO;
import com.example.sande.mvvmrecyclerjava.network.ApiService;
import com.example.sande.mvvmrecyclerjava.network.RetrofitInstance;
import com.example.sande.mvvmrecyclerjava.response.TaskListResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends BaseObservable {

    private static final String TAG = "MyViewModel";


    private List<TaskListPOJO> myList;
    TaskListAdapter adapter;

    public MyViewModel() {


        adapter = new TaskListAdapter();
        myList = new ArrayList<>();
    }


    public void setTaskData()
    {
        populateData();
    }

    @Bindable
    public List<TaskListPOJO> getTaskData()
    {
        return myList;
    }

    @Bindable
    public TaskListAdapter getAdapter() {
        return this.adapter;
    }

    public void populateData()
    {

      /*  ApiService apiService = RetrofitInstance.getRetrofitJsonInstance().create(ApiService.class);

        Call<TaskListResponse> call = apiService.getTaskList();

        call.enqueue(new Callback<TaskListResponse>() {
            @Override
            public void onResponse(Call<TaskListResponse> call, Response<TaskListResponse> response) {

                TaskListResponse taskListResponse = response.body();
                myList = taskListResponse.getTaskListResponse();
                notifyPropertyChanged(BR.startDate);

            }


            @Override
            public void onFailure(Call<TaskListResponse> call, Throwable t) {

            }
        });*/

      TaskListPOJO obj = new TaskListPOJO("23","34","fsdf","1","fdwef","2018-11-01","2018-12-01");
      myList.add(obj);
      notifyPropertyChanged(BR.adapter);
    }

    private void handleResults(TaskListResponse taskListResponse) {
        Log.i(TAG, "handleResults: " + taskListResponse.getTaskListResponse().get(0).getStartDate());

        myList = taskListResponse.getTaskListResponse();

        notifyPropertyChanged(BR.viewModel);
    }

    private void handleError(Throwable throwable) {
        Log.i(TAG, "handleError: " + throwable.getMessage());
    }
}
