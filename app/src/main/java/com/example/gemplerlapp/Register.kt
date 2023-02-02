package com.example.gemplerlapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commitNow
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class Register : Fragment(R.layout.fragment_register) {

    private lateinit var registerbutton: Button
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var repeatpassword: EditText
    private lateinit var backButton: Button
    private lateinit var auth: FirebaseAuth
    
    private lateinit var name: EditText
    private lateinit var surname: EditText
    private lateinit var phone: EditText
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerbutton = view.findViewById(R.id.buttonRegister)
        backButton = view.findViewById(R.id.buttonBack)
        email = view.findViewById(R.id.editTextEmail)
        password = view.findViewById(R.id.editTextPassword)
        repeatpassword = view.findViewById(R.id.editTextRepeatPassword)
        auth = FirebaseAuth.getInstance()

        name = view.findViewById(R.id.editTextName)
        surname = view.findViewById(R.id.editTextSurname)
        phone = view.findViewById(R.id.editTextNumber)



        registerbutton.setOnClickListener {

            if (name.text.toString().isNotEmpty()  && surname.text.toString().isNotEmpty() && phone.text.toString().isNotEmpty() && email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty() && repeatpassword.text.toString().isNotEmpty()){

                if (repeatpassword.text.toString() == password.text.toString()){
                    auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                Toast.makeText(activity,"Registered Successfully", Toast.LENGTH_SHORT).show()
                                val login = LogIn()
                                val fragmentManager = parentFragmentManager

                                fragmentManager.commitNow {
                                    setReorderingAllowed(true)
                                    replace(R.id.nav_host_fragment, login)
                                }

                                val user = Users(name.text.toString(),surname.text.toString(),phone.text.toString(),email.text.toString())
                                val database = FirebaseDatabase.getInstance().getReference("Users")
                                database.child("user").push().setValue(user)
                            }
                            else{
                                Toast.makeText(activity,"This email is already used", Toast.LENGTH_SHORT).show()
                            }
                        }
                }
                else{
                    Toast.makeText(activity,"Password does not match", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(activity,"Fill all the fields", Toast.LENGTH_SHORT).show()
            }

        }

        backButton.setOnClickListener {

            val login = LogIn()
            val fragmentManager = parentFragmentManager

            fragmentManager.commitNow {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment, login)
            }
        }

    }

}