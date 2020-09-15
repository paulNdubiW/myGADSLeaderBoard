package com.example.leaderboard;

public class Hours {
    public String mId;
    public String  mName;
    public String mHours;
    public String mCountry;

    public Hours(String id, String name, String hours, String country) {
        mId = id;
        mName = name;
        mHours = hours;
        mCountry = country;
    }

    public void setId(String id) {
        mId = id;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setHours(String hours) {
        mHours = hours;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getHours() {
        return mHours;
    }

    public String getCountry() {
        return mCountry;
    }
}
