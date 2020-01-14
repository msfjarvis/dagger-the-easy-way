package dev.msfjarvis.daggertutorial.di

import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

}

@Module
object AppModule {

}
