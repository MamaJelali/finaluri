package com.example.gemplerlapp

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase


class Service3 : Fragment(R.layout.fragment_service3) {

    private lateinit var buttonShipping: Button
    private lateinit var buttonShopping: Button
    private lateinit var buttonBabysitter: Button
    private lateinit var buttonPartner: Button
    private lateinit var buttonYes: Button
    private lateinit var buttonNo: Button
    private lateinit var name: EditText
    private lateinit var phone: EditText
    private lateinit var description: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonShipping = view.findViewById(R.id.buttonShipping)
        buttonShopping = view.findViewById(R.id.buttonShopping)
        buttonBabysitter = view.findViewById(R.id.buttonBabysitter)
        buttonPartner = view.findViewById(R.id.buttonPartner)

        buttonShipping.setOnClickListener {
            calldialog()
        }

        buttonShopping.setOnClickListener {
            calldialog()
        }

        buttonBabysitter.setOnClickListener {
            calldialog()
        }

        buttonPartner.setOnClickListener {
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