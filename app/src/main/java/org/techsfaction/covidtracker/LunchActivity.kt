package org.techsfaction.covidtracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.content.pm.PackageManager
import android.util.Base64
import android.util.Log
import android.widget.Toast
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.Login
import com.facebook.login.LoginResult
import kotlinx.android.synthetic.main.activity_lunch.*
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class LunchActivity : AppCompatActivity() {
    var callbackManager : CallbackManager? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lunch)

        callbackManager = CallbackManager.Factory.create()
        login_button.registerCallback(callbackManager, object : FacebookCallback<LoginResult>{
            override fun onSuccess(result: LoginResult?) {


                startActivity(Intent(applicationContext, MainActivity::class.java))
                Toast.makeText(applicationContext, "Connected", Toast.LENGTH_SHORT).show()

            }

            override fun onCancel() {

                Toast.makeText(applicationContext, "Canceled", Toast.LENGTH_SHORT).show()
            }

            override fun onError(error: FacebookException?) {

                Toast.makeText(applicationContext, "Connection Error", Toast.LENGTH_SHORT).show()
            }

        })



        val button = findViewById<ImageButton>(R.id.connect)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager?.onActivityResult(requestCode, resultCode, data)
    }

}
