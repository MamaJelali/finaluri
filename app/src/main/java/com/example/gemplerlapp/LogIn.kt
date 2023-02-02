package com.example.gemplerlapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commitNow
import com.google.firebase.auth.FirebaseAuth


class LogIn : Fragment(R.layout.fragment_log_in) {

    private lateinit var registerbutton: Button
    private lateinit var loginbutton: Button
    private lateinit var buttonReset: Button
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerbutton = view.findViewById(R.id.buttonRegister)
        loginbutton = view.findViewById(R.id.buttonLogin)
        email = view.findViewById(R.id.editTextEmail)
        password = view.findViewById(R.id.editTextPassword)
        buttonReset = view.findViewById(R.id.buttonReset)
        auth = FirebaseAuth.getInstance()
        registerbutton.setOnClickListener {

            val register = Register()
            val fragmentManager = parentFragmentManager

            fragmentManager.commitNow {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment, register)
            }
        }

        buttonReset.setOnClickListener {

            val recover = Recover()
            val fragmentManager = parentFragmentManager

            fragmentManager.commitNow {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment, recover)
            }
        }

        loginbutton.setOnClickListener {

            if (email.text.toString().isEmpty() || password.text.toString().isEmpty()){
                Toast.makeText(activity,"Fill all the fields", Toast.LENGTH_SHORT).show()
            }
            else{

                login()

            }

        }


    }

    private fun login(){
        auth.signInWithEmailAndPassword(email.text.toString(),password.text.toString())
            .addOnCompleteListener{
                if(it.isSuccessful){
                    Toast.makeText(activity,"Logged in successfully", Toast.LENGTH_SHORT).show()

                    val fragmentManager = parentFragmentManager

                    fragmentManager.commitNow {
                        setReorderingAllowed(true)
                        replace(R.id.nav_host_fragment, signedIn_frag())
                    }
                }
                else{
                    Toast.makeText(activity,"Wrong Email or Password", Toast.LENGTH_SHORT).show()
                }

                }
            }





}