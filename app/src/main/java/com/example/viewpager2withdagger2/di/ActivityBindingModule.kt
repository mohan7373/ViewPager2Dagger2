package com.example.viewpager2withdagger2.di

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.example.viewpager2withdagger2.*
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * We want Dagger.Android to create a Subcomponent which has a parent Component of whichever module
 * ActivityBindingModule is on, in our case that will be [AppComponent]. You never
 * need to tell [AppComponent] that it is going to have all these subcomponents
 * nor do you need to tell these subcomponents that [AppComponent] exists.
 * We are also telling Dagger.Android that this generated SubComponent needs to include the
 * specified modules and be aware of a scope annotation [@ActivityScoped].
 * When Dagger.Android annotation processor runs it will create 2 subcomponents for us.
 */
@Module
abstract class  ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainFrag::class,FirstFrag::class,SecFrag::class,EndFrag::class])
    internal abstract fun mainActivity(): MainActivity


}

@Module
abstract class FirstFrag{
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeMainFragment(): FirstFragment
}

@Module
abstract class SecFrag{
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeMainFragment(): SecondFragment
}

@Module
abstract class MainFrag{
    @FragmentScoped
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    internal abstract fun contributeMainFragment(): MainFragment
}

@Module
abstract class EndFrag{
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeMainFragment(): EndFragment
}

@Module
class MainFragmentModule{
    @Provides
    @FragmentScoped
    fun getFragmentManager(mainFragment: MainFragment): FragmentManager {
        return mainFragment.childFragmentManager
    }

    @Provides
    @FragmentScoped
    fun getLifeCycle(mainFragment: MainFragment): Lifecycle {
        return mainFragment.lifecycle
    }
}