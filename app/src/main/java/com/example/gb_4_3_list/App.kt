package com.example.gb_4_3_list

import android.app.Application
import org.koin.core.context.startKoin

class App : Application()  {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                DI.getModule()
            )
        }
    }
}
