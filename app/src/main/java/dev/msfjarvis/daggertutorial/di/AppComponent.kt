package dev.msfjarvis.daggertutorial.di

import dagger.Component
import dagger.Module
import javax.inject.Singleton

data class Counter(val name: String)
class CounterPresenter(val counter: Counter)

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent

@Module
class AppModule
