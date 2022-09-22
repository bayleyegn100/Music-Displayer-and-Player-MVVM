package com.yedebkid.rpcviewerplayer.rest

import com.yedebkid.rpcviewerplayer.model.domain.mapToDomainMusicList
import com.yedebkid.rpcviewerplayer.util.FailureResponseFromServer
import com.yedebkid.rpcviewerplayer.util.GenreType
import com.yedebkid.rpcviewerplayer.util.NullResponseFromServer
import com.yedebkid.rpcviewerplayer.util.UIState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

private const val TAG = "MusicRepo"

interface MusicRepo {
    fun getMusicByGenre(genreType: GenreType): Flow<UIState>
}

class MusicRepoImplementation @Inject constructor(
    private val musicApi: MusicApi
) : MusicRepo {
    override fun getMusicByGenre(genreType: GenreType): Flow<UIState> = flow {
            emit(UIState.LOADING)
            delay(2000)
            try {
                val response = musicApi.getMusicsByGenre(genreType.termType)
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(UIState.SUCCESS(it.musicResults.mapToDomainMusicList()))
                    } ?: throw NullResponseFromServer("Unable to get a music with the given genre")
                } else {
                    throw FailureResponseFromServer(response.errorBody()?.toString())
                }

            } catch (e: Exception) {
                emit((UIState.ERROR(e)))
            }
        }
}