package com.example.shopeasy

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Setup toolbar as action bar
        val toolbar = findViewById<Toolbar>(R.id.toolbar1)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "" // remove title if you want
            setDisplayHomeAsUpEnabled(true) // show back arrow
            setHomeAsUpIndicator(R.drawable.arrow) // your custom arrow drawable
        }

        // Handle Sign Up button click
        val signUpButton = findViewById<Button>(R.id.signUpButton)
        signUpButton.setOnClickListener {
            Toast.makeText(this, "Sign Up clicked", Toast.LENGTH_SHORT).show()
        }
    }

    // Handle back arrow press to go back
    override fun onSupportNavigateUp(): Boolean {
        finish() // close this activity, go back
        return true
    }
}



