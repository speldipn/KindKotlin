package com.example.kindkotlin

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class LoginFragment : Fragment() {

    lateinit var mainActivity:MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) {
            mainActivity = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        mainActivity.debug("onDestroyView")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        mainActivity.debug("onDestrory")
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        mainActivity.debug("onDetach")
//    }

    private fun setup() {
        mainActivity.debug("setup")
    }
}