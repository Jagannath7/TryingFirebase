package com.example.tryingfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val dbRef = FirebaseDatabase.getInstance().reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtBtn.setOnClickListener {
            val text = edtText.text.toString()
            dbRef.child("text").push().setValue(text)
        }

        numBtn.setOnClickListener {
            val num = edtText.text.toString()
            dbRef.child("number").push().setValue(num)
        }
    }
}