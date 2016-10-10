package com.handsome.qunyingzhuang.chapter_4.Anli01;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ListView;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2016/10/8.
 */
public class TanXingListView extends ListView {

    private int mMaxOverDistance;

    public TanXingListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float density = metrics.density;
        mMaxOverDistance = (int) (density * mMaxOverDistance);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, mMaxOverDistance, maxOverScrollY, isTouchEvent);
    }
}
