package com.yedebkid.rpcviewerplayer.dependencyIngection

import android.app.Application

class MussicApp: Application() {

    override fun onCreate() {
        super.onCreate()
//        musicComponent = DaggerMusicComponent.builder()
//            .applicationMoudule(ApplicationModule(this))
//            .build()
    }
    companion object{
        lateinit var musicComponent: MusicComponent
    }
}