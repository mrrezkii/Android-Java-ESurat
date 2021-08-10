package com.kominfo.kediri.data.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kominfo.kediri.R;
import com.kominfo.kediri.data.model.LoginResponse.LoginResponse;
import com.kominfo.kediri.network.ApiService;
import com.kominfo.kediri.network.RetrofitAPIClient;
import com.kominfo.kediri.utils.SharedPreferencesUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;
    private Button btn_login;

    private ApiService apiService;
    private SharedPreferencesUtils sharedPreferencesUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        et_username = findViewById(R.id.usernamelogin);
        et_password = findViewById(R.id.passwordlogin);
        btn_login = findViewById(R.id.buttonLogin);

        apiService = RetrofitAPIClient.getRetrofit().create(ApiService.class);
        sharedPreferencesUtil = new SharedPreferencesUtils(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLogin();
            }
        });
    }

    private void getLogin() {
        Call<LoginResponse> call = apiService.login(et_username.getText().toString(), et_password.getText().toString());
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.body().getStatus() == 200) {
                    Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_SHORT).show();
                    String token = response.body().getToken();

                    sharedPreferencesUtil.saveSPString(SharedPreferencesUtils.SP_TOKEN, token);

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                } else if (response.body().getStatus() == 500) {
                    Toast.makeText(getApplicationContext(), "Password Salah", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}