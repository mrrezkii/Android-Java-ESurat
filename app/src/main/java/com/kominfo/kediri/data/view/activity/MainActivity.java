package com.kominfo.kediri.data.view.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kominfo.kediri.R;
import com.kominfo.kediri.utils.SharedPreferencesUtils;

public class MainActivity extends AppCompatActivity {

    private SharedPreferencesUtils sharedPreferencesUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferencesUtil = new SharedPreferencesUtils(this);

        String token = sharedPreferencesUtil.getSpSavetoken();

        Toast.makeText(getApplicationContext(), "" + token, Toast.LENGTH_SHORT).show();
    }
}