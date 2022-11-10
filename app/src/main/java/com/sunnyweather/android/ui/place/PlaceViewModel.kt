package com.sunnyweather.android.ui.place

import Place
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweather.android.logic.Repository

class PlaceViewModel :ViewModel() {
    val placeList=ArrayList<Place>() //用于对界面上显示的城市数据进行缓存
    private val searchLiveData =MutableLiveData<String>()


    val placeLiveData=Transformations.switchMap(searchLiveData){
        query->Repository.searchPlaces(query) //仓库层返回一个livedata对象
    }

    fun searchPlaces(query:String){
        searchLiveData.value=query
    }

    fun savePlace(place: Place) = Repository.savePlace(place)

    fun getSavedPlace() = Repository.getSavedPlace()

    fun isPlaceSaved() = Repository.isPlaceSaved()

}