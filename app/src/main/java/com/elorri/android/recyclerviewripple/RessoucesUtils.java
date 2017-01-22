package com.elorri.android.recyclerviewripple;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;

/**
 * Created by Elorri on 22/01/2017.
 */
public class RessoucesUtils {

    public static int getResDrawable(Context context, int drawableThemeAttr) {
        int[] drawableAttr = new int[]{drawableThemeAttr};
        int indexOfdrawableAttr = 0;
        TypedValue typedValue = new TypedValue();
        TypedArray a = context.obtainStyledAttributes(typedValue.data, drawableAttr);
        int drawableRes = a.getResourceId(indexOfdrawableAttr, -1);
        a.recycle();
        return drawableRes;
    }
}
