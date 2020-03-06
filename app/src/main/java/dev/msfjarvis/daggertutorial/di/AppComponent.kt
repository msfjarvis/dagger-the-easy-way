package dev.msfjarvis.daggertutorial.di

import dagger.BindsInstance
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
    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance counterScreenModule: CounterScreenModule): CounterScreenComponent
    }
}

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    val counterScreenComponentFactory: CounterScreenComponent.Factory
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
