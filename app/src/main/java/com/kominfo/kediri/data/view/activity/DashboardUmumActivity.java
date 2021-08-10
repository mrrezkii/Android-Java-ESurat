package com.kominfo.kediri.data.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.kominfo.kediri.R;

public class DashboardUmumActivity extends AppCompatActivity {

    private ImageButton btn_surat_masuk;
    private ImageButton btn_surat_keluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_umum);
        initView();
    }

    private void initView() {
        btn_surat_masuk = findViewById(R.id.imageButton);
        btn_surat_keluar = findViewById(R.id.imageButton5);

        btn_surat_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DetailSuratMasukActivity.class));
            }
        });
        btn_surat_keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DetailSuratKeluarActivity.class));
            }
        });
    }
}