package com.example.viewpager2withdagger2

import android.util.Log
import com.example.viewpager2withdagger2.di.DaggerAppComponent

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Log.e("onCreate","onCreate");
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

}