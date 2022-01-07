package com.example.testzetriweb.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.mvvmroomretro.Api.QuoteService
import com.example.mvvmroomretro.Api.RetrofitHelper
import com.example.testzetriweb.Model.LoginResponse
import com.example.testzetriweb.Model.LoginResponse2
import com.example.testzetriweb.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    var api: QuoteService? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        val Text = findViewById<TextView>(R.id.tbtn_login)
        val editTextcustomer = findViewById<EditText>(R.id.ed_txt)
        val editTextPassword = findViewById<EditText>(R.id.ed_txt_2)


        Text.setOnClickListener {
            val email = editTextcustomer.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if (email.isEmpty()) {
                editTextcustomer.error = "Email required"
                editTextcustomer.requestFocus()
                return@setOnClickListener
            } else if (password.isEmpty()) {
                editTextPassword.error = "Password required"
                editTextPassword.requestFocus()
                return@setOnClickListener
            } else {
                api = RetrofitHelper.getApiService()
                //  val  data = LoginResponse(1,1,"first","second")
                //val newsCall: Call<LoginResponse>? = api?.userLogin(data)
                val newsCall: Call<LoginResponse2>? = api?.userLogin3(email, password)
                newsCall?.enqueue(object : Callback<LoginResponse2?> {

                    override fun onResponse(
                        call: Call<LoginResponse2?>, response: Response<LoginResponse2?>
                    ) {
                        //  if (response.code()                                                                    == 200 && response.body().getArticles() != null) {
                        if (response.isSuccessful && response.code() == 201) {
                            // Log.d("resopnse running",""+String().length)

                            Toast.makeText(this@LoginActivity, "success", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse2?>, t: Throwable) {
                        Toast.makeText(
                            this@LoginActivity,
                            "unsucces" + t.message,
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                })


            }
        }
    }
}







