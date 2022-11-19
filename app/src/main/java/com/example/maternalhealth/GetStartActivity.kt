package com.example.maternalhealthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.maternalhealth.R

class GetStartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_start)

        val button : Button = findViewById(R.id.button)

        button.setOnClickListener {
           val intent = Intent(this, OneStepActivity::class.java)
            startActivity(intent)
        }
    }


    }

