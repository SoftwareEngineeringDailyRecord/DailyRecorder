package com.dailyrecorderteam.dailyrecorder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder> {

    private List<CalorieRecord> mCalorieRecord;

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView foodText;
        TextView weightText;
        TextView calorieText;

        public ViewHolder(View view){
            super(view);
            foodText = view.findViewById(R.id.text_food);
            weightText = view.findViewById(R.id.text_weight);
            calorieText = view.findViewById(R.id.text_calorie);
        }
    }

    public RecordAdapter(List<CalorieRecord> CalorieRecordList){
        mCalorieRecord = CalorieRecordList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.caloriesublayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CalorieRecord calorieRecord = mCalorieRecord.get(position);
        holder.foodText.setText(calorieRecord.getFood());
        holder.weightText.setText(String.valueOf(calorieRecord.getWeight())+"g");
        holder.calorieText.setText(String.valueOf(calorieRecord.getCalorie()));
    }

    @Override
    public int getItemCount() {
        return mCalorieRecord.size();
    }
}
