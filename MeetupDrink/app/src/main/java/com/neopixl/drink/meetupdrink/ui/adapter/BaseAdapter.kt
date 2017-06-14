package com.neopixl.drink.meetupdrink.ui.adapter

import android.support.v7.widget.RecyclerView
import com.neopixl.drink.meetupdrink.ui.adapter.viewholder.BaseViewHolder


/**
 * Created by Florian ALONSO on 6/12/17.
 * For Neopixl
 */
abstract class BaseAdapter<T: BaseViewHolder>: RecyclerView.Adapter<T>(), BaseViewHolder.OnClickListener {

    interface OnItemClickListener<T: BaseViewHolder> {
        fun onItemClick(parent: BaseAdapter<T>, viewHolder: RecyclerView.ViewHolder, position: Int)
    }

    var onItemClickListener: OnItemClickListener<T>? = null


    override fun onBindViewHolder(viewHolder: T, position: Int) {
        viewHolder.listener = this
    }

    override fun onClick(viewHolder: BaseViewHolder) {
        val position = viewHolder.adapterPosition
        onItemClickListener?.onItemClick(this, viewHolder, position)
    }
}