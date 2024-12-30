package com.imran.srdb.data.api

import java.io.IOException

const val BASE_URL = "https://jsonplaceholder.typicode.com/"
class ApiException(message: String): IOException(message)