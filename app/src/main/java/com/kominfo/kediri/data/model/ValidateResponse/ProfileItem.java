package com.kominfo.kediri.data.model.ValidateResponse;

import com.google.gson.annotations.SerializedName;

public class ProfileItem {


    @SerializedName("aud")
    private String aud;

    @SerializedName("nbf")
    private int nbf;

    @SerializedName("data")
    private Data data;

    @SerializedName("iss")
    private String iss;

    @SerializedName("exp")
    private int exp;

    @SerializedName("iat")
    private int iat;

    public String getAud() {
        return aud;
    }

    public int getNbf() {
        return nbf;
    }

    public Data getData() {
        return data;
    }

    public String getIss() {
        return iss;
    }

    public int getExp() {
        return exp;
    }

    public int getIat() {
        return iat;
    }
}