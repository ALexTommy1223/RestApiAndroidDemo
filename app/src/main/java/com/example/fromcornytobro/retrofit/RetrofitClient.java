package com.example.fromcornytobro.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit retrofit;

    public static  Retrofit getInstance(){
        retrofit=new Retrofit.Builder()
                .baseUrl("http://10.0.2.2.8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

}
