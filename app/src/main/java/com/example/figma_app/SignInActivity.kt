package com.example.figma_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.figma_app.retrofit.AuthRequest
import com.example.figma_app.retrofit.MainAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SignInActivity : AppCompatActivity() {
    private lateinit var mainApi: MainAPI
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var btnSignIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        email = findViewById(R.id.edittext_email)
        password = findViewById(R.id.edittext_password)
        btnSignIn = findViewById(R.id.btn_SignIn)
    }

    private fun initRetrofit() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()
        mainApi = retrofit.create(MainAPI::class.java)
    }

    private fun auth(authRequest: AuthRequest) {
        initRetrofit()
        CoroutineScope(Dispatchers.IO).launch{
            val response = mainApi.auth(authRequest)
            val message = response.errorBody()?.string()?.let {
                JSONObject(it).getString("message")
            }


            val user = response.body()
            if(user != null){

                val intent = Intent(this@SignInActivity, MenuActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }

    fun signin(view: View) {
        initRetrofit()

        val status = auth(AuthRequest(
            email.text.toString(),
            password.text.toString()
        ))
        if(email.text.toString().isEmpty() && password.text.toString().isEmpty())
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Введите правильные логин и пароль")
                .setPositiveButton("Ok", null)
                .create()
                .show()
        }
    }

}