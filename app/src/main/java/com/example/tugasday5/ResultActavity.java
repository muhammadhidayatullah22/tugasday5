package com.example.tugasday5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActavity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result_actavity);
        TextView tvNama = findViewById(R.id.tvNama);
        TextView tvTipeMember = findViewById(R.id.tvTipeMember);
        TextView tvKodeBarang = findViewById(R.id.tvKodeBarang);
        TextView tvNamaBarang = findViewById(R.id.tvNamaBarang);
        TextView tvHargaBarang = findViewById(R.id.tvHargaBarang);
        TextView tvTotalHarga = findViewById(R.id.tvTotalHarga);
        TextView tvDiskonHarga = findViewById(R.id.tvDiskonHarga);
        TextView tvDiskonMember = findViewById(R.id.tvDiskonMember);
        TextView tvJumlahBayar = findViewById(R.id.tvJumlahBayar);
        Button btnShare = findViewById(R.id.btnShare);

        // Receive data from intent
        Intent intent = getIntent();
        String namaPelanggan = intent.getStringExtra("Nama Pelanggan");
        String tipePelanggan = intent.getStringExtra("Tipe Member");
        String kodeBarang = intent.getStringExtra("Kode Barang");
        String namaBarang = intent.getStringExtra("Nama Barang");
        long hargaBarang = intent.getLongExtra("Harga", 0);
        long totalHarga = intent.getLongExtra("Total Harga", 0);
        long diskonHarga = intent.getLongExtra("Diskon Harga", 0);
        long diskonMember = intent.getLongExtra("Diskon Member", 0);
        long jumlahBayar = intent.getLongExtra("Jumlah Bayar", 0);

        // Set received data to views
        tvNama.setText(getString(R.string.nama_pelanggan) + ": " + namaPelanggan);
        tvTipeMember.setText(getString(R.string.tipe_member) + ": " + tipePelanggan);
        tvKodeBarang.setText(getString(R.string.kode_barang) + ": " + kodeBarang);
        tvNamaBarang.setText(getString(R.string.nama_barang) + ": " + namaBarang);
        tvHargaBarang.setText(getString(R.string.harga_barang) + ": " + hargaBarang);
        tvTotalHarga.setText(getString(R.string.total_harga) + ": " + totalHarga);
        tvDiskonHarga.setText(getString(R.string.diskon_harga) + ": " + diskonHarga);
        tvDiskonMember.setText(getString(R.string.diskon_member) + ": " + diskonMember);
        tvJumlahBayar.setText(getString(R.string.jumlah_bayar) + ": " + jumlahBayar);


        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a share intent
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");

                // Build the share content
                String shareContent = "Nama Pelanggan: " + namaPelanggan + "\n" +
                        "Tipe Member: " + tipePelanggan + "\n" +
                        "Kode Barang: " + kodeBarang + "\n" +
                        "Nama Barang: " + namaBarang + "\n" +
                        "Harga Barang: " + hargaBarang + "\n" +
                        "Total Harga: " + totalHarga + "\n" +
                        "Diskon Harga: " + diskonHarga + "\n" +
                        "Diskon Member: " + diskonMember + "\n" +
                        "Jumlah Bayar: " + jumlahBayar;

                // Set the share content
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareContent);

                // Start the share activity
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });
    }
}