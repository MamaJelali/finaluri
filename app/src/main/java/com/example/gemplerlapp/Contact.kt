package com.example.gemplerlapp

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.FirebaseDatabase

class Contact : Fragment(R.layout.fragment_contact) {

    private lateinit var noteEditText: EditText
    private lateinit var noteTextView: TextView
    private lateinit var button: Button

    private lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noteEditText = view.findViewById(R.id.noteEditText)
        noteTextView = view.findViewById(R.id.noteTextView)
        button = view.findViewById(R.id.button)

        sharedPreferences = requireActivity().getSharedPreferences("Numbers", MODE_PRIVATE)
        val notes = sharedPreferences.getString("NOTES","")
        noteTextView.text = notes

        button.setOnClickListener{

            val employee = Employees(noteEditText.text.toString())
            val database = FirebaseDatabase.getInstance().getReference("Employees")
            database.child("employee").push().setValue(employee)

            Toast.makeText(activity, "We will contact you", Toast.LENGTH_SHORT).show()

            val note = noteEditText.text.toString()

            val notes = noteTextView.text.toString()

            val result = notes + "\n" + note

            noteTextView.text = result
            noteEditText.setText("")

            sharedPreferences.edit()
                .putString("NOTES",result)
                .apply()

        }


    }


}