package com.example.maternalhealth.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.maternalhealth.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Suppress("NAME_SHADOWING")
class RegisterActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)

        setContentView(R.layout.activity_register)
        firebaseAuth = FirebaseAuth.getInstance()


        val fName: EditText = findViewById(R.id.first_name)
        val sName: EditText = findViewById(R.id.second_name)
        val email: EditText = findViewById(R.id.email)
        val password: EditText = findViewById(R.id.password)
        val cPassword: EditText = findViewById(R.id.confirm_password)
        val button : Button= findViewById(R.id.register)

        button.setOnClickListener {

            val fName = fName.text.toString()
            val sName = sName.text.toString()
            val email = email.text.toString()
            val password = password.text.toString()
            val cPassword = cPassword.text.toString()

            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    val userMap = hashMapOf(
                        "name" to fName,
                        "sname" to sName,
                        "email" to email,
                        "password" to password,
                        "cpassword" to cPassword
                    )

                    val userId = FirebaseAuth.getInstance().currentUser!!.uid
                    db.collection("users").document(userId).set(userMap)
                        .addOnSuccessListener {
                            Toast.makeText(this, "Succesfully Registered", Toast.LENGTH_SHORT).show()


                        }
                        .addOnFailureListener {
                            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                        }


                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }

        }

        val login : TextView = findViewById(R.id.login)
        login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }


}