package com.yedebkid.rpcviewerplayer.rest

import okhttp3.Interceptor
import okhttp3.Response

//adds more information to the request the server will be using. Version, envt,toaken
class RequestInterceptors: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        TODO("Not yet implemented")
    }
}
//doing some thing before doing some thing
class ResponseInterceptors: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        TODO("Not yet implemented")
    }
}