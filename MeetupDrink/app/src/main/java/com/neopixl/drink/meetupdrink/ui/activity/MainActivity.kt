package com.neopixl.drink.meetupdrink.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.neopixl.drink.meetupdrink.R
import com.neopixl.drink.meetupdrink.service.BarService
import com.neopixl.drink.meetupdrink.ui.fragment.ListFragment
import com.neopixl.drink.meetupdrink.ui.fragment.MapFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val barList = BarService.shared.barList(this)

        val listFragment = ListFragment.newInstance()
        supportFragmentManager.beginTransaction()
                .add(R.id.bottom_container, listFragment)
                .commit()

        val mapFragment = MapFragment.newInstance(barList)
        supportFragmentManager.beginTransaction()
                .add(R.id.top_container, mapFragment)
                .commit()
    }
}