package com.example.maternalhealth

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

@Suppress("DEPRECATION")
class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        Handler().postDelayed({
            if (onBoardingGetStarted()){
                findNavController().navigate(R.id.action_splashFragment2_to_dashBoard3)

            }else{
                findNavController().navigate(R.id.action_splashFragment2_to_viewPageFragment2)

            }

        }, 3000)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun onBoardingGetStarted() : Boolean {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
       return sharedPref.getBoolean("Get Started", false)
    }
}