package com.example.maternalhealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private var db = Firebase.firestore
    private lateinit var database : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val progress: ImageButton = findViewById(R.id.progress)
        progress.setOnClickListener {
            val intent = Intent(this, ProgressActivity::class.java)
            startActivity(intent)

        }

        val emergency: ImageButton = findViewById(R.id.emergency)
        emergency.setOnClickListener {
            val intent = Intent(this, Emergency::class.java)
            startActivity(intent)
        }


        readFireStoreData()
    }

    private fun readFireStoreData(){
        val fName: TextView = findViewById(R.id.first_name)
        db = FirebaseFirestore.getInstance()
        db.collection("users")
            .get()
            .addOnCompleteListener {
                val result: StringBuffer = StringBuffer()

                if (it.isSuccessful){
                    for (document in it.result) {
                        result.append(dataDir.name)
                    }
                    fName.text= result
                }
            }

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
