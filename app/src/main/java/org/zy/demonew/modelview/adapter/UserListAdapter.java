package org.zy.demonew.modelview.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.zy.demonew.R;
import org.zy.demonew.databinding.ListItemBinding;
import org.zy.demonew.modelview.model.User;

import java.util.ArrayList;

public class UserListAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<User> mData ;

    public UserListAdapter(Context context, ArrayList<User> mData) {
        this.mContext = context;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemBinding binding = null;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.list_item, parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (ListItemBinding) convertView.getTag();
        }

        binding.setUser(mData.get(position));
        return convertView;
    }
}