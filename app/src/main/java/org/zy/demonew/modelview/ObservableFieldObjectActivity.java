package org.zy.demonew.modelview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import org.zy.demonew.R;
import org.zy.demonew.databinding.ActivityObservablefieldsBinding;
import org.zy.demonew.modelview.model.ObservableFieldUser;

public class ObservableFieldObjectActivity extends AppCompatActivity {
    private ActivityObservablefieldsBinding binding;
    private ObservableFieldUser observableFieldUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_observablefields);
        observableFieldUser = new ObservableFieldUser();
        observableFieldUser.firstName.set("Zhang");
        observableFieldUser.lastName.set("Yue");
        observableFieldUser.age.set(26);
        binding.setUser(observableFieldUser);

        changeData();
    }

    private void changeData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                observableFieldUser.firstName.set("Zhang3");
                observableFieldUser.lastName.set("Yue3");
                observableFieldUser.age.set(30);
            }
        }, 2000);
    }
}
