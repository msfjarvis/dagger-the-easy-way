package dev.msfjarvis.daggertutorial.di

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    val preferences: SharedPreferences
}

@Module
object AppModule {

    @Provides
    @Reusable
    fun provideSharedPrefs(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
}
