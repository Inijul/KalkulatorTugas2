package com.example.kalkulator_tugas2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val hasil = findViewById<TextView>(R.id.hasil)
        val NIM = findViewById<TextView>(R.id.NIM)
        val Nama = findViewById<TextView>(R.id.Nama)

        val getHasil = intent.getDoubleExtra("RESULT", 0.0)
        val getNIM = intent.getStringExtra("NIM")
        val getNama = intent.getStringExtra("Nama")

        hasil.text = "Hasil: $getHasil"
        Nama.text = "Nama: $getNama"
        NIM.text = "NIM: $getNIM"
    }
}