package com.handsome.qunyingzhuang.chapter_3.CustomScrollView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.OverScroller;
import android.widget.Scroller;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2016/10/8.
 */
public class CustomScrollView extends ViewGroup {

    private int mScreenHeight;
    private Scroller mScroller;
    private int mLastY;
    private int mStart;
    private int mEnd;

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取屏幕高宽
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        mScreenHeight = wm.getDefaultDisplay().getHeight();
        mScroller = new Scroller(getContext());
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        int childCount = getChildCount();
        Log.e("count", childCount + "");
        MarginLayoutParams mlp = (MarginLayoutParams) getLayoutParams();
        mlp.height = mScreenHeight * childCount;
        setLayoutParams(mlp);

        for (int j = 0; j < childCount; j++) {
            View child = getChildAt(j);
            if (child.getVisibility() != View.GONE) {
                child.layout(i, j * mScreenHeight, i2, (j + 1) * mScreenHeight);
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for (int i = 0; i < count; ++i) {
            View childView = getChildAt(i);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastY = y;
                mStart = getScrollY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                int dy = mLastY - y;
                if (getScrollY() < 0) {
                    dy = 0;
                }
                if (getScrollY() > getHeight() - mScreenHeight) {
                    dy = 0;
                }
                scrollBy(0, dy);
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:
                mEnd = getScrollY();
                int dScrollY = mEnd - mStart;
                if (dScrollY > 0) {
                    if (dScrollY < mScreenHeight / 3) {
                        mScroller.startScroll(0, getScrollY(), 0, -dScrollY);
                    } else {
                        mScroller.startScroll(0, getScrollY(), 0, mScreenHeight - dScrollY);
                    }
                } else {
                    if (-dScrollY < mScreenHeight / 3) {
                        mScroller.startScroll(0, getScrollY(), 0, -dScrollY);
                    } else {
                        mScroller.startScroll(0, getScrollY(), 0, -mScreenHeight - dScrollY);
                    }
                }
                break;
        }
        postInvalidate();
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            scrollTo(0, mScroller.getCurrY());
        }
    }
}
