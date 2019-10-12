package com.example.lab5.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.lab5.DataModel.CatModel
import com.example.lab5.R
import com.google.gson.GsonBuilder


class DataModel (application: Application) : AndroidViewModel(application){

    val context: Application = application
    private lateinit var catList: MutableList<CatModel>
    var imageUrl = MutableLiveData<String>()
    var name = MutableLiveData<String>()
    var listCompleted = MutableLiveData<Boolean>()
    var cuteScore = MutableLiveData<Int>()
    var notCuteScore = MutableLiveData<Int>()

    init {
        readJsonFile()
        nextItem()
        listCompleted.value = false

        cuteScore.value = 0
        notCuteScore.value = 0
    }

    fun readJsonFile() {
        val text =
            context.resources.openRawResource(R.raw.cat)
                .bufferedReader().use { it.readText() }

        val gson = GsonBuilder().create()
        catList= gson.fromJson(text,Array<CatModel>::class.java).toMutableList()

    }

    fun nextItem() {
        lateinit var cat: CatModel
        if(catList.size>0){
            cat = catList.removeAt(0)
            imageUrl.value = cat.image_url
            name.value = cat.name
        }else {
            listCompleted.value = true
        }

    }

    fun cuteClicked() {
        cuteScore.value = (cuteScore.value)?.plus(1)
        nextItem()
    }

    fun notCuteClicked() {
        notCuteScore.value = (notCuteScore.value)?.plus(1)
        nextItem()
    }







}