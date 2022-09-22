package com.yedebkid.rpcviewerplayer.dependencyIngection

import com.google.gson.Gson
import com.yedebkid.rpcviewerplayer.rest.MusicApi
import com.yedebkid.rpcviewerplayer.rest.RequestInterceptors
import com.yedebkid.rpcviewerplayer.rest.ResponseInterceptors
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpCookie
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    @Provides
    fun provideGson(): Gson = Gson()
    @Provides
    fun provideRequestInterceptor(): RequestInterceptors =
        RequestInterceptors()
    @Provides
    fun provideResponseInterceptor(): ResponseInterceptors =
        ResponseInterceptors()

    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    @Provides
    fun providesOkhttpClients(
        requestInterceptors: RequestInterceptors,
        responseInterceptors: ResponseInterceptors,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(requestInterceptors)
            .addInterceptor(responseInterceptors)
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl(MusicApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    fun providesMusicsApi(retrofit: Retrofit): MusicApi =
        retrofit.create(MusicApi::class.java)
}