package org.zy.demonew.modelview;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import org.zy.demonew.R;
import org.zy.demonew.databinding.ActivityBasicBinding;
import org.zy.demonew.databinding.ListItemBinding;
import org.zy.demonew.modelview.model.User;
import org.zy.demonew.modelview.model.MyHandler;
import org.zy.demonew.modelview.model.Presenter;

public class BasicFuncActivity extends AppCompatActivity {
    private ActivityBasicBinding activityBasicBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        activityBasicBinding = DataBindingUtil.setContentView(this, R.layout.activity_basic);
        User user = new User("Zhang", "Yue");
        activityBasicBinding.setUser(user);
        // 或者直接通过setVariable
//        activityBasicBinding.setVariable(BR.obuser,user);

        activityBasicBinding.setHandler(new MyHandler());

        activityBasicBinding.setPresenter(new Presenter());

        activityBasicBinding.secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User("Zhang2", "Yang!");
                activityBasicBinding.setUser(user);
            }
        });

        activityBasicBinding.viewstub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                ListItemBinding binding = DataBindingUtil.bind(inflated);
                User user = new User("Zhang", "Yue");
                binding.setUser(user);
            }
        });
        inflateViewStub();
    }

    private void inflateViewStub() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!activityBasicBinding.viewstub.isInflated())
                    activityBasicBinding.viewstub.getViewStub().inflate();
            }
        }, 2000);
    }
}
