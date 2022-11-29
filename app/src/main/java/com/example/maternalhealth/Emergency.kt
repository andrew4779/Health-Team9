package com.example.maternalhealth

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton


class Emergency : AppCompatActivity() {


    private val phoneNumber ="0710100100"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency)

        val imageButton : ImageButton= findViewById(R.id.call)
        imageButton.setOnClickListener {
            dialPhoneNumber()
        }
    }

    private fun dialPhoneNumber() {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data= Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) !=null)
            startActivity(intent)
    }


}