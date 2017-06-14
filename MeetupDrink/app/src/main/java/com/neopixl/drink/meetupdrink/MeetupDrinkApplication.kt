package com.neopixl.drink.meetupdrink

import android.app.Application
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule


/**
 * Created by Florian ALONSO on 6/11/17.
 * For Neopixl
 */
class MeetupDrinkApplication: Application() {

    companion object {
        lateinit var shared: MeetupDrinkApplication
            private set
    }

    val mapper = ObjectMapper().registerModule(KotlinModule())

    override fun onCreate() {
        super.onCreate()
        shared = this
    }
}