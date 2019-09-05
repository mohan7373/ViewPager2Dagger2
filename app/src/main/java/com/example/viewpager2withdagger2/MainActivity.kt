package com.example.viewpager2withdagger2

import android.net.Uri
import android.os.Bundle
import androidx.navigation.findNavController
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity(),MainFragment.OnFragmentInteractionListener,SecondFragment.OnFragmentInteractionListener,FirstFragment.OnFragmentInteractionListener,EndFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {

    }

    override fun onFragmentInteraction(viewId: Int) {
        findNavController(viewId).navigate(R.id.action_mainFragment_to_ticketDetail)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
