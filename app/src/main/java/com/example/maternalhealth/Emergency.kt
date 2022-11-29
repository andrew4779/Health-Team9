package com.example.maternalhealth

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.core.app.ActivityCompat


class Emergency : AppCompatActivity() {

    private val phoneNumber = "0710100100"
    private val REQUEST_PHONE_CALL =1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency)

        val call : ImageButton= findViewById(R.id.call)

        call.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), REQUEST_PHONE_CALL)
            }else{

                startCall()
            }
        }

    }

    private fun startCall() {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tell$phoneNumber")
        startActivity(callIntent)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == REQUEST_PHONE_CALL)
            startCall()
    }
}