package com.example.leaderboard.ui.main;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.leaderboard.ApiUtil;
import com.example.leaderboard.R;

import java.net.URL;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private View mRoot;
//    private static final String TAG = PlaceholderFragment.class.getSimpleName();

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
           @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
//        Log.i(TAG, ">>>>>****     ONCREATEVIEW START - Thread " + Thread.currentThread().getId() + "     ****<<<<<<");
//        mRoot = inflater.inflate(R.layout.fragment_main, container, false);
//        final TextView tvResult = mRoot.findViewById(R.id.tvResponse);
//        try{
//            URL learnUrl = ApiUtil.buildUrl("hours");
//            URL searchUrl = learnUrl;
//            String result = null;
//            result = ApiUtil.getJson(searchUrl);
//            tvResult.setText(result);
//        }
//        catch (Exception e){
//            Log.d("Error", e.getMessage());
//        }
//            pageViewModel.getText().observe(this, new Observer<String>() {
//          @Override
//            public void onChanged(@Nullable String s) {
//                tvResult.setText(s);
//            }
//        });


//        final TextView textView = root.findViewById(R.id.section_label);
//        pageViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//            Log.i(TAG, ">>>>>>****       ONCREATEVIEW END      ******<<<<<<<");
        return mRoot;
    }

}