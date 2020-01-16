package dev.msfjarvis.daggertutorial

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.preference.PreferenceManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        if (prefs.getBoolean("first_start", true)) {
            Toast.makeText(this, "First start!", Toast.LENGTH_LONG).show()
            prefs.edit().putBoolean("first_start", false).apply()
        } else {
            Toast.makeText(this, "Not first start!", Toast.LENGTH_LONG).show()
        }
    }
}
