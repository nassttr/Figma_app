package com.example.figma_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class SignInActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        email = findViewById(R.id.edittext_email)
        password = findViewById(R.id.edittext_password)
    }

    fun signin(view: View) {
        if(email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
            val intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)
            finish()
        }
        else {
            val alert = AlertDialog.Builder(this) //создание окна
                .setTitle("Ошибка") //заголовок
                .setMessage("У вас есть незаполненные поля") //сообщение
                .setPositiveButton("0k",null) //добавление кнопки
                .create()
                .show() //вывод на экран|
        }
    }
}