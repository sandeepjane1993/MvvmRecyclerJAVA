package com.example.sande.mvvmrecyclerjava.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import com.example.sande.mvvmrecyclerjava.model.TaskListPOJO;

public class SingleItemViewModel extends BaseObservable {

    private TaskListPOJO taskListPOJO;

    public SingleItemViewModel(TaskListPOJO taskListPOJO) {
        this.taskListPOJO = taskListPOJO;
    }

    @Bindable
    public String getStartDate() {
        return !TextUtils.isEmpty(taskListPOJO.getStartDate()) ? taskListPOJO.getStartDate() : "";
    }
}
