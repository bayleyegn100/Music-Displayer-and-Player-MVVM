package com.yedebkid.rpcviewerplayer.dependencyIngection

import com.yedebkid.rpcviewerplayer.rest.MusicRepo
import com.yedebkid.rpcviewerplayer.rest.MusicRepoImplementation
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun providesRepository(
        musicsRepositoryImpl: MusicRepoImplementation
    ): MusicRepo
}