package com.handsome.qunyingzhuang.chapter_3.CircleView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.handsome.qunyingzhuang.R;

public class CirCleProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cir_cle_progress);

        CircleProgressView circleProgressView = (CircleProgressView) findViewById(R.id.circle);
        circleProgressView.setSweepValue(270);
    }
}
