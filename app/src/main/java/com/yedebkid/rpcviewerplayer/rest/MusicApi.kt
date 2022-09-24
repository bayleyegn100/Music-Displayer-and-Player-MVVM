package com.yedebkid.rpcviewerplayer.rest

import com.yedebkid.rpcviewerplayer.model.MusicData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicApi {

    @GET(PATH_SEARCH)

    suspend fun getPopMusics(
    @Query("term") genre: String = "pop",
    @Query("amp;media") media: String = "music",
    @Query("amp;entity") entity: String = "song",
    @Query("amp;limit") limit: Int = 50
    ): Response<MusicData>

  @GET(PATH_SEARCH)

  suspend fun getMusicsByGenre(
    @Query("term") genre: String? = null,
    @Query("amp;media") media: String? = null,
    @Query("amp;entity") entity: String? = null,
    @Query("amp;limit") limit: Int? = 50
    ): Response<MusicData>

    @GET(PATH_SEARCH)
    suspend fun getRockMusics(
        @Query("term") genre: String = "rock",
        @Query("amp;media") media: String = "music",
        @Query("amp;entity") entity: String = "song",
        @Query("amp;limit") limit: Int = 50
    ): Response<MusicData>

    @GET(PATH_SEARCH)
    suspend fun getClassicMusics(
        @Query("term") genre: String = "classic",
        @Query("amp;media") media: String = "music",
        @Query("amp;entity") entity: String = "song",
        @Query("amp;limit") limit: Int = 50
    ): Response<MusicData>

    companion object {
        const val BASE_URL = "https://itunes.apple.com/"
        private const val PATH_SEARCH= "search"
    }

}