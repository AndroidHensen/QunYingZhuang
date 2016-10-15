package com.handsome.qunyingzhuang.chapter_12.Clipping;

import android.graphics.Outline;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;

import com.handsome.qunyingzhuang.R;

public class Clipping extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clipping);
        View v1 = findViewById(R.id.tv_rect);
        View v2 = findViewById(R.id.tv_circle);
        //获取Outline
        ViewOutlineProvider viewOutlineProvider1 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                //修改outline为特定形状
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 30);
            }
        };
        //获取Outline
        ViewOutlineProvider viewOutlineProvider2 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                //修改outline为特定形状
                outline.setOval(0, 0, view.getWidth(), view.getHeight());
            }
        };
        //重新设置形状
        v1.setOutlineProvider(viewOutlineProvider1);
        v2.setOutlineProvider(viewOutlineProvider2);
    }
}
