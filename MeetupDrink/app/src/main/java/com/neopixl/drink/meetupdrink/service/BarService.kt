package com.neopixl.drink.meetupdrink.service

import android.content.Context
import com.fasterxml.jackson.module.kotlin.readValue
import com.neopixl.drink.meetupdrink.MeetupDrinkApplication
import com.neopixl.drink.meetupdrink.model.Bar
import com.neopixl.drink.meetupdrink.model.BarWrapper
import com.neopixl.drink.meetupdrink.util.barString


/**
 * Created by Florian ALONSO on 6/9/17.
 * For Neopixl
 */
class BarService {

    companion object {
        val shared by lazy {
            BarService()
        }
    }

    fun barList(context: Context): List<Bar> {
        val jsonString = context.assets.barString(context)
        val mapper = MeetupDrinkApplication.shared.mapper
        val barWrapper = mapper.readValue<BarWrapper>(jsonString)

        return barWrapper.bars
    }
}