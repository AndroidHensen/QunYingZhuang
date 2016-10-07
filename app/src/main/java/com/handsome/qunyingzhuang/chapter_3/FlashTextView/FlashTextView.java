package com.handsome.qunyingzhuang.chapter_3.FlashTextView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2016/10/7.
 */
public class FlashTextView extends TextView {

    int mViewWidth = 0;
    private Paint mPaint;
    private LinearGradient mLinearGradient;
    private Matrix matrix;
    private int mTranslate;

    public FlashTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(0, 0, mViewWidth, 0, new int[]{Color.BLUE, 0xffffffff, Color.BLUE},
                        null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                matrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (matrix != null) {
            mTranslate += mViewWidth + 5;
            if (mTranslate > 2 * mViewWidth / 5) {
                mTranslate = -mViewWidth;
            }
            matrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(matrix);
            postInvalidateDelayed(100);
        }
    }
}
