package com.neopixl.drink.meetupdrink.model


/**
 * Created by Florian ALONSO on 6/9/17.
 * For Neopixl
 */
data class Bar(val ratings: Double,
               val picture: Picture?,
               val name: String,
               val distance: String,
               val favorite: Int,
               val picture_full: Picture?,
               val tags: String,
               val closeness: Int,
               val coordinates: Coordinate,
               val average_reputation: Int,
               val rates: Int,
               val address: String,
               val friends: List<String>,
               val id: Int,
               val features: Feature)