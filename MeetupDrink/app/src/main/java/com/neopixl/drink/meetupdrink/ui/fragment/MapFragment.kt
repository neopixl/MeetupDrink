package com.neopixl.drink.meetupdrink.ui.fragment


import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.neopixl.drink.meetupdrink.R
import com.neopixl.drink.meetupdrink.model.Bar
import com.pawegio.kandroid.find
import com.pawegio.kandroid.toast


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
    val markerList = mutableListOf<Marker>()


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
            markerList.clear()
            barList.forEach { bar ->
                val barPoint = LatLng(bar.coordinates.lat,
                        bar.coordinates.lng)

                val markerOption = MarkerOptions()
                        .position(barPoint)
                        .title(bar.name)
                        .snippet(bar.address)
                val marker = map.addMarker(markerOption)
                markerList.add(marker)
            }

        })

        val firstBar = barList.first()
        moveToBar(firstBar)

        return rootView
    }

    override fun onStart() {
        super.onStart()

        val grantStatus = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
        if (grantStatus == PackageManager.PERMISSION_GRANTED) {
            // Show the location
            showMyLocation()
        } else {
            // request it
            requestPermision()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 100 && grantResults.size == 1) {
            val result = grantResults[0]
            if (result == PackageManager.PERMISSION_GRANTED) {
                toast("Granted")
                showMyLocation()
            } else {
                toast("Not granted")
            }
        }
    }

    fun moveToBar(bar: Bar) {
        mapView.getMapAsync({ mMap ->
            val indexOfBar = barList.indexOf(bar)
            val marker = markerList[indexOfBar]
            val position = marker.position

            val cameraPosition = CameraPosition.Builder().target(position).zoom(15f).build()
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
            marker.showInfoWindow()
        })
    }

    @SuppressLint("MissingPermission")
    fun showMyLocation() {
        mapView.getMapAsync({ map ->
            map.isMyLocationEnabled = true
        })
    }

    fun requestPermision() {
        requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 100)
    }

}// Required empty public constructor
