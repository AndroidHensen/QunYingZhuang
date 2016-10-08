package com.handsome.qunyingzhuang.chapter_4.DongTaiListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.handsome.qunyingzhuang.R;

import java.util.ArrayList;
import java.util.List;

public class DongTaiListViewActivity extends AppCompatActivity {

    private DongTaiListViewAdapter adapter;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dong_tai_list_view);

        ListView listView = (ListView) findViewById(R.id.lv_dongtai);
        list = new ArrayList<>();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        list.add("item4");
        adapter = new DongTaiListViewAdapter(this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.setCurrentItem(position);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
