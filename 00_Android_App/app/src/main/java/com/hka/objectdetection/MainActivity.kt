package com.hka.objectdetection
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.hka.objectdetection.databinding.ActivityMainBinding

/**
Die MainActivity stellt die Navigation bereit und zeigt den aktuellen Verbindungsstatus zum MQTT-Server an
 */
class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        activityMainBinding.navigation.setupWithNavController(navController)
        activityMainBinding.navigation.setOnNavigationItemReselectedListener {
            // ignore the reselection
        }
        val overlay = findViewById<LinearLayout>(R.id.mqttStatusOverlay)
        val icon = findViewById<ImageView>(R.id.mqttStatusIcon)
        val text = findViewById<TextView>(R.id.mqttStatusText)

        viewModel.mqttConnected.observe(this) { connected ->
            overlay.visibility = View.VISIBLE
            if (connected) {
                icon.setImageResource(R.drawable.ic_cloud_on)
                text.text = "MQTT Verbunden"
            } else {
                icon.setImageResource(R.drawable.ic_cloud_off)
                text.text = "MQTT Getrennt"
            }
        }

    }

    override fun onBackPressed() {
        finish()
    }
}
