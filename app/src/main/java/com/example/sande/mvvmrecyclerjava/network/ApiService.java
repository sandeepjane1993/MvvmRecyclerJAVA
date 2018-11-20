package com.example.sande.mvvmrecyclerjava.network;

import com.example.sande.mvvmrecyclerjava.response.TaskListResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    //http://rjtmobile.com/aamir/pms/android-app/pms_project_task_list.php?
    @GET("/aamir/pms/android-app/pms_project_task_list.php?")
    Call<TaskListResponse> getTaskList();
}
