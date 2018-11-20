package com.example.sande.mvvmrecyclerjava.response;

import com.example.sande.mvvmrecyclerjava.model.TaskListPOJO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TaskListResponse {

    @SerializedName("project task")
    private List<TaskListPOJO> taskListResponse;

    public TaskListResponse(List<TaskListPOJO> taskListResponse) {
        this.taskListResponse = taskListResponse;
    }

    public List<TaskListPOJO> getTaskListResponse() {
        return taskListResponse;
    }
}
