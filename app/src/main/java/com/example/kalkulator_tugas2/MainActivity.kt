package com.example.kalkulator_tugas2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var angka1: EditText
    private lateinit var angka2: EditText
    private lateinit var operasi: RadioGroup
    private lateinit var btnHasil: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        angka1 = findViewById(R.id.angka1)
        angka2 = findViewById(R.id.angka2)
        operasi = findViewById(R.id.operasi)
        btnHasil = findViewById(R.id.btnHasil)

        btnHasil.setOnClickListener {
            calculateResult()
        }
    }

    private fun calculateResult() {
        val num1 = angka1.text.toString().toDoubleOrNull()
        val num2 = angka2.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            Toast.makeText(this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show()
            return
        }

        val result = when (operasi.checkedRadioButtonId) {
            R.id.tambah -> num1 + num2
            R.id.kurang -> num1 - num2
            R.id.kali -> num1 * num2
            R.id.bagi -> {
                if (num2 != 0.0) num1 / num2 else {
                    Toast.makeText(this, "Tidak bisa membagi dengan nol", Toast.LENGTH_SHORT).show()
                    return
                }
            }
            else -> {
                Toast.makeText(this, "Pilih operasi", Toast.LENGTH_SHORT).show()
                return
            }
        }

        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("RESULT", result)
            putExtra("Nama", "Muhammad Zulfikar") // Ganti dengan NIM Anda
            putExtra("NIM", "225150401111014") // Ganti dengan nama Anda
        }
        startActivity(intent)
    }
}
