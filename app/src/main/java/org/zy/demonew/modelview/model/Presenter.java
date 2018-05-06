package org.zy.demonew.modelview.model;

import android.util.Log;

/**
 * Listener Binding
 * <p>
 * xml中添加 android:onClick="@{()->presenter.onSaveClick(user)}"即可
 */
public class Presenter {
    public void onSaveClick(User user) {
        Log.e("--zy--", "save name: " + user.firstName + user.lastName);
    }
}
