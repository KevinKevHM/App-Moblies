package com.example.calculararea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val obj: Intent = intent
        var mensage = obj.getStringExtra("resultado")
        val text = findViewById<TextView>(R.id.getText).apply {
            text = mensage + "m^2"
        }
    }
}