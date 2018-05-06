package org.zy.demonew.modelview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import org.zy.demonew.R;
import org.zy.demonew.databinding.ActivityBaseobservableObjBinding;
import org.zy.demonew.modelview.model.BaseObservableUser;

public class BaseObservableObjectActivity extends AppCompatActivity {
    private ActivityBaseobservableObjBinding binding;
    private BaseObservableUser baseObservableUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_baseobservable_obj);
        baseObservableUser = new BaseObservableUser("Zhang", "Yue");
        binding.setObuser(baseObservableUser);

//    changeData();

        binding.secondBtn.setClickable(true);
        binding.secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "!!!", Toast.LENGTH_SHORT).show();

                //可以
//                BaseObservableUser baseObservableUser = new BaseObservableUser("Zhang W", "Yan!!");
//                binding.setObuser(baseObservableUser);

                //可以，使用或者notifyChange()
//                baseObservableUser.setLastName(new String("Yan!"));

                //不行,只能配合公开属性使用才行
                baseObservableUser.setFirstName(new String("Zhang2"));
            }
        });
    }

//    private void changeData() {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
////                baseObservableUser.setFirstName("Wu");
//                baseObservableUser.setLastName("Yan!!!");
//            }
//        }, 1000);
//    }
}
