package com.example.taskguide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        supportActionBar?.hide()

        val btActivity1: Button = findViewById(R.id.btActivity1)

        btActivity1.setOnClickListener {
            val intent = Intent(this, Task1::class.java)
            startActivity(intent)
        }

        val btActivity2: Button = findViewById(R.id.btActivity2)

        btActivity2.setOnClickListener {
            val intent = Intent(this, Task2::class.java)
            startActivity(intent)
        }

    }


}

