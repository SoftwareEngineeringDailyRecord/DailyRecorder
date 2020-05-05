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

public class TodoEditor extends AppCompatActivity {

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
        event = (EditText) findViewById(R.id.edit_todoevent);
        tag = (EditText) findViewById(R.id.edit_tag);
        pickTimeButton = (Button) findViewById(R.id.button_time_selet_todo);
        okButton = (Button) findViewById(R.id.button_todo_ok);
        selectTime = (TextView) findViewById(R.id.text_todo_date);

        pickTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar ca = Calendar.getInstance();
                int Year = ca.get(Calendar.YEAR);
                int Month = ca.get(Calendar.MONTH);
                int Day = ca.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(TodoEditor.this, new DatePickerDialog.OnDateSetListener() {
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
                    todoRecord.setType(MyRecord.TODO_RECORD);
                    Calendar ca = Calendar.getInstance();
                    todoRecord.setEvent(event.getText().toString());
                    todoRecord.setTag(tag.getText().toString());
                    todoRecord.setDoTime(TimeOperator.toLongtime(mYear,mMonth,mDay,0,0,0));
                    int Year = ca.get(Calendar.YEAR);
                    int Month = ca.get(Calendar.MONTH);
                    int Day = ca.get(Calendar.DAY_OF_MONTH);
                    int Hour = ca.get(Calendar.HOUR_OF_DAY);
                    int Minute = ca.get(Calendar.MINUTE);
                    int Second = ca.get(Calendar.SECOND);
                    todoRecord.setYear(Year);
                    todoRecord.setMonth(Month);
                    todoRecord.setDay(Day);
                    todoRecord.setHour(Hour);
                    todoRecord.setMinute(Minute);
                    todoRecord.setSecond(Second);
                    todoRecord.setTime(TimeOperator.toLongtime(Year,Month,Day,Hour,Minute,Second));
                    todoRecord.save();
                    Toast.makeText(TodoEditor.this,"已储存新纪录",Toast.LENGTH_SHORT).show();
                    finish();
                } else{
                    Toast.makeText(TodoEditor.this,"有值为空",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
