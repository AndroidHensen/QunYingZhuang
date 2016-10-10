package com.handsome.qunyingzhuang.chapter_4.Anli04;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.handsome.qunyingzhuang.R;

import java.util.List;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2016/10/8.
 */
public class DongTaiListViewAdapter extends BaseAdapter {

    private List<String> list;
    private Context mContext;
    private int mCurrentItem=0;

    public DongTaiListViewAdapter(Context context, List<String> list) {
        this.list = list;
        this.mContext = context;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layout = new LinearLayout(mContext);
        layout.setOrientation(LinearLayout.VERTICAL);
        if (mCurrentItem == position) {
            layout.addView(addFocusView(position));
        } else {
            layout.addView(addNormalView(position));
        }
        return layout;
    }

    private View addFocusView(int i) {
        ImageView iv = new ImageView(mContext);
        iv.setImageResource(R.mipmap.ic_launcher);
        return iv;
    }

    private View addNormalView(int i) {
        LinearLayout layout = new LinearLayout(mContext);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        ImageView iv = new ImageView(mContext);
        iv.setImageResource(R.mipmap.ic_launcher);
        layout.addView(iv, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        TextView tv = new TextView(mContext);
        tv.setText(list.get(i));
        layout.addView(tv, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.setGravity(Gravity.CENTER);
        return layout;
    }

    public void setCurrentItem(int position) {
        mCurrentItem = position;
    }
}
