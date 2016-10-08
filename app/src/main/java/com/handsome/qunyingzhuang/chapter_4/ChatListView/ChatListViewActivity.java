package com.handsome.qunyingzhuang.chapter_4.ChatListView;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.handsome.qunyingzhuang.R;

import java.util.ArrayList;
import java.util.List;

public class ChatListViewActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list_view);

        mListView = (ListView) findViewById(R.id.lv_chat);
        ChatItemListViewBean bean1 = new ChatItemListViewBean();
        bean1.setType(0);
        bean1.setIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        bean1.setText("hello how are you?");

        ChatItemListViewBean bean2 = new ChatItemListViewBean();
        bean2.setType(1);
        bean2.setIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        bean2.setText("find thank you ,and you?");

        List<ChatItemListViewBean> data = new ArrayList<>();
        data.add(bean1);
        data.add(bean2);

        ChatListViewAdapter adapter = new ChatListViewAdapter(this, data);
        mListView.setAdapter(adapter);
    }
}
