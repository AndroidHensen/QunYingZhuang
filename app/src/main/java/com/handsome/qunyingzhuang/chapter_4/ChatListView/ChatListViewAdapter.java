package com.handsome.qunyingzhuang.chapter_4.ChatListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.handsome.qunyingzhuang.R;

import java.util.List;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2016/10/8.
 */
public class ChatListViewAdapter extends BaseAdapter {

    private List<ChatItemListViewBean> mData;
    private LayoutInflater mInflater;

    public ChatListViewAdapter(Context context, List<ChatItemListViewBean> mData) {
        this.mData = mData;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            if (getItemViewType(position) == 0) {
                viewHolder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.left_item, null);
                viewHolder.icon = (ImageView) convertView.findViewById(R.id.left_icon);
                viewHolder.text = (TextView) convertView.findViewById(R.id.tv_left);
            } else {
                viewHolder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.right_item, null);
                viewHolder.icon = (ImageView) convertView.findViewById(R.id.right_icon);
                viewHolder.text = (TextView) convertView.findViewById(R.id.tv_right);
            }
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.icon.setImageBitmap(mData.get(position).getIcon());
        viewHolder.text.setText(mData.get(position).getText());

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        ChatItemListViewBean bean = mData.get(position);
        return bean.getType();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    public final class ViewHolder {
        public ImageView icon;
        public TextView text;
    }
}
