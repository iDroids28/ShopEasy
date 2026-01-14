package com.example.shopeasy

import androidx.appcompat.widget.Toolbar
import android.view.MenuItem
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        // Set up the toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "" // optional: remove title
            setDisplayHomeAsUpEnabled(true) // enable back button
            setHomeAsUpIndicator(R.drawable.arrow) // your custom icon
        }
    }

    // Handle back button click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish() // close this activity and go back
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}