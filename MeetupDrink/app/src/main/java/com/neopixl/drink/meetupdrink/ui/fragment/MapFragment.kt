package com.neopixl.drink.meetupdrink.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.neopixl.drink.meetupdrink.R
import com.neopixl.drink.meetupdrink.model.Bar
import com.pawegio.kandroid.find


/**
 * A simple [Fragment] subclass.
 */
class MapFragment : Fragment() {

    companion object {
        fun newInstance(barList: List<Bar>): MapFragment {
            val fragment: MapFragment = MapFragment()
            fragment.barList = barList
            return fragment
        }
    }

    lateinit var mapView: MapView
    lateinit var barList: List<Bar>


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater?.inflate(R.layout.fragment_map, container, false) ?: return null

        mapView = rootView.find<MapView>(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.onResume()

        try {
            MapsInitializer.initialize(activity.applicationContext)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        mapView.getMapAsync({ map ->

            barList.forEach { bar ->
                val barPoint = LatLng(bar.coordinates.lat,
                        bar.coordinates.lng)

                val markerOption = MarkerOptions()
                        .position(barPoint)
                        .title(bar.name)
                        .snippet(bar.address)
                val marker = map.addMarker(markerOption)
            }

        })

        val firstBar = barList.first()
        moveToBar(firstBar)

        return rootView
    }

    fun moveToBar(bar: Bar) {
        mapView.getMapAsync({ mMap ->

            val position = LatLng(bar.coordinates.lat, bar.coordinates.lng)

            val cameraPosition = CameraPosition.Builder().target(position).zoom(15f).build()
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
        })
    }

}// Required empty public constructor
