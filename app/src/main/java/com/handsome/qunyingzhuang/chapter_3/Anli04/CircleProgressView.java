package com.handsome.qunyingzhuang.chapter_3.Anli04;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2016/10/7.
 */
public class CircleProgressView extends View {

    private int mCircleXY;
    private int length;
    private float mRadius;

    private Paint mCirclePaint;
    private Paint mArcPaint;
    private Paint mTextPaint;
    private String mShowText = "Hensen_";

    private int mTextSize = 25;
    private float mSweepValue = 270;

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取屏幕高宽
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        length = wm.getDefaultDisplay().getWidth();
        init();
    }

    private void init() {
        mCircleXY = length / 2;
        mRadius = (float) (length * 0.5 / 2);

        mCirclePaint = new Paint();
        mCirclePaint.setColor(Color.BLUE);

        mArcPaint = new Paint();
        mArcPaint.setStrokeWidth(50);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setColor(Color.BLUE);

        mTextPaint = new Paint();
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(mTextSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //矩形
        RectF mArcRectF = new RectF((float) (length * 0.1), (float) (length * 0.1), (float) (length * 0.9), (float) (length * 0.9));
        //绘制圆
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        //绘制弧线
        canvas.drawArc(mArcRectF, 270, mSweepValue, false, mArcPaint);
        //绘制文字
        canvas.drawText(mShowText, 0, mShowText.length(), mCircleXY, mCircleXY + (mTextSize / 4), mTextPaint);
    }

    public void setSweepValue(float sweepValue) {
        if (sweepValue != 0) {
            mSweepValue = sweepValue;
        } else {
            mSweepValue = 25;
        }
        invalidate();
    }
}
