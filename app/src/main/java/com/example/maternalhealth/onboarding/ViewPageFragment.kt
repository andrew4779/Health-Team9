package com.example.maternalhealthcare.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.maternalhealth.R
import com.example.maternalhealth.onboarding.screens.FirstScreen
import com.example.maternalhealth.onboarding.screens.SecondScreen
import com.example.maternalhealth.onboarding.screens.ThirdScreen

class ViewPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_page, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()

        )

        val adapter = ViewPageAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
return view

    }

}