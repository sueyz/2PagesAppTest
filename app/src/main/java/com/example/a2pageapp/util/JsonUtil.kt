package com.example.a2pageapp.util

import android.content.Context
import com.example.a2pageapp.model.DataResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object JsonUtil {

    fun getAsset(context: Context?): List<DataResponse> {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val listType = Types.newParameterizedType(List::class.java, DataResponse::class.java)
        val adapter: JsonAdapter<List<DataResponse>> = moshi.adapter(listType)

        val file = "data.json"

        val myjson = context?.assets?.open(file)?.bufferedReader().use{ it?.readText()}

        return myjson?.let { adapter.fromJson(it) }!!
    }

}