package com.dailyrecorderteam.dailyrecorder;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.litepal.tablemanager.Connector;

public class CalorieChanger extends AppCompatActivity {
    private CalorieRecord mCalorieRecord;
    private String mFood;
    private int mWeight;
    private int mCalorie;

    private EditText foodEdit;
    private EditText weightEdit;
    private EditText calorieEdit;
    private Button okButton;
    private boolean weightIsInt = true;
    private boolean calorieIsInt = true;
    private int weight = 0;
    private int calorie = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.calorieeditorlayout);
        foodEdit = (EditText) findViewById(R.id.edit_food);
        weightEdit = (EditText) findViewById(R.id.edit_weight);
        calorieEdit = (EditText) findViewById(R.id.edit_calorie);
        okButton = (Button) findViewById(R.id.calorie_ok);

        mCalorieRecord = (CalorieRecord) getIntent().getSerializableExtra("record");
        mFood=mCalorieRecord.getFood();
        mWeight=mCalorieRecord.getWeight();
        mCalorie=mCalorieRecord.getCalorie();
        foodEdit.setText(mFood);
        weightEdit.setText(String.valueOf(mWeight));
        calorieEdit.setText(String.valueOf(mCalorie));

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String food = foodEdit.getText().toString();
                String strWeight=weightEdit.getText().toString();
                String strCalorie=calorieEdit.getText().toString();
                weightIsInt = true;
                calorieIsInt = true;

                try {
                    weight = Integer.valueOf(strWeight).intValue();
                }
                catch (NumberFormatException e) {
                    Toast.makeText(CalorieChanger.this,"重量值必须为整数",Toast.LENGTH_SHORT).show();
                    weightIsInt = false;
                }
                try {
                    calorie = Integer.valueOf(strCalorie).intValue();
                }
                catch (NumberFormatException e) {
                    Toast.makeText(CalorieChanger.this,"卡路里值必须为整数",Toast.LENGTH_SHORT).show();
                    calorieIsInt = false;
                }

                if(!food.isEmpty()&&weightIsInt&&calorieIsInt){
                    Connector.getWritableDatabase();
                    CalorieRecord calorieRecord = new CalorieRecord(food, weight, calorie);
                    Log.d("huchengyang",String.valueOf(mCalorieRecord.getId()));
                    calorieRecord.updateAll("id = ?",String.valueOf(mCalorieRecord.getId()));
                    Log.d("huchengyang","OK");
                    Toast.makeText(CalorieChanger.this,"已更新纪录",Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(CalorieChanger.this,"有值为空或不符合规范",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
