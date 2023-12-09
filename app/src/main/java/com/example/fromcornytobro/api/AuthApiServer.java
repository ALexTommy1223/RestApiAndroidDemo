package com.example.fromcornytobro.api;

import com.example.fromcornytobro.model.Auth;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AuthApiServer {
    @GET("auth")
    Call<List<Auth>> getAllAuth();
    @GET("auth/{id}")
    Call<List<Auth>> getAuthById(@Path("id") int id);
    @POST("auth/login")
    Call<String> login(@Body Auth login);
    @POST("auth/register")
    Call<String> register(@Body Auth register);
    @POST("auth")
    Call<Auth> saveAuth(@Body Auth auth);
    @PUT("auth/{id}")
    Call<Auth> updateAuth(@Path("id") int id, @Body Auth auth);
    @DELETE("auth")
    Call<Void> deleteAuth(@Path("id") int id);
}
