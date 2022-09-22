package com.mdp.formulirrelative;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView tvNPM, tvNama, tvProdi, tvJK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvNPM = findViewById(R.id.et_npm);
        tvNama = findViewById(R.id.et_nama);
        tvJK = findViewById(R.id.tv_jk);
        tvProdi = findViewById(R.id.tv_prodi);

        // tangkap invent dari main activity
        Intent intent = getIntent();
        tvNPM.setText(intent.getStringExtra("varNPM"));
        tvNama.setText(intent.getStringExtra("varNama"));
        tvJK.setText(intent.getStringExtra("varJk"));
        tvProdi.setText(intent.getStringExtra("varProdi"));
    }
}