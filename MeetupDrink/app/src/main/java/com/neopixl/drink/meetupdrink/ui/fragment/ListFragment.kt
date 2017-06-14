package com.neopixl.drink.meetupdrink.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.neopixl.drink.meetupdrink.R


/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    companion object {
        fun newInstance(): ListFragment {
            val fragment = ListFragment()
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.fragment_list, container, false)

        return rootView
    }

    override fun onStart() {
        super.onStart()
    }

}// Required empty public constructor
