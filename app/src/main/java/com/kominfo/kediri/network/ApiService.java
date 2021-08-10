package com.kominfo.kediri.network;

import com.kominfo.kediri.data.model.LoginResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(@Field("usernm") String username,
                              @Field("passwd") String password);
}
