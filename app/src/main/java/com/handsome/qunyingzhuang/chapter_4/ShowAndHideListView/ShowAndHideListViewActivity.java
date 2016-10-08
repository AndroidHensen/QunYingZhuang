package com.handsome.qunyingzhuang.chapter_4.ShowAndHideListView;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.handsome.qunyingzhuang.R;

import java.util.List;

public class ShowAndHideListViewActivity extends AppCompatActivity {

    private int mTouchSlop;
    private ObjectAnimator mAnimator;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_and_hide_list_view);
        //添加头部
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        //填充布局
        ListView mListView = (ListView) findViewById(R.id.lv);
        String[] str = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        mListView.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.tv, str));
        //添加头布局，防止第一条数据被遮盖
        View header = new View(this);
        header.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
                (int) getResources().getDimension(android.support.v7.
                        appcompat.R.dimen.abc_action_bar_default_height_material)));
        mListView.addHeaderView(header);
        //获得TouchSlop
        mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        //设置监听
        mListView.setOnTouchListener(myTouchListener);
    }

    View.OnTouchListener myTouchListener = new View.OnTouchListener() {

        public boolean mShow;
        public int direction;
        public float mCurrentY;
        public float mFirstY;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mFirstY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    mCurrentY = event.getY();
                    if (mCurrentY - mFirstY > mTouchSlop) {
                        direction = 0;//down
                    } else if (mFirstY - mCurrentY > mTouchSlop) {
                        direction = 1;//up
                    }
                    if (direction == 1) {
                        if (mShow) {
                            toolBarAnim(0);//hide
                            mShow = !mShow;
                        }
                    } else if (direction == 0) {
                        if (!mShow) {
                            toolBarAnim(1);//up
                            mShow = !mShow;
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:

                    break;
            }
            return false;
        }
    };

    private void toolBarAnim(int flag) {
        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();
        }
        if (flag == 0) {
            //up:hide
            mAnimator = ObjectAnimator.ofFloat(mToolBar, "translationY", -mToolBar.getHeight());
        } else {
            //down:show
            mAnimator = ObjectAnimator.ofFloat(mToolBar, "translationY", -mToolBar.getHeight(),0);
        }
        mAnimator.start();
    }

}
