package com.example.gemplerlapp

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.FirebaseDatabase

class Services2 : Fragment(R.layout.fragment_services2) {

    private lateinit var buttonDog: Button
    private lateinit var buttonCar: Button
    private lateinit var buttonTrash: Button
    private lateinit var buttonHouse: Button
    private lateinit var buttonYes: Button
    private lateinit var buttonNo: Button
    private lateinit var name: EditText
    private lateinit var phone: EditText
    private lateinit var description: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonDog = view.findViewById(R.id.buttonDog)
        buttonCar = view.findViewById(R.id.buttonCar)
        buttonTrash = view.findViewById(R.id.buttonTrash)
        buttonHouse = view.findViewById(R.id.buttonHouse)

        buttonDog.setOnClickListener {
            calldialog()
        }
        buttonCar.setOnClickListener {
            calldialog()
        }
        buttonTrash.setOnClickListener {
            calldialog()
        }
        buttonHouse.setOnClickListener {
            calldialog()
        }
    }


    private fun calldialog(){

        val mDialogView = LayoutInflater.from(this.context).inflate(R.layout.order_dialog, null);
        val mBuilder = AlertDialog.Builder(this.context)
            .setView(mDialogView)
            .setTitle("Order Form")
        val mAlertDialog = mBuilder.show()

        buttonYes = mDialogView.findViewById(R.id.dialogYesBtn)
        buttonNo = mDialogView.findViewById(R.id.dialogNoBtn)
        name = mDialogView.findViewById(R.id.dialogName)
        phone = mDialogView.findViewById(R.id.dialogNumber)
        description = mDialogView.findViewById(R.id.dialogDescription)

        buttonYes.setOnClickListener{

            val order = Orders(name.text.toString(),phone.text.toString(),description.text.toString())
            val database = FirebaseDatabase.getInstance().getReference("Orders")
            database.child("Order").push().setValue(order)

            Toast.makeText(activity, "Your order received", Toast.LENGTH_SHORT).show()

            mAlertDialog.dismiss()
        }

        buttonNo.setOnClickListener {

            mAlertDialog.dismiss()
        }


    }



}