package com.yedebkid.rpcviewerplayer.dependencyIngection

import com.yedebkid.rpcviewerplayer.rest.MusicRepo
import com.yedebkid.rpcviewerplayer.util.MusicsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(

) {
    @Provides
    fun providesViewModelFactory(
        repository: MusicRepo
    ): MusicsViewModelFactory =
        MusicsViewModelFactory(repository)
}