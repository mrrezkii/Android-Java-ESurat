package com.kominfo.kediri.data.model.ValidateResponse;

import com.google.gson.annotations.SerializedName;

public class ValidateResponse {

    @SerializedName("data")
    private Data data;

    @SerializedName("messages")
    private String messages;

    @SerializedName("error")
    private boolean error;

    @SerializedName("status")
    private int status;

    public Data getData() {
        return data;
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
}