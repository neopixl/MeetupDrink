package com.neopixl.drink.meetupdrink.ui.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View


/**
 * Created by Florian ALONSO on 6/12/17.
 * For Neopixl
 */
open class BaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    interface OnClickListener {
        fun onClick(viewHolder: BaseViewHolder)
    }


    var listener: OnClickListener? = null

    init {
        itemView.setOnClickListener({
            listener?.onClick(this)
        })
    }
}