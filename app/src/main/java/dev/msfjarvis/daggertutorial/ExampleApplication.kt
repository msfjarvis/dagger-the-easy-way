package dev.msfjarvis.daggertutorial

import android.app.Application
import dev.msfjarvis.daggertutorial.di.AppComponent
import dev.msfjarvis.daggertutorial.di.DaggerAppComponent

class ExampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.factory().create(this)
    }
    companion object {
        lateinit var component: AppComponent
    }
}
