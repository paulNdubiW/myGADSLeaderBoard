package com.example.leaderboard;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URL;
import java.util.ArrayList;
//import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    private View mRoot;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        mRoot = inflater.inflate(R.layout.fragment_main, container, false);
        URL learnUrl = ApiUtil.buildUrl("hours");
        new LearnerQueryTask().execute(learnUrl);
        return mRoot;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
//            }
//        });
    }
    public class LearnerQueryTask extends AsyncTask<URL,Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl = urls[0];
            String result = null;
            try{
                result = ApiUtil.getJson(searchUrl);
            }
            catch(Exception e){
                Log.e("Error", e.getMessage());
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {

            final RecyclerView recyclerLearner = (RecyclerView) mRoot.findViewById(R.id.list_items);
            final LinearLayoutManager learnerLayoutManager = new LinearLayoutManager(mRoot.getContext());
            recyclerLearner.setLayoutManager(learnerLayoutManager);

            ArrayList<Hours> learnerHours = ApiUtil.getHoursFromJson(result);
            LearnerRecyclerAdapter learnerRecyclerAdapter = new LearnerRecyclerAdapter(mRoot.getContext(), learnerHours);
            recyclerLearner.setAdapter(learnerRecyclerAdapter);




        }
    }
}