package com.dailyrecorderteam.dailyrecorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private List<MyRecord> mMyList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecordAdapter adapter;
    private Button editButton;
    private TextView dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.mainactivitylayout);
        Connector.getDatabase();
        init();

        editButton = (Button) findViewById(R.id.button_edit);

        dateText = (TextView) findViewById(R.id.text_date);

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecordAdapter(mMyList,MainActivity.this);
        recyclerView.setAdapter(adapter);

        editButton.setOnClickListener(this);

        dateText.setText(getTime());
    }

    /*private void init1(){
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

    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_edit:
                switchEditStage();
                break;
            default:
                break;
        }
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
        mMyList.clear();
        List<BigdayRecord> bigdayRecordList = DataSupport.where("bigDayTime > ?",String.valueOf(TimeOperator.getNowTime())).find(BigdayRecord.class);
        for(BigdayRecord record:bigdayRecordList){
            mMyList.add((MyRecord)record);
        }

        List<TodoRecord> todoRecordList = DataSupport.where("doTime > ?",String.valueOf(TimeOperator.getNowTime())).find(TodoRecord.class);
        for(TodoRecord record:todoRecordList){
            mMyList.add((MyRecord)record);
        }

        List<CalorieRecord> calorieRecordList = DataSupport.findAll(CalorieRecord.class);
        for(CalorieRecord record:calorieRecordList){
            mMyList.add((MyRecord)record);
        }
    }

    /**
     * 获取当前系统日期
     * @return 返回的数据格式为2018年7月19日 No 2.3
     */
    public String getTime(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        return String.valueOf(year)+"年"+String.valueOf(month+1)+"月"+String.valueOf(day)+"日";
    }

    public void switchEditStage(){
        Intent intent = new Intent(MainActivity.this, SelectionActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onStart() {
        super.onStart();
        init();
        adapter.notifyDataSetChanged();
    }
}
