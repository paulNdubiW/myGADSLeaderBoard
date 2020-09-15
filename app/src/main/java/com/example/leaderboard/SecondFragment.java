package com.example.leaderboard;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
//import androidx.navigation.fragment.NavHostFragment;

import java.net.URL;
import java.util.ArrayList;

public class SecondFragment extends Fragment {

    private View mRoot;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        mRoot = inflater.inflate(R.layout.fragment_main, container, false);
        URL learnUrl = ApiUtil.buildUrl("skilliq");
        new LearnerQueryTask().execute(learnUrl);
        return mRoot;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(SecondFragment.this)
//                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
//            }
//        });
    }

    public class LearnerQueryTask extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl = urls[0];
            String result = null;
            try {
                result = ApiUtil.getJson(searchUrl);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            final RecyclerView recyclerLearner = (RecyclerView) mRoot.findViewById(R.id.list_items);
            final LinearLayoutManager learnerLayoutManager = new LinearLayoutManager(mRoot.getContext());
            recyclerLearner.setLayoutManager(learnerLayoutManager);

            ArrayList<Scores> learnerScore = ApiUtil.getScoresFromJson(result);
            ScoreRecyclerAdapter scoreRecyclerAdapter = new ScoreRecyclerAdapter(mRoot.getContext(), learnerScore);
            recyclerLearner.setAdapter(scoreRecyclerAdapter);
        }
    }
}