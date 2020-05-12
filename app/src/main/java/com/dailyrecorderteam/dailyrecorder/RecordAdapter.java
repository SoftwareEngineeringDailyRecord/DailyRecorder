package com.dailyrecorderteam.dailyrecorder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.litepal.crud.DataSupport;

import java.util.Calendar;
import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    static public final int CALORIE_RECORD = 1;
    static public final int BIGDAY_RECORD = 2;
    static public final int TODO_RECORD = 3;

    private List<MyRecord> mMyRecord;

    private Context mContext;

    static class CalorieViewHolder extends RecyclerView.ViewHolder{

        TextView foodText;
        TextView weightText;
        TextView calorieText;
        Button more;

        public CalorieViewHolder(View view){
            super(view);
            foodText = view.findViewById(R.id.text_food);
            weightText = view.findViewById(R.id.text_weight);
            calorieText = view.findViewById(R.id.text_calorie);
            more = view.findViewById(R.id.button_more_calorie);
        }
    }

    static class BigDayViewHolder extends RecyclerView.ViewHolder{

        TextView eventText;
        TextView dateText;
        TextView subDateText;
        Button more;

        public BigDayViewHolder(View view){
            super(view);
            eventText = (TextView) view.findViewById(R.id.text_bigday_event);
            dateText = (TextView) view.findViewById(R.id.text_bigday_date_show);
            subDateText = (TextView) view.findViewById(R.id.text_day_to_event);
            more = (Button) view.findViewById(R.id.button_more_bigday);
        }
    }

    static class TodoViewHolder extends RecyclerView.ViewHolder{

        TextView eventText;
        TextView tagText;
        TextView dateText;
        Button more;

        public TodoViewHolder(View view){
            super(view);
            eventText = (TextView) view.findViewById(R.id.text_todo_event);
            tagText = (TextView) view.findViewById(R.id.text_todo_tag);
            dateText = (TextView) view.findViewById(R.id.text_todo_date_show);
            more = (Button) view.findViewById(R.id.button_more_todo);
        }
    }

    public RecordAdapter(List<MyRecord> myList, Context context){
        mMyRecord = myList;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        if(viewType == BIGDAY_RECORD){
            View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bigdaysublayout, parent, false);
            final BigDayViewHolder viewHolder = new BigDayViewHolder(convertView);
            viewHolder.more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
                    alertDialog.setTitle("修改或删除");
                    alertDialog.setMessage("请选择你需要的操作");
                    alertDialog.setPositiveButton("删除", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            int position = viewHolder.getAdapterPosition();
                            BigdayRecord bigdayRecord = ((BigdayRecord)mMyRecord.get(position));
                            DataSupport.deleteAll(BigdayRecord.class,"id = ?",String.valueOf(bigdayRecord.getId()));
                            init();
                            RecordAdapter.super.notifyDataSetChanged();
                            Toast.makeText(mContext,"删除完成",Toast.LENGTH_SHORT).show();
                        }
                    });
                    alertDialog.setNegativeButton("修改", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(mContext,BigDayChanger.class);
                            int position = viewHolder.getAdapterPosition();
                            BigdayRecord bigdayRecord = ((BigdayRecord)mMyRecord.get(position));
                            intent.putExtra("record",bigdayRecord);
                            mContext.startActivity(intent);
                        }
                    });
                    alertDialog.show();

                }
            });
            return viewHolder;
        } else if(viewType == TODO_RECORD){
            View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.todosublayout, parent, false);
            final TodoViewHolder viewHolder = new TodoViewHolder(convertView);
            viewHolder.more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
                    alertDialog.setTitle("修改或删除");
                    alertDialog.setMessage("请选择你需要的操作");
                    alertDialog.setPositiveButton("删除", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            int position = viewHolder.getAdapterPosition();
                            TodoRecord todoRecord = ((TodoRecord)mMyRecord.get(position));
                            DataSupport.deleteAll(TodoRecord.class,"id = ?",String.valueOf(todoRecord.getId()));
                            init();
                            RecordAdapter.super.notifyDataSetChanged();
                            Toast.makeText(mContext,"删除完成",Toast.LENGTH_SHORT).show();
                        }
                    });
                    alertDialog.setNegativeButton("修改", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(mContext,TodoChanger.class);
                            int position = viewHolder.getAdapterPosition();
                            TodoRecord todoRecord = ((TodoRecord)mMyRecord.get(position));
                            intent.putExtra("record",todoRecord);
                            mContext.startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }
            });
            return viewHolder;
        } else if(viewType == CALORIE_RECORD){
            View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.caloriesublayout, parent, false);
            final CalorieViewHolder viewHolder = new CalorieViewHolder(convertView);
            viewHolder.more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
                    alertDialog.setTitle("修改或删除");
                    alertDialog.setMessage("请选择你需要的操作");
                    alertDialog.setPositiveButton("删除", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            int position = viewHolder.getAdapterPosition();
                            CalorieRecord calorieRecord = ((CalorieRecord)mMyRecord.get(position));
                            DataSupport.deleteAll(CalorieRecord.class,"id = ?",String.valueOf(calorieRecord.getId()));
                            init();
                            RecordAdapter.super.notifyDataSetChanged();
                            Toast.makeText(mContext,"删除完成",Toast.LENGTH_SHORT).show();
                        }
                    });
                    alertDialog.setNegativeButton("修改", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(mContext,CalorieChanger.class);
                            int position = viewHolder.getAdapterPosition();
                            CalorieRecord calorieRecord = ((CalorieRecord)mMyRecord.get(position));
                            intent.putExtra("record",calorieRecord);
                            mContext.startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }
            });
            return viewHolder;
        } else
            return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof BigDayViewHolder){
            BigdayRecord bigdayRecord = ((BigdayRecord)mMyRecord.get(position));
            ((BigDayViewHolder) holder).eventText.setText(bigdayRecord.getEvent());
            ((BigDayViewHolder) holder).dateText.setText(String.valueOf(TimeOperator.getYear(bigdayRecord.getBigDayTime()))+"年"+String.valueOf(TimeOperator.getMonth(bigdayRecord.getBigDayTime())+1)+"月"+String.valueOf(TimeOperator.getDay(bigdayRecord.getBigDayTime()))+"日");
            Calendar startCalender = Calendar.getInstance();
            Calendar endCalender = Calendar.getInstance();
            endCalender.set(TimeOperator.getYear(((BigdayRecord)mMyRecord.get(position)).getBigDayTime()),TimeOperator.getMonth(((BigdayRecord)mMyRecord.get(position)).getBigDayTime()),TimeOperator.getDay(((BigdayRecord)mMyRecord.get(position)).getBigDayTime()));
            int days = (int) ((endCalender.getTimeInMillis() - startCalender.getTimeInMillis()) / (24 * 60 * 60 * 1000.0));
            ((BigDayViewHolder) holder).subDateText.setText(String.valueOf(days));
        } else if (holder instanceof TodoViewHolder) {
            TodoRecord todoRecord = ((TodoRecord) mMyRecord.get(position));
            ((TodoViewHolder) holder).eventText.setText(todoRecord.getEvent());
            ((TodoViewHolder) holder).tagText.setText(todoRecord.getTag());
            ((TodoViewHolder) holder).dateText.setText(String.valueOf(TimeOperator.getYear(todoRecord.getDoTime())) + "年" + String.valueOf(TimeOperator.getMonth(todoRecord.getDoTime()) + 1) + "月" + String.valueOf(TimeOperator.getDay(todoRecord.getDoTime())) + "日");
        } else if (holder instanceof CalorieViewHolder){
            CalorieRecord calorieRecord = ((CalorieRecord) mMyRecord.get(position));
            ((CalorieViewHolder) holder).foodText.setText(calorieRecord.getFood());
            ((CalorieViewHolder) holder).weightText.setText(String.valueOf(calorieRecord.getWeight()) + " g");
            ((CalorieViewHolder) holder).calorieText.setText(String.valueOf(calorieRecord.getCalorie()));
        }
    }

    @Override
    public int getItemCount() {
        return mMyRecord.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(mMyRecord.get(position) instanceof BigdayRecord){
            return BIGDAY_RECORD;
        } else if(mMyRecord.get(position) instanceof  TodoRecord){
            return TODO_RECORD;
        } else
            return CALORIE_RECORD;
    }

    public void init(){
        mMyRecord.clear();
        List<BigdayRecord> bigdayRecordList = DataSupport.where("bigDayTime > ?",String.valueOf(TimeOperator.getNowTime())).find(BigdayRecord.class);
        for(BigdayRecord record:bigdayRecordList){
            mMyRecord.add((MyRecord)record);
        }

        List<TodoRecord> todoRecordList = DataSupport.where("doTime > ?",String.valueOf(TimeOperator.getNowTime())).find(TodoRecord.class);
        for(TodoRecord record:todoRecordList){
            mMyRecord.add((MyRecord)record);
        }

        List<CalorieRecord> calorieRecordList = DataSupport.findAll(CalorieRecord.class);
        for(CalorieRecord record:calorieRecordList){
            mMyRecord.add((MyRecord)record);
        }
    }
}
