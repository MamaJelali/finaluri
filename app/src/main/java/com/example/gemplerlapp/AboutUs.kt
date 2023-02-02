package com.example.gemplerlapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AboutUs : Fragment(R.layout.fragment_about_us) {

    val titleImage: Int = 0
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<ServiceInfo>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageId = arrayOf(
            R.drawable.dog,
            R.drawable.carwash,
            R.drawable.taketrash,
            R.drawable.housecleaning,
            R.drawable.shipping,
            R.drawable.shopping,
            R.drawable.babysitter,
            R.drawable.partner,
            R.drawable.flag
        )

        heading = arrayOf(

            "Dog Care service offers you to walk you dog outside if you do not have enough time for this",
            "Car Wash service offers you to take your car for deep cleaning, both externally and internally",
            "Take Trash service offers you to take out your trash if you do not have time for it",
            "House Cleaning service offers you cleaning the house, no matter which room it is, kitchen or any room, also includes the yard",
            "Shipping service offers you delivering anything from one point to another in Georgia",
            "Shopping service offers you buying products or clothes in any store for you",
            "Babysitter service offers you taking care of your child and taking care of his mood by a highly qualified and reliable person",
            "Fake Partner service offers you having a guy or girl next to you in a business meeting or pretending to be in a fake relationship",
            "                                        "

        )

        newRecyclerView = view.findViewById(R.id.recyclerview)
        newRecyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<ServiceInfo>()
        getUserdata()
    }

    private fun getUserdata() {

        for (i in imageId.indices) {

            val service = ServiceInfo(imageId[i],heading[i])
            newArrayList.add(service)
        }

        newRecyclerView.adapter = RecylcerAdapter(newArrayList)
    }

}