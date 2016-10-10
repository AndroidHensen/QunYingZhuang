package com.handsome.qunyingzhuang.chapter_3.Anli01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2016/10/7.
 */
public class CustomTextView extends TextView {

    private Paint paint1, paint2;

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        paint1 = new Paint();
        paint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        paint1.setStyle(Paint.Style.FILL);
        paint2 = new Paint();
        paint2.setColor(Color.YELLOW);
        paint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //绘制外层矩形
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint1);
        //绘制内层矩形
        canvas.drawRect(10, 10, getMeasuredWidth() - 10, getMeasuredHeight() - 10, paint2);
        canvas.save();
        //绘制文字前平移10像素
        canvas.translate(10, 0);
        //父类完成的方法，即绘制文本
        super.onDraw(canvas);
        canvas.restore();
    }
}
