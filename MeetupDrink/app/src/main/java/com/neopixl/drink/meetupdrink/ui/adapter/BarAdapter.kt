package com.neopixl.drink.meetupdrink.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.neopixl.drink.meetupdrink.R
import com.neopixl.drink.meetupdrink.model.Bar
import com.neopixl.drink.meetupdrink.ui.adapter.viewholder.BarViewHolder


/**
 * Created by Florian ALONSO on 6/12/17.
 * For Neopixl
 */

class BarAdapter(var barList: List<Bar>): BaseAdapter<BarViewHolder>() {

    override fun onBindViewHolder(viewHolder: BarViewHolder, position: Int) {
        super.onBindViewHolder(viewHolder, position)

        viewHolder.bar = barList[position]
    }

    override fun getItemCount(): Int {
        return barList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BarViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.row_bar, parent, false)

        val viewHolder = BarViewHolder(view)

        return viewHolder
    }
}
