package com.handsome.qunyingzhuang.chapter_12.animated_selector;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.handsome.qunyingzhuang.R;

public class AnimatedSelectorActivity extends AppCompatActivity {

    private boolean mIsCheck;
    private static final int[] STATE_CHECKED = new int[]{
            android.R.attr.state_checked};
    private static final int[] STATE_UNCHECKED = new int[]{};
    private ImageView mImageView;
    private Drawable mDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_selector);
        mImageView = (ImageView) findViewById(R.id.image);
        mDrawable = getResources().getDrawable(
                R.drawable.fab_anim);
        mImageView.setImageDrawable(mDrawable);
    }

    public void anim(View view) {
        if (mIsCheck) {
            mImageView.setImageState(STATE_UNCHECKED, true);
            mIsCheck = false;
        } else {
            mImageView.setImageState(STATE_CHECKED, true);
            mIsCheck = true;
        }
    }
}