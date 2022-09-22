package com.yedebkid.rpcviewerplayer.dependencyIngection

import com.yedebkid.rpcviewerplayer.MainActivity
import com.yedebkid.rpcviewerplayer.view.ClassicFragment
import com.yedebkid.rpcviewerplayer.view.PopFragment
import com.yedebkid.rpcviewerplayer.view.RockFragment
import dagger.Component

@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        ViewModelModule::class
    ]
)
interface MusicComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(popMusicFragment: PopFragment)
    fun inject(rockMusicFragment: RockFragment)
    fun inject(classicMusicFragment: ClassicFragment)
}