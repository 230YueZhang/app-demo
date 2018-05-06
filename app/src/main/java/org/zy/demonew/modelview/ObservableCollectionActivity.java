package org.zy.demonew.modelview;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import org.zy.demonew.R;
import org.zy.demonew.databinding.ActivityObservablecollectionsBinding;

public class ObservableCollectionActivity extends AppCompatActivity {
    private ActivityObservablecollectionsBinding binding;
    private ObservableArrayMap<String, Object> userMap;
    private ObservableArrayList<Object> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_observablecollections);
        userMap = new ObservableArrayMap<>();
        userMap.put("firstName", "Zhang");
        userMap.put("lastName", "Yue");
        userMap.put("age", 17);
        binding.setUser(userMap);

        userList = new ObservableArrayList<>();
        userList.add("Zhang");
        userList.add("Yue");
        userList.add(17);
        binding.setUserList(userList);

        changeData();
    }

    private void changeData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                userMap.put("lastName", "Water");
                userMap.put("age", 30);

                userList.remove(2);
//                userList.add(30);
            }
        }, 2000);
    }
}
