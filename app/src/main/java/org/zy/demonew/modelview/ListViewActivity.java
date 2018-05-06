package org.zy.demonew.modelview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.zy.demonew.R;
import org.zy.demonew.modelview.model.User;
import org.zy.demonew.modelview.adapter.UserListAdapter;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    private ArrayList<User> users = new ArrayList<>();
    private UserListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        User user0 = new User("Zhang0", "Yue");
        User user1 = new User("Zhang1", "Yue");
        User user2 = new User("Zhang2", "Yue");
        User user3 = new User("Zhang3", "Yue");
        User user4 = new User("Zhang4", "Yue");
        User user5 = new User("Zhang5", "Yue");
        User user6 = new User("Zhang6", "Yue");
        User user7 = new User("Zhang7", "Yue");
        User user8 = new User("Zhang8", "Yue");
        User user9 = new User("Zhang9", "Yue");
        User user10 = new User("Zhang10", "Yue");
        User user11 = new User("Zhang11", "Yue");
        users.add(user0);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);
        users.add(user10);
        users.add(user11);
        ListView listView = findViewById(R.id.listview);
        adapter = new UserListAdapter(this, users);
        listView.setAdapter(adapter);

        changeData(user3);
    }

    private void changeData(final User user3) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                users.remove(user3);
                users.add(new User("Zhang12", "Yue"));
                adapter.notifyDataSetChanged();
            }
        }, 2000);
    }
}