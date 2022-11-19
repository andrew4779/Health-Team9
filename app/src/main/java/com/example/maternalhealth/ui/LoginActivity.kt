package com.example.maternalhealth.ui

import android.content.ContentValues.TAG
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.maternalhealth.MainActivity
import com.example.maternalhealth.R
import com.google.firebase.auth.FirebaseAuth

@Suppress("NAME_SHADOWING")
class LoginActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        )
        setContentView(R.layout.activity_login)
        firebaseAuth = FirebaseAuth.getInstance()


        val email: EditText = findViewById(R.id.email)
        val password: EditText = findViewById(R.id.password)
        val forgot_password: TextView = findViewById(R.id.forgot_password)

        val button: Button = findViewById(R.id.login_btn)

        //LOGIN USER
        button.setOnClickListener {
            val email = email.text.toString()
            val password = password.text.toString()

            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Logged is Successfully", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
                }

        }
        //FORGOT PASSWORD

        forgot_password.setOnClickListener {
            val intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
            finish()
        }


            //CREATE NEW ACCOUNT
            val create_account: TextView = findViewById(R.id.create_newaccount)
            create_account.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            }
    }
}