package com.ozman.myappstarter.data.data_source.reomte

import com.ozman.myappstarter.data.data_source.reomte.response.AppDataResponse
import retrofit2.http.GET

interface RetrofitService {

    @GET("getData")
    suspend fun getAllEntities(): AppDataResponse
}