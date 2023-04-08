package com.example.assignment_map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment_map.databinding.ActivityMainBinding
import com.example.assignment_map.databinding.ActivityMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity() {


    private var binding: ActivityMapBinding?= null

    lateinit var mapFragment: SupportMapFragment

    lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        val emailSend = intent.getStringExtra("email")
        binding!!.titleEmail.text = emailSend

        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {

            googleMap = it

            //val location = LatLng(13.03,77.60)  You can use latitude and longitude to show exact location you want
            val location = googleMap.cameraPosition.target
            googleMap.addMarker(MarkerOptions().position(location).title("Center Location"))

            //Zoom Level Google map(0 to 21)
            //1: World
            //5: Landmass/Continent
            //10: City
            //15: Streets
            //20: Buildings

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location,5f))

        })
    }


}