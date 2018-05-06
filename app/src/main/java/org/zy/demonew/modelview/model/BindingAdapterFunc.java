package org.zy.demonew.modelview.model;

import android.databinding.BindingAdapter;
import android.widget.TextView;

public class BindingAdapterFunc {
    @BindingAdapter({"app:textAddChars"})
    public static void showText(TextView textView, String newV){
        textView.setText(newV+"  ...");
    }

}
