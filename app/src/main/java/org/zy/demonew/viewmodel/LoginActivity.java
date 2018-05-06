package org.zy.demonew.viewmodel;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;

import org.zy.demonew.R;
import org.zy.demonew.databinding.ActivityLoginBinding;
import org.zy.demonew.viewmodel.action.LoginAction;
import org.zy.demonew.viewmodel.model.User;

import static org.zy.demonew.viewmodel.Constants.LOGIN_INFO;

public class LoginActivity extends AppCompatActivity implements LoginAction {
    private ActivityLoginBinding activityLoginBinding;
    private User user;
//    private TextWatcher textWatcher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        activityLoginBinding.setLogin(this);
        if (savedInstanceState == null) {
            user = new User();

            getFakedUser();
        } else {
            user = savedInstanceState.getParcelable(LOGIN_INFO);
        }
        activityLoginBinding.setUser(user);

//        textWatcher = new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                user.formatOk.set(user.checkFormat());
//            }
//        };
//        activityLoginBinding.password.addTextChangedListener(textWatcher);
//        activityLoginBinding.name.addTextChangedListener(textWatcher);


    }

    /**
     * 假装获取到了数据（可以是请求允许的用户列表，上次登录过的用户，页面奔溃保存的用户信息等）
     */
    private void getFakedUser() {
        user.name.set("ZhangYue");

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                user.name.set("ZhangYue");
//                user.errorString.set("输入的格式有误！");
//            }
//        }, 1000);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(LOGIN_INFO, user);
    }

    @Override
    public void onLogin(User user) {
        Log.e("--zy--", "name: " + user.name.get() + " password: " + user.password.get() + " remember: " + user.rememberPsw.get());
        user.afterLogin(user);
    }

    /**
     * 想设置登录按钮 android:enabled='@{login.loginEnable(user)}' 但是没有很好的方式,这种设置方式只能开始的时候调用一次，
     * 如果需要动态改变，只能是结合一些动态方法的回调来调用loginEnable方法;
     * DataBinding是数据Data-视图View绑定，数据驱动视图变化——那我想控制登录按钮enable的问题也可以通过数据驱动——数据产生变化-之前绑定这个数据的的控件
     * 状态也跟着变化，之前介绍的方法有几种：
     * Binding实例setUser();继承BaseObservable的Obj;成员变量都是ObservableField或者ObservableCollection;
     * 那现在我只能在View层User对象中添加{boolean enable}成员来完成这个任务。添加成员之后关于如何去验证/改变这个变量的值呢？取决于场景——现在的场景就
     * 是账号/密码的格式决定了enable的值。
     * <p>
     * 遇到一个问题：我在activity_login.xml里面定义方法引用（Method Reference）android:afterTextChanged="@{user.afterTextChange}"；方法afterTextChange运行
     * checkFormat的时候运行时错误，空指针-说明这时候的user.name还是空的；我换了种方法定义EditText的id，在binding中获取控件调用addTextChangedListener方法，在里面
     * 相同的方法内运行checkFormat方法，运行正常，逻辑正确。这个很奇怪，也就是说我用DataBinding方法引用的方式调用过程中android:text="@={user.name}"没有执行。难道这个
     * 可以在xml里面定义耗时的一些后台方法？和DataBinding的实现原理相关，后面在进行分析。先用判空方法规避
     *
     * @param user
     * @return
     */
    @Deprecated
    @Override
    public boolean loginEnable(User user) {
        return (!TextUtils.isEmpty(user.name.get()) && user.name.get().length() > 1 && !TextUtils.isEmpty(user.password.get()) && user.password.get().length() > 5);
    }

}
