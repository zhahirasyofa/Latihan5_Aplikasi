package com.zhahira.latihan5_aplikasi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val ActButtonConvert = findViewById<Button>(R.id.btnSuhuu)
        ActButtonConvert.setOnClickListener {
            //Nama Page
            val Intent = Intent(this, ConvertSuhuDua::class.java)
            startActivity(Intent)
        }

        val ActButtonDua = findViewById<Button>(R.id.btnDuaa)
        ActButtonDua.setOnClickListener {
            //Nama Page
            val Intent = Intent(this,Kasir::class.java)
            startActivity(Intent)
        }

        val ActButtonTiga = findViewById<Button>(R.id.btnTigaa)
        ActButtonTiga.setOnClickListener {
            //Nama Page
            val Intent = Intent(this, LuasDanVolume::class.java)
            startActivity(Intent)
        }

        val ActButtonEmpat = findViewById<Button>(R.id.btnEmpatt)
        ActButtonEmpat.setOnClickListener {
            //Nama Page
            val Intent = Intent(this, ProgramPython::class.java)
            startActivity(Intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}