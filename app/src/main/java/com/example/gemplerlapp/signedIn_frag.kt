package com.example.gemplerlapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class signedIn_frag : Fragment(R.layout.fragment_signed_in_frag) {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigationView=view.findViewById(R.id.bottom_nav)
        val navHostFragment=childFragmentManager.findFragmentById(R.id.nav_host_fragment_insigned)
                as NavHostFragment
        navController=navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)
    }
}