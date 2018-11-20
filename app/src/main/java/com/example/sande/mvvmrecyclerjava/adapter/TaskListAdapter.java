package com.example.sande.mvvmrecyclerjava.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.sande.mvvmrecyclerjava.R;
import com.example.sande.mvvmrecyclerjava.databinding.SingleitemProjectListBinding;
import com.example.sande.mvvmrecyclerjava.model.TaskListPOJO;
import com.example.sande.mvvmrecyclerjava.viewmodel.SingleItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.DataViewHolder> {

   // private ClickListener clickListener;
   private static final String TAG = "TaskListAdapter";
    private List<TaskListPOJO> taskList;
    Context ctx;

    public TaskListAdapter() {
        this.taskList = new ArrayList<>();
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleitem_project_list, new FrameLayout(parent.getContext()), false);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {

        TaskListPOJO taskListPOJO = taskList.get(position);
        holder.setViewModel(new SingleItemViewModel(taskListPOJO));
    }

    @Override
    public int getItemCount() {
        return this.taskList.size();
    }

    @Override
    public void onViewAttachedToWindow(DataViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(DataViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public void updateData(@Nullable List<TaskListPOJO> data) {
        if (data == null || data.isEmpty()) {

            this.taskList.clear();
        } else {
            Log.i(TAG, "updateData: " + data.toString());
            this.taskList.addAll(data);
        }
        notifyDataSetChanged();
    }

    /* package */ static class DataViewHolder extends RecyclerView.ViewHolder {
        /* package */ SingleitemProjectListBinding binding;

        /* package */ DataViewHolder(View itemView) {
            super(itemView);
            bind();
        }

        /* package */ void bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind(itemView);
            }
        }

        /* package */ void unbind() {
            if (binding != null) {
                binding.unbind(); // Don't forget to unbind
            }
        }

        /* package */ void setViewModel(SingleItemViewModel viewModel) {
            if (binding != null) {
                binding.setViewModel(viewModel);
            }
        }
    }
}
