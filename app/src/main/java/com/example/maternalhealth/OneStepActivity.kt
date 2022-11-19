package com.example.maternalhealthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.maternalhealth.R

class OneStepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_step)

        val one_step: ImageButton = findViewById(R.id.one_step)
        one_step.setOnClickListener {
            val intent = Intent(this, JourneyWithYouActivity::class.java)
            startActivity(intent)
        }
    }
}