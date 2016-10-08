package com.handsome.qunyingzhuang.chapter_4.TanXingListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;

import com.handsome.qunyingzhuang.R;

public class TanXingListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tan_xing_list_view);

        TanXingListView lv = (TanXingListView) findViewById(R.id.listview);
        String[] str = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        lv.setAdapter(new ArrayAdapter<>(this, R.layout.list_item, R.id.tv, str));
    }
}
