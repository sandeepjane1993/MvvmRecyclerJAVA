package com.example.sande.mvvmrecyclerjava.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.example.sande.mvvmrecyclerjava.adapter.TaskListAdapter;
import com.example.sande.mvvmrecyclerjava.model.TaskListPOJO;

import java.util.List;

public class RecyclerViewDataBinding {

    @BindingAdapter({"app:adapter", "app:data"})
    public void bind(RecyclerView recyclerView, TaskListAdapter adapter, List<TaskListPOJO> taskListPOJOS) {
        recyclerView.setAdapter(adapter);
        adapter.updateData(taskListPOJOS);
    }
}
