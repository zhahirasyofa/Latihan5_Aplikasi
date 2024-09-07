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
import org.w3c.dom.Text

class LuasDanVolume : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_luas_dan_volume)

        val Panjang = findViewById<EditText>(R.id.etPanjang)
        val Lebar = findViewById<EditText>(R.id.etLebar)
        val Tinggi = findViewById<EditText>(R.id.etTinggi)
        val btnLuas = findViewById<Button>(R.id.btnLuas)
        val btnVolume = findViewById<Button>(R.id.btnVolum)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        fun stringToInt(value: String): Int {
            return value.toIntOrNull() ?: 0
        }

        btnVolume.setOnClickListener {
            val P = stringToInt(Panjang.text.toString())
            val T = stringToInt(Tinggi.text.toString())
            val L = stringToInt(Lebar.text.toString())
            val hasil= P*L*T
            tvHasil.text = " Hasil : $hasil"
        }

        btnLuas.setOnClickListener {
            val P = stringToInt(Panjang.text.toString())
            val T = stringToInt(Tinggi.text.toString())
            val L = stringToInt(Lebar.text.toString())
            val hasil= 2 * (P*L + P*T + L*T)
            tvHasil.text = " Hasil : $hasil"
        }

        val ActButtonHome = findViewById<Button>(R.id.btnHomie)
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