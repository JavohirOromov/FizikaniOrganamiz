package com.example.fizikaniorganamiz.app
import android.app.Application
/**
 * Creator: Javohir Oromov
 * Project: Fizikani O'rganamiz
 * Date: 19/03/25
 * Javohir's MacBook Air
 */
class App: Application(){
    override fun onCreate() {
        super.onCreate()
        AppRepository.init()
    }
}