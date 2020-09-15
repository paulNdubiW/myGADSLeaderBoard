package com.example.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LearnerRecyclerAdapter extends RecyclerView.Adapter<LearnerRecyclerAdapter.ViewHolder> {
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private final ArrayList<Hours> mLearnerHours;


    public LearnerRecyclerAdapter(Context context, ArrayList<Hours> learnerHours) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.mLearnerHours = learnerHours;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = mLayoutInflater.inflate(R.layout.list_learners,parent,false);
       return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hours singleLearnerHours = mLearnerHours.get(position);
        String details =  singleLearnerHours.mHours
                + " learning hours, "
                + singleLearnerHours.mCountry
                + ".";
        holder.mLearnerName.setText(singleLearnerHours.mName);
        holder.mLearningDetails.setText(details);

    }

    @Override
    public int getItemCount() {
        return mLearnerHours.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public final TextView mLearnerName;
        public final TextView mLearningDetails;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mLearnerName = (TextView) itemView.findViewById(R.id.learner_name);
            mLearningDetails = (TextView) itemView.findViewById(R.id.learning_details);
        }
    }
}
