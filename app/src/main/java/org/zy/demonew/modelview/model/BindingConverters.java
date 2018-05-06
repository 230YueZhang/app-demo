package org.zy.demonew.modelview.model;

import android.databinding.BindingConversion;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

public class BindingConverters {
    @BindingConversion
    public static ColorDrawable convertColorToDrawable(String color) {
        return new ColorDrawable(Color.parseColor(color));
    }
}
