package com.neopixl.drink.meetupdrink.util

import android.content.Context
import android.content.res.AssetManager
import java.io.BufferedReader
import java.io.InputStreamReader


/**
 * Created by Florian ALONSO on 6/11/17.
 * For Neopixl
 */

// Extension for the asset manager
fun AssetManager.barString(context: Context): String {
    val buf = StringBuilder()
    val json = context.assets.open("bar_json_sample.txt")
    val bufferIn = BufferedReader(InputStreamReader(json, "UTF-8"))
    var str: String?

    str = bufferIn.readLine()
    while (str != null) {
        buf.append(str)
        str = bufferIn.readLine()
    }

    bufferIn.close()
    return buf.toString()
}