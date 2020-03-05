package dev.msfjarvis.daggertutorial.di

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dev.msfjarvis.daggertutorial.MainActivity
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

@CounterScreenScope
@Subcomponent(modules = [CounterScreenModule::class])
interface CounterScreenComponent {
    fun inject(counterActivity: MainActivity)
}

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun counterScreenComponent(counterScreenModule: CounterScreenModule): CounterScreenComponent
}

@Module
class AppModule {
    private var index = 0
    @Provides
    fun getCounter(): Counter {
        index++
        return Counter("Counter $index")
    }
}
