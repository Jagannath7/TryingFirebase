package com.example.tryingfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val dbRef = FirebaseDatabase.getInstance().reference
    val list = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter<String>(
            this, R.layout.item_row,
            R.id.viewList,
            list
        )

        listView.adapter = adapter

        Btn.setOnClickListener {
            val text = edtText.text.toString()
            dbRef.child("Text").push().setValue(text)
        }

       dbRef.child("Text").addChildEventListener(object : ChildEventListener {

           override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
               val text = snapshot.getValue()
               text.let{list.add(it as String)}
               adapter.notifyDataSetChanged()
           }

           override fun onCancelled(error: DatabaseError) {

           }

           override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {

           }

           override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {

           }

           override fun onChildRemoved(snapshot: DataSnapshot) {

           }
       })
    }
}