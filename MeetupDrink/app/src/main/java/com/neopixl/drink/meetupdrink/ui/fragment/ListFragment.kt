package com.neopixl.drink.meetupdrink.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import com.neopixl.drink.meetupdrink.R
import com.neopixl.drink.meetupdrink.model.Bar
import com.neopixl.drink.meetupdrink.ui.adapter.BarAdapter
import com.neopixl.drink.meetupdrink.ui.adapter.BaseAdapter
import com.neopixl.drink.meetupdrink.ui.adapter.viewholder.BarViewHolder


/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment(), BaseAdapter.OnItemClickListener<BarViewHolder> {

    interface ListFragmentListener {
        fun didSelectBar(bar: Bar)
    }

    companion object {
        fun newInstance(barList: List<Bar>): ListFragment {
            val fragment = ListFragment()
            fragment.barList = barList
            return fragment
        }
    }

    lateinit var barList: List<Bar>
    val recyclerView by bindView<RecyclerView>(R.id.recycler_view)

    var listener: ListFragmentListener? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.fragment_list, container, false)

        return rootView
    }

    override fun onStart() {
        super.onStart()

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        val adapter = BarAdapter(barList)
        adapter.onItemClickListener = this
        recyclerView.adapter = adapter
    }

    override fun onItemClick(parent: BaseAdapter<BarViewHolder>, viewHolder: RecyclerView.ViewHolder, position: Int) {
        val bar = barList[position]
        listener?.didSelectBar(bar)
    }

}// Required empty public constructor
