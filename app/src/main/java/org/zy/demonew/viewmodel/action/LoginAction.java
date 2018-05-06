package org.zy.demonew.viewmodel.action;

import android.view.View;

import org.zy.demonew.viewmodel.model.User;

public interface LoginAction {
    void onLogin(User user);
    @Deprecated
    boolean loginEnable(User user);
}
