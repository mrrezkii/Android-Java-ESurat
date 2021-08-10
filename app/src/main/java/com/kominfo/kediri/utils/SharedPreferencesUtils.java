package com.kominfo.kediri.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtils {
    public static final String PREF_NAME = "E Surat";
    public static final String SP_TOKEN = "Token";

    private final SharedPreferences mSharedPreferences;

    public SharedPreferencesUtils(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveSPString(String keySP, String value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(keySP, value);
        editor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(keySP, value);
        editor.commit();
    }

    public void saveSPInt(String keySP, int value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(keySP, value);
        editor.commit();
    }

    public String getSpSavetoken() {
        return mSharedPreferences.getString(SP_TOKEN, "");
    }
}
