package com.kominfo.kediri.network;

import com.kominfo.kediri.data.model.LoginResponse.LoginResponse;
import com.kominfo.kediri.data.model.ValidateResponse.ValidateResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(@Field("usernm") String username,
                              @Field("passwd") String password);


    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("profile")
    Call<ValidateResponse> validate(@Header("Authorization") String token);
}
