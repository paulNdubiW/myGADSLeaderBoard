package com.example.leaderboard.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {
    public static final String BASE_URL = "https://docs.google.com/forms/d/e";

   private static Retrofit retrofit = new Retrofit.Builder()

            .baseUrl(BASE_URL)

            .addConverterFactory(GsonConverterFactory.create())

            .build();

    public static <S> S buildService(Class<S> serviceType){
        return  retrofit.create(serviceType);
    }
}
