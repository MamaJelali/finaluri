package com.example.gemplerlapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commitNow
import com.google.firebase.auth.FirebaseAuth

class Recover : Fragment(R.layout.fragment_recover) {

    private lateinit var email: EditText
    private lateinit var buttonSend: Button
    private lateinit var buttonBack: Button
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        email = view.findViewById(R.id.editTextEmail)
        buttonSend = view.findViewById(R.id.buttonSend)
        buttonBack = view.findViewById(R.id.buttonBack)

        buttonSend.setOnClickListener {

            if (email.text.toString().isNotEmpty()){


                FirebaseAuth.getInstance().sendPasswordResetEmail(email.text.toString())
                    .addOnCompleteListener{ task->
                        if (task.isSuccessful) {

                            Toast.makeText(activity,"Check email", Toast.LENGTH_SHORT).show()

                            val login = LogIn()
                            val fragmentManager = parentFragmentManager

                            fragmentManager.commitNow {
                                setReorderingAllowed(true)
                                replace(R.id.nav_host_fragment, login)
                            }

                        }
                        else{
                            Toast.makeText(activity,"Error", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
            else{
                Toast.makeText(activity,"Enter Your Email", Toast.LENGTH_SHORT).show()

            }
        }


        buttonBack.setOnClickListener {

            val login = LogIn()
            val fragmentManager = parentFragmentManager

            fragmentManager.commitNow {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment, login)
            }
        }


    }





}