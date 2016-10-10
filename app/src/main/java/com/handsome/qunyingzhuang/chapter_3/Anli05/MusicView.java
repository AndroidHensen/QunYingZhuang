package com.handsome.qunyingzhuang.chapter_3.Anli05;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2016/10/7.
 */
public class MusicView extends View {

    private int mWidth;
    private int mRectHeight;
    private int mRectWidth;
    private int mRectCount = 20;
    private LinearGradient mLinearGradient;
    private Paint mPaint=new Paint();

    private float currentHeight;
    private int offset = 5;
    private double mRandom;

    public MusicView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getWidth();
        mRectHeight = getHeight();
        mRectWidth = (int) (mWidth * 0.6 / mRectCount);
        mLinearGradient = new LinearGradient(0, 0, mRectWidth, mRectHeight, Color.YELLOW, Color.BLUE, Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //遍历绘制矩形，留中间间隔
        for (int i = 0; i < mRectCount; i++) {
            //开始绘制
            canvas.drawRect((float) (mWidth * 0.4 / 2 + mRectWidth * i + offset),
                    currentHeight, (float) (mWidth * 0.4 / 2 + mRectWidth * (i + 1)), mRectHeight, mPaint);
        }
        //获取随机数
        mRandom = Math.random();
        currentHeight = ((float) (mRectHeight * mRandom));
        //延迟300去刷新
        postInvalidateDelayed(300);
    }

}
