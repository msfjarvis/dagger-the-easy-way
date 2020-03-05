package dev.msfjarvis.daggertutorial.di

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope
import javax.inject.Singleton

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class CounterScreenScope

data class Counter(val name: String)
class CounterPresenter(val counter: Counter)

@Module
class CounterScreenModule {
    @Provides
    @CounterScreenScope
    fun provideCounterPresenter(counter: Counter): CounterPresenter {
        return CounterPresenter(counter)
    }
}

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent

@Module
class AppModule {
    private var index = 0
    @Provides
    fun getCounter(): Counter {
        index++
        return Counter("Counter $index")
    }
}
