package com.kominfo.kediri.data.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kominfo.kediri.R;
import com.kominfo.kediri.data.model.ValidateResponse.ValidateResponse;
import com.kominfo.kediri.network.ApiService;
import com.kominfo.kediri.network.RetrofitAPIClient;
import com.kominfo.kediri.utils.SharedPreferencesUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashscreenActivity extends AppCompatActivity {

    private ApiService apiService;
    private SharedPreferencesUtils sharedPreferencesUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        initData();
    }

    private void initData() {
        apiService = RetrofitAPIClient.getRetrofit().create(ApiService.class);
        sharedPreferencesUtil = new SharedPreferencesUtils(this);

        String token = sharedPreferencesUtil.getSpSavetoken();
        if (token.equals("") || token.isEmpty()) {
            setSplashscreen();
        } else {
            getAccess(token);
        }
    }

    private void getAccess(String token) {
        Call<ValidateResponse> call = apiService.validate(token);
        call.enqueue(new Callback<ValidateResponse>() {
            @Override
            public void onResponse(Call<ValidateResponse> call, Response<ValidateResponse> response) {
                assert response.body() != null;
                String role = response.body().getData().getProfile().get(0).getData().getIdJabatan();
                if (response.body().getStatus() == 200) {
                    if (role.equals("160.00.1.1") || role.equals("160.00.1")) {
                        startActivity(new Intent(getApplicationContext(), DashboardUmumActivity.class));
                        finish();
                    } else if (role.equals("160.00.1.1.1.2")) {
                        startActivity(new Intent(getApplicationContext(), DashboardUserEntryActivity.class));
                        finish();
                    } else {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                } else if (response.body().getStatus() == 401) {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<ValidateResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + t, Toast.LENGTH_SHORT).show();
                call.clone().enqueue(this);
            }
        });
    }

    private void setSplashscreen() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        }, 2000L);
    }
}