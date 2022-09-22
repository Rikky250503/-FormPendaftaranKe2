package com.mdp.formulirrelative;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private EditText etNPM,etNama;
    private RadioGroup rgJK;
    private RadioButton rbJK;
    private Spinner spProdi;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNPM = findViewById(R.id.et_npm);
        etNama = findViewById(R.id.et_nama);
        rgJK = findViewById(R.id.rg_jk);
        spProdi = findViewById(R.id.sp_prodi);

        btnDaftar = findViewById(R.id.btn_Daftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String npm , nama, jk , prodi;
                int SelectedID;

                npm = etNPM.getText().toString();
                nama = etNama.getText().toString();
                prodi = spProdi.getSelectedItem().toString();

                SelectedID = rgJK.getCheckedRadioButtonId();
                rbJK = findViewById(SelectedID);
                jk = rbJK.getText().toString();

                // cek apaakah npm dan nama kosong
                if(npm.trim().equals(""))
                {
                    etNPM.setError("NPM Tidak Boleh Kosong");
                }
                else if (npm.trim().equals(""))
                {
                    etNama.setError("Nama Tidak Boleh Kosong");
                }
                else
                {
                    // bikin intent untuk di tanggkap di result activity
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("varNPM", npm);
                    intent.putExtra("varNama", nama);
                    intent.putExtra("varJk" , jk);
                    intent.putExtra("varProdi", prodi);
                    startActivity(intent);
                }
            }
        });
    }
}