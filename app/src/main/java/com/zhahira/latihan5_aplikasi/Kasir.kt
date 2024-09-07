package com.zhahira.latihan5_aplikasi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Kasir : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kasir)

        val totalBelanja = findViewById<EditText>(R.id.etInput)
        val  totalDiskon = findViewById<Button>(R.id.btnTdd)
        val hasilDiskon = findViewById<TextView>(R.id.tvTotalDiskon)

        totalDiskon.setOnClickListener {
            val tb = totalBelanja.text.toString().toDoubleOrNull()

            if (tb != null){
                var diskon = 0.0

                when{
                    tb < 100000 -> {
                        diskon = 0.0
                    }
                    tb in 100000.0..500000.0 -> {
                        diskon = 0.10 * tb
                    }
                    tb in 500000.0..1000000.0 -> {
                        diskon = 0.20 * tb
                    }
                    tb > 1000000 -> {
                        diskon = 0.30 * tb
                    }
                }
                val totalSetelahDiskon = tb - diskon

                // Menampilkan hasil
                hasilDiskon.text = "Total Belanja: Rp. $tb\n" +
                        "Total Setelah Diskon: Rp. $totalSetelahDiskon"
            }else{

            }
        }

        val ActButtonHome = findViewById<Button>(R.id.btnHomeDua)
        ActButtonHome.setOnClickListener {
            //Nama Page
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}