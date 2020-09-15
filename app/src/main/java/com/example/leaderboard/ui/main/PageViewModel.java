package com.example.leaderboard.ui.main;

import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.leaderboard.ApiUtil;

import java.net.URL;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {

        private String mResult;

        @Override
        public String apply(Integer input) {
            try{
                URL learnUrl = ApiUtil.buildUrl("hours");
                URL searchUrl = learnUrl;
                mResult = null;
                mResult = ApiUtil.getJson(searchUrl);
            }
            catch (Exception e){
                Log.d("Error", e.getMessage());
            }
            return mResult;
        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }
}