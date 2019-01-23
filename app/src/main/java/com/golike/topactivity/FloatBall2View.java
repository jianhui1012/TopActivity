package com.golike.topactivity;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Desc:
 * Company: xuehai
 * Copyright: Copyright (c) 2019
 *
 * @author djh
 * @since 2019/01/23 14/32
 */
public class FloatBall2View extends LinearLayout {
    private TextView tvPackageName;
    private TextView tvPackageActivity;

    public FloatBall2View(Context context) {
        super(context);
        init(context);
    }

    public FloatBall2View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FloatBall2View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /***
     * init
     * @param context context
     */
    public void init(Context context) {
        tvPackageName = new TextView(context);
        addView(tvPackageName);
        tvPackageActivity = new TextView(context);
        this.setOrientation(VERTICAL);
        this.addView(tvPackageActivity);
    }

    /***
     * refreshContext
     * @param packageName packageName
     * @param packageActivity packageActivity
     */
    public void refreshContext(String packageName,String packageActivity) {
        if (tvPackageName != null && tvPackageActivity != null) {
            tvPackageName.setText(packageName);
            tvPackageActivity.setText(packageActivity);
        }
    }

}
