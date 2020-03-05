package dev.msfjarvis.daggertutorial

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dev.msfjarvis.daggertutorial.di.AppModule
import dev.msfjarvis.daggertutorial.di.CounterPresenter
import dev.msfjarvis.daggertutorial.di.CounterScreenModule
import dev.msfjarvis.daggertutorial.di.DaggerAppComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: CounterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appComponent = DaggerAppComponent.builder()
            .appModule(AppModule())
            .build()

        val counterScreenComponent = appComponent
            .counterScreenComponent(CounterScreenModule())
        counterScreenComponent.inject(this)
        Log.d(TAG, presenter.counter.name)
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
