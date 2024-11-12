package com.example.app_perhitungangaji;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menghubungkan komponen UI
        EditText editTextNama = findViewById(R.id.editTextNama);
        EditText editTextNim = findViewById(R.id.editTextNim);
        EditText editTextNilai = findViewById(R.id.editTextNilai);
        Button buttonCekKelulusan = findViewById(R.id.buttonCekKelulusan);
        TextView textViewHasil = findViewById(R.id.textViewHasil);

        // Event klik tombol "Cek Kelulusan"
        buttonCekKelulusan.setOnClickListener(view -> {
            // Mengambil input dari pengguna
            String nama = editTextNama.getText().toString().trim();
            String nim = editTextNim.getText().toString().trim();
            String nilaiText = editTextNilai.getText().toString().trim();

            // Validasi input tidak boleh kosong
            if (nama.isEmpty() || nim.isEmpty() || nilaiText.isEmpty()) {
                Toast.makeText(MainActivity.this, "Harap isi semua bidang input!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Konversi nilai menjadi integer dan validasi
            int nilai;
            try {
                nilai = Integer.parseInt(nilaiText);
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Nilai harus berupa angka!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Cek apakah nilai berada dalam rentang yang valid (1-100)
            if (nilai < 1 || nilai > 100) {
                Toast.makeText(MainActivity.this, "Nilai harus di antara 1 dan 100!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Memeriksa kelulusan (nilai < 50 tidak lulus)
            String kelulusan = nilai >= 50 ? "Lulus" : "Tidak Lulus";

            // Menampilkan hasil
            String hasil = "Nama: " + nama + "\nNIM: " + nim + "\nNilai: " + nilai + "\nStatus: " + kelulusan;
            textViewHasil.setText(hasil);
        });
    }
}
