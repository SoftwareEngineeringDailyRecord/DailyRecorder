package com.dailyrecorderteam.dailyrecorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private List<CalorieRecord> mCalorirList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.mainactivitylayout);
        init();
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecordAdapter(mCalorirList);
        recyclerView.setAdapter(adapter);
    }

    private void init1(){
        CalorieRecord cr1 = new CalorieRecord("香蕉",100,30);
        mCalorirList.add(cr1);
        CalorieRecord cr2 = new CalorieRecord("橘子",120,50);
        mCalorirList.add(cr2);
        CalorieRecord cr3 = new CalorieRecord("宫保鸡丁",60,70);
        mCalorirList.add(cr3);
        CalorieRecord cr4 = new CalorieRecord("桃子",70,45);
        mCalorirList.add(cr4);
        CalorieRecord cr5 = new CalorieRecord("水",80,1145);
        mCalorirList.add(cr5);
        CalorieRecord cr6 = new CalorieRecord("牛奶",150,20);
        mCalorirList.add(cr6);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()):

    }

    /**
     * 用于切换到选择页面（selectionactivity），使用intent，并且需要把结果传回来加入list No 2.1
     */
    public void swithContent(){

    }

    /**
     * 只从calorie数据库取数据，初始化List No 2.2
     */
    public void init(){

    }

    /**
     * 获取当前系统日期
     * @return 返回的数据格式为2018年7月19日 No 2.3
     */
    public String getTime(){
    }
}
