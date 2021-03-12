package ru.psu.mobile.example1.view.activities

import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import ru.psu.mobile.example1.R

class CActivityMap : AppCompatActivity(), OnMapReadyCallback {

    private var map: GoogleMap? = null
    private var fusedLocationProviderClient : FusedLocationProviderClient?  = null
    private var lastKnownLocation: Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)




        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)

        // Construct a FusedLocationProviderClient.
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map?.let{
            it.mapType = GoogleMap.MAP_TYPE_HYBRID
            //Вместо try надо делать нормальный диалог для предоставления разрешения приложению.ёёёёёёё
            try{
                it.isMyLocationEnabled = true
            }
            catch(e: SecurityException)
            {

            }
        }

        // Get the current location of the device and set the position of the map.
        // Это делать вручную не надо, автоматически делается командой it.isMyLocationEnabled = true
        //getDeviceLocation()

    }

    private fun getDeviceLocation() {
        /*
     * Get the best and most recent location of the device, which may be null in rare
     * cases when a location is not available.
     */
        try {
            val locationResult = fusedLocationProviderClient!!.lastLocation
            locationResult.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Set the map's camera position to the current location of the device.
                    lastKnownLocation = task.result
                    lastKnownLocation?.let {
                        map?.moveCamera(
                            CameraUpdateFactory.newLatLng(
                                LatLng(
                                    it.latitude,
                                    it.longitude
                                )
                            )
                        )
                        map?.addMarker(
                            MarkerOptions()
                                .position(LatLng(it.latitude, it.longitude))
                                .title("Current location")
                        )

                    }
                } else {
                    //Log.d(TAG, "Current location is null. Using defaults.")
                    //Log.e(TAG, "Exception: %s", task.exception)
                    //map?.moveCamera(CameraUpdateFactory
                    //    .newLatLngZoom(defaultLocation, DEFAULT_ZOOM.toFloat()))
                    map?.uiSettings?.isMyLocationButtonEnabled = false
                }
            }
        } catch (e: SecurityException) {
            //Log.e("Exception: %s", e.message, e)
        }
    }
}