package com.handsome.qunyingzhuang.chapter_7;

import android.graphics.drawable.Animatable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.handsome.qunyingzhuang.R;

public class SVGText01Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svgtext01);

        ImageView image = (ImageView) findViewById(R.id.image);
        ((Animatable)image.getDrawable()).start();
    }
}
