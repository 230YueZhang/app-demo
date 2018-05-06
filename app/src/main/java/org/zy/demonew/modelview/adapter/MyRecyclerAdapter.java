package org.zy.demonew.modelview.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.zy.demonew.R;
import org.zy.demonew.databinding.ListItemBinding;
import org.zy.demonew.modelview.model.User;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.BindingHolder> {

    private static final String TAG = "--zy--";
    private List<User> datas;
    private LayoutInflater inflater;

    public MyRecyclerAdapter(Context context, List<User> datas) {
        this.datas = datas;
        inflater = LayoutInflater.from(context);
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ListItemBinding binding;
        public BindingHolder(View itemView) {
            super(itemView);
        }
        public ListItemBinding getBinding() {
            return binding;
        }
        public void setBinding(ListItemBinding binding) {
            this.binding = binding;
        }
    }
    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e(TAG, "create a new item");
        ListItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.list_item,
                parent,
                false);
        BindingHolder holder = new BindingHolder(binding.getRoot());
        holder.setBinding(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        User user = datas.get(position);
        holder.getBinding().setUser(user);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}