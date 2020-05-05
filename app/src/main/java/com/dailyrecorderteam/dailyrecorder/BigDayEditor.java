package com.dailyrecorderteam.dailyrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.tablemanager.Connector;

import java.util.Calendar;

public class BigDayEditor extends AppCompatActivity {

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
        pickTimeButton = (Button) findViewById(R.id.button_time_selet);
        okButton = (Button) findViewById(R.id.button_bigday_ok);

        eventText = (EditText) findViewById(R.id.edit_bigdayevent);
        selectTime = (TextView) findViewById(R.id.text_bigday_date);

        pickTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar ca = Calendar.getInstance();
                int Year = ca.get(Calendar.YEAR);
                int Month = ca.get(Calendar.MONTH);
                int Day = ca.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(BigDayEditor.this, new DatePickerDialog.OnDateSetListener() {
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
                    Connector.getDatabase();
                    BigdayRecord bigdayRecord = new BigdayRecord();
                    bigdayRecord.setType(MyRecord.BIGDAY_RECORD);
                    Calendar ca = Calendar.getInstance();
                    bigdayRecord.setEvent(eventText.getText().toString());
                    bigdayRecord.setBigDayTime(TimeOperator.toLongtime(mYear,mMonth,mDay,0,0,0));
                    int Year = ca.get(Calendar.YEAR);
                    int Month = ca.get(Calendar.MONTH);
                    int Day = ca.get(Calendar.DAY_OF_MONTH);
                    int Hour = ca.get(Calendar.HOUR_OF_DAY);
                    int Minute = ca.get(Calendar.MINUTE);
                    int Second = ca.get(Calendar.SECOND);
                    bigdayRecord.setYear(Year);
                    bigdayRecord.setMonth(Month);
                    bigdayRecord.setDay(Day);
                    bigdayRecord.setHour(Hour);
                    bigdayRecord.setMinute(Minute);
                    bigdayRecord.setSecond(Second);
                    bigdayRecord.setTime(TimeOperator.toLongtime(Year,Month,Day,Hour,Minute,Second));
                    bigdayRecord.save();
                    Toast.makeText(BigDayEditor.this,"已储存新纪录",Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(BigDayEditor.this,"有值为空",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
