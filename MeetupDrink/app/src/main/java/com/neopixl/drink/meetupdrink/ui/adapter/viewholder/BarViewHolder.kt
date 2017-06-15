package com.neopixl.drink.meetupdrink.ui.adapter.viewholder

import android.view.View
import android.widget.TextView
import butterknife.bindView
import com.neopixl.drink.meetupdrink.R
import com.neopixl.drink.meetupdrink.model.Bar


/**
 * Created by Florian ALONSO on 6/12/17.
 * For Neopixl
 */

class BarViewHolder(itemView: View): BaseViewHolder(itemView) {

    val nameTextView by bindView<TextView>(R.id.name)

    var bar: Bar? = null
        get
        set(value) {
            nameTextView.text = value?.name

        }

}