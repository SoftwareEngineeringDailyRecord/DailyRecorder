package com.dailyrecorderteam.dailyrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.sql.Time;
import java.util.Calendar;

public class BigDayChanger extends AppCompatActivity {

    private BigdayRecord mbigdayRecord;

    private int mYear = 0;
    private int mMonth = 0;
    private int mDay = 0;

    private String event;

    private Button pickTimeButton;
    private Button okButton;
    private TextView selectTime;
    private EditText eventText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.bigdayeditoractivity);
        mbigdayRecord = (BigdayRecord) getIntent().getSerializableExtra("record");
        mYear = TimeOperator.getYear(mbigdayRecord.getBigDayTime());
        mMonth = TimeOperator.getMonth(mbigdayRecord.getBigDayTime());
        mDay = TimeOperator.getDay(mbigdayRecord.getBigDayTime());

        pickTimeButton = (Button) findViewById(R.id.button_time_selet);
        okButton = (Button) findViewById(R.id.button_bigday_ok);

        eventText = (EditText) findViewById(R.id.edit_bigdayevent);
        selectTime = (TextView) findViewById(R.id.text_bigday_date);

        selectTime.setText(String.valueOf(mYear)+"年"+String.valueOf(mMonth+1)+"月"+String.valueOf(mDay)+"日");
        eventText.setText(mbigdayRecord.getEvent());

        pickTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Year = TimeOperator.getYear(mbigdayRecord.getBigDayTime());
                int Month = TimeOperator.getMonth(mbigdayRecord.getBigDayTime());
                int Day = TimeOperator.getDay(mbigdayRecord.getBigDayTime());

                DatePickerDialog datePickerDialog = new DatePickerDialog(BigDayChanger.this, new DatePickerDialog.OnDateSetListener() {
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
                if(!eventText.getText().toString().isEmpty()&&mYear!=0&&mDay!=0&&mMonth!=0){
                    Connector.getWritableDatabase();
                    BigdayRecord bigdayRecord = new BigdayRecord();
                    bigdayRecord.setEvent(eventText.getText().toString());
                    bigdayRecord.setBigDayTime(TimeOperator.toLongtime(mYear,mMonth,mDay,0,0,0));
                    Log.d("huchengyang",String.valueOf(mbigdayRecord.getId()));
                    bigdayRecord.updateAll("id = ?",String.valueOf(mbigdayRecord.getId()));
                    Log.d("huchengyang","OK");
                    Toast.makeText(BigDayChanger.this,"已更新纪录",Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(BigDayChanger.this,"有值为空",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
