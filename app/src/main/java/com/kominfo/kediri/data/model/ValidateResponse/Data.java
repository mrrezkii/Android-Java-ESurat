package com.kominfo.kediri.data.model.ValidateResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("profile")
    private List<ProfileItem> profile;

    @SerializedName("usernm")
    private String usernm;

    @SerializedName("telp")
    private String telp;

    @SerializedName("id_level")
    private String idLevel;

    @SerializedName("id_user")
    private String idUser;

    @SerializedName("tgl_lahir")
    private String tglLahir;

    @SerializedName("alamat")
    private String alamat;

    @SerializedName("token")
    private String token;

    @SerializedName("id_jabatan")
    private String idJabatan;

    @SerializedName("entry")
    private String entry;

    @SerializedName("tempat")
    private String tempat;

    @SerializedName("nama")
    private String nama;

    @SerializedName("nip")
    private String nip;

    @SerializedName("foto")
    private String foto;

    @SerializedName("passwd")
    private String passwd;

    @SerializedName("esign_active")
    private String esignActive;

    @SerializedName("admin_nodin")
    private String adminNodin;

    @SerializedName("status")
    private String status;

    public List<ProfileItem> getProfile() {
        return profile;
    }

    public String getUsernm() {
        return usernm;
    }

    public String getTelp() {
        return telp;
    }

    public String getIdLevel() {
        return idLevel;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getToken() {
        return token;
    }

    public String getIdJabatan() {
        return idJabatan;
    }

    public String getEntry() {
        return entry;
    }

    public String getTempat() {
        return tempat;
    }

    public String getNama() {
        return nama;
    }

    public String getNip() {
        return nip;
    }

    public String getFoto() {
        return foto;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getEsignActive() {
        return esignActive;
    }

    public String getAdminNodin() {
        return adminNodin;
    }

    public String getStatus() {
        return status;
    }
}