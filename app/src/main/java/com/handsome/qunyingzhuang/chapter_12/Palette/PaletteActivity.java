package com.handsome.qunyingzhuang.chapter_12.Palette;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.Window;

import com.handsome.qunyingzhuang.R;


public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.palette);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.test);
        // 创建Palette对象
        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                // 通过Palette来获取对应的色调
                Palette.Swatch vibrant =
                        palette.getDarkVibrantSwatch();
                // 将颜色设置给相应的组件
                getSupportActionBar().setBackgroundDrawable(
                        new ColorDrawable(vibrant.getRgb()));
                Window window = getWindow();
                window.setStatusBarColor(vibrant.getRgb());
            }
        });
    }
}
