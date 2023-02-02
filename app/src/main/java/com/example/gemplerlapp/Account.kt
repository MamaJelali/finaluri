package com.example.gemplerlapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.commitNow
import com.google.firebase.auth.FirebaseAuth

class Account : Fragment(R.layout.fragment_account) {

    private lateinit var editTextPassword: EditText
    private lateinit var buttonChangePassword: Button
    private lateinit var buttonLogout: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextPassword = view.findViewById(R.id.editTextPassword)
        buttonChangePassword = view.findViewById(R.id.buttonChangePassword)
        buttonLogout = view.findViewById(R.id.buttonLogout)

        buttonChangePassword.setOnClickListener {

            val newPassword = editTextPassword.text.toString()
            if (newPassword.isNotEmpty()){

                FirebaseAuth.getInstance()
                    .currentUser?.updatePassword(newPassword)
                    ?.addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(activity, "Password Changed", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
            else{
                Toast.makeText(activity, "Please enter new password", Toast.LENGTH_SHORT).show()
            }


        }

        buttonLogout.setOnClickListener {

            FirebaseAuth.getInstance().signOut()

            val login = LogIn()
            val fragmentManager = requireActivity().supportFragmentManager

            fragmentManager.commitNow {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment, login)
            }

        }
    }

}