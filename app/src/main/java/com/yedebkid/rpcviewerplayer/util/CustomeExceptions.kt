package com.yedebkid.rpcviewerplayer.util

import java.lang.Exception

class NullResponseFromServer(message: String): Exception(message)
class FailureResponseFromServer(message: String?): Exception(message)