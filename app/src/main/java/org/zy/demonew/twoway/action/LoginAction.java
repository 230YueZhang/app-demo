package org.zy.demonew.twoway.action;

import org.zy.demonew.twoway.model.User;

public interface LoginAction {
    void onLogin(User user);
    @Deprecated
    boolean loginEnable(User user);
}
