package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
            val greetingTextView = findViewById<TextView>(R.id.tvHello)
            val inputTextField = findViewById<EditText>(R.id.etName)
            val buttonSubmit = findViewById<Button>(R.id.btnSubmit)
            val buttonOffers = findViewById<Button>(R.id.btnOffers)
            var enteredName = ""
            buttonSubmit.setOnClickListener{
                enteredName = inputTextField.text.toString()

                if (enteredName == ""){
                    buttonOffers.visibility = INVISIBLE
                    greetingTextView.text = ""
                    Toast.makeText  (this@MainActivity,
                        "Please enter your name!",
                        Toast.LENGTH_SHORT
                    ).show()
                }else {
                    val message = "Welcome $enteredName"
                    greetingTextView.text = message
                    inputTextField.text.clear()
                    buttonOffers.visibility = VISIBLE
                }
            }

        buttonOffers.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USER", enteredName)
            startActivity(intent)
        }

    }
}