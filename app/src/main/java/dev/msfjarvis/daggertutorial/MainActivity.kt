package dev.msfjarvis.daggertutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val prefs = ExampleApplication.component.preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (prefs.getBoolean("first_start", true)) {
            Toast.makeText(this, "First start!", Toast.LENGTH_LONG).show()
            prefs.edit().putBoolean("first_start", false).apply()
        } else {
            Toast.makeText(this, "Not first start!", Toast.LENGTH_LONG).show()
        }
    }
}
