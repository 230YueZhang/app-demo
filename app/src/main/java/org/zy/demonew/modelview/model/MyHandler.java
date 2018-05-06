package org.zy.demonew.modelview.model;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.zy.demonew.R;

/**
 * 方法引用，基本用不到
 * <p>
 * xml中添加android:onClick="@{handler.onClickLastName}"即可
 */
public class MyHandler {
    public void onClickLastName(View view) {
        Log.e("--zy--", "abc");
        Toast.makeText(view.getContext(), "click!", Toast.LENGTH_SHORT).show();
        view.setBackgroundResource(R.drawable.ic_launcher_background);
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.e("--zy--", "text:   " + s);
    }
}