package com.dailyrecorderteam.dailyrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SelectionActivity extends AppCompatActivity {

    private String data[] = {"卡路里记录","纪念日记录","To-do记录"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.selectionactivity);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SelectionActivity.this,
                android.R.layout.simple_expandable_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.list_selection);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(SelectionActivity.this, CalorieEditor.class));
                        break;
                    case 1:
                        startActivity(new Intent(SelectionActivity.this, BigDayEditor.class));
                        break;
                    case 2:
                        startActivity(new Intent(SelectionActivity.this, TodoEditor.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }

}
