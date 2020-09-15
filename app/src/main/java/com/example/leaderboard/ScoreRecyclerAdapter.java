package com.example.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScoreRecyclerAdapter extends RecyclerView.Adapter<ScoreRecyclerAdapter.ViewHolder> {
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private final ArrayList<Scores> mLearnerScores;


    public ScoreRecyclerAdapter(Context context, ArrayList<Scores> learnerScores) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.mLearnerScores = learnerScores;
    }

    @NonNull
    @Override
    public ScoreRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.list_scores, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreRecyclerAdapter.ViewHolder holder, int position) {
        Scores singleScoreHours = mLearnerScores.get(position);
        String details =  singleScoreHours.mScore
                + " skill IQ Score, "
                + singleScoreHours.mCountry
                + ".";
        holder.mScoreName.setText(singleScoreHours.mName);
        holder.mScoreDetails.setText(details);

    }

    @Override
    public int getItemCount() {
        return mLearnerScores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public final TextView mScoreName;
        public final TextView mScoreDetails;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mScoreName = (TextView) itemView.findViewById(R.id.score_learner_name);
            mScoreDetails = (TextView) itemView.findViewById(R.id.score_learner_detail);
        }
    }
}
