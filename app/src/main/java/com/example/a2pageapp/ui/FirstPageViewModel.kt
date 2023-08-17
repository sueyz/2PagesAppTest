package com.example.a2pageapp.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a2pageapp.model.DataResponse
import com.example.a2pageapp.util.JsonUtil.getAsset

class FirstPageViewModel: ViewModel() {

    private val _contactList = MutableLiveData<List<DataResponse>>()
    val contactList : LiveData<List<DataResponse>> = _contactList

    fun handleGetData(context: Context?) {
        val test = getAsset(context)

        _contactList.value = test
    }
}