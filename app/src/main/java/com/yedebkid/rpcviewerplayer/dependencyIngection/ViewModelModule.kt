package com.yedebkid.rpcviewerplayer.dependencyIngection

import androidx.lifecycle.ViewModelProvider
import com.yedebkid.rpcviewerplayer.rest.MusicApi
import com.yedebkid.rpcviewerplayer.rest.MusicRepo
import com.yedebkid.rpcviewerplayer.util.MusicsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {
    @Provides
    fun providesViewModelFactory(
        repository: MusicRepo
    ): ViewModelProvider.Factory =
        MusicsViewModelFactory(repository)
}