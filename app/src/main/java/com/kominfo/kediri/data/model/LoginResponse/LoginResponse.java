package com.kominfo.kediri.data.model.LoginResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginResponse {

    @SerializedName("role")
    private String role;

    @SerializedName("data")
    private List<Object> data;

    @SerializedName("roleid")
    private String roleid;

    @SerializedName("messages")
    private String messages;

    @SerializedName("error")
    private boolean error;

    @SerializedName("status")
    private int status;

    @SerializedName("token")
    private String token;

    public String getRole() {
        return role;
    }

    public List<Object> getData() {
        return data;
    }

    public String getRoleid() {
        return roleid;
    }

    public String getMessages() {
        return messages;
    }

    public boolean isError() {
        return error;
    }

    public int getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }
}