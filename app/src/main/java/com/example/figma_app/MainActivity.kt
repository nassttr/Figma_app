package com.example.figma_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun SignIn(view: View) {
        val intent = Intent(this,SignInActivity::class.java)
        startActivity(intent)
        finish()
    }
}