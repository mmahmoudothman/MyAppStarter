package com.ozman.myappstarter.data.data_source.reomte.response

import com.google.gson.annotations.SerializedName
import com.ozman.myappstarter.data.data_source.local.AppEntity

data class AppDataResponse(
    @SerializedName("results")
    val data: List<AppEntity>
)
