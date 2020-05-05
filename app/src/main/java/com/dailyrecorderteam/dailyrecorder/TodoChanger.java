package com.dailyrecorderteam.dailyrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.tablemanager.Connector;

import java.util.Calendar;

public class TodoChanger extends AppCompatActivity {

    private TodoRecord mTodoRecord;

    private int mYear = 0;
    private int mMonth = 0;
    private int mDay = 0;

    private EditText event;
    private EditText tag;
    private TextView selectTime;
    private Button pickTimeButton;
    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.todoeditoractivity);
        mTodoRecord = (TodoRecord) getIntent().getSerializableExtra("record");
        event = (EditText) findViewById(R.id.edit_todoevent);
        tag = (EditText) findViewById(R.id.edit_tag);
        pickTimeButton = (Button) findViewById(R.id.button_time_selet_todo);
        okButton = (Button) findViewById(R.id.button_todo_ok);
        selectTime = (TextView) findViewById(R.id.text_todo_date);

        mYear = TimeOperator.getYear(mTodoRecord.getDoTime());
        mMonth = TimeOperator.getMonth(mTodoRecord.getDoTime());
        mDay = TimeOperator.getDay(mTodoRecord.getDoTime());
        event.setText(mTodoRecord.getEvent());
        tag.setText(mTodoRecord.getTag());
        selectTime.setText(String.valueOf(mYear)+"年"+String.valueOf(mMonth+1)+"月"+String.valueOf(mDay)+"日");

        pickTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Year = TimeOperator.getYear(mTodoRecord.getDoTime());
                int Month = TimeOperator.getMonth(mTodoRecord.getDoTime());
                int Day = TimeOperator.getDay(mTodoRecord.getDoTime());

                DatePickerDialog datePickerDialog = new DatePickerDialog(TodoChanger.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mYear = year;
                        mMonth = month;
                        mDay = dayOfMonth;
                        selectTime.setText(String.valueOf(year)+"年"+String.valueOf(month+1)+"月"+String.valueOf(dayOfMonth)+"日");
                    }
                },Year,Month,Day);
                datePickerDialog.show();
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!event.getText().toString().isEmpty()&&!tag.getText().toString().isEmpty()&&mYear!=0&&mDay!=0&&mMonth!=0){
                    Connector.getDatabase();
                    TodoRecord todoRecord = new TodoRecord();
                    todoRecord.setEvent(event.getText().toString());
                    todoRecord.setTag(tag.getText().toString());
                    todoRecord.setDoTime(TimeOperator.toLongtime(mYear,mMonth,mDay,0,0,0));
                    todoRecord.updateAll("id = ?",String.valueOf(mTodoRecord.getId()));
                    Toast.makeText(TodoChanger.this,"已更新纪录",Toast.LENGTH_SHORT).show();
                    finish();
                } else{
                    Toast.makeText(TodoChanger.this,"有值为空",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
