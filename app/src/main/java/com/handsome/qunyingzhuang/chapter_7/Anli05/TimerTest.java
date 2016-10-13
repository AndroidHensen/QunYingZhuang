package com.handsome.qunyingzhuang.chapter_7.Anli05;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.handsome.qunyingzhuang.R;

public class TimerTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);
    }

    public void tvTimer(final View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.addUpdateListener(
                new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ((TextView) view).setText("$ " +
                        (Integer) animation.getAnimatedValue());
            }
        });
        valueAnimator.setDuration(3000);
        valueAnimator.start();
    }
}
