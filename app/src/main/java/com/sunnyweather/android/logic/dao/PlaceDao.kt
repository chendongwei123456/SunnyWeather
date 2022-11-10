package com.sunnyweather.android.logic.dao

import Place
import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.sunnyweather.android.SunnyWeatherApplication

object PlaceDao {
    //记录选中城市

    fun savePlace(place:Place){
        sharedPreferences().edit(){
            putString("place",Gson().toJson(place))
        }
    }//将place对象存储到SharedPreferences   技巧：通过Gson将place对象转换成json字符串


    fun getSavedPlace():Place{
        val placeJson= sharedPreferences().getString("place","")
        return Gson().fromJson(placeJson,Place::class.java)
    }//将json字符串从SharedPreferences中读取出来    再通过Gson将json字符串解析成place对象


    fun isPlaceSaved()= sharedPreferences().contains("place") //判断数据是否存储

    private fun sharedPreferences() = SunnyWeatherApplication.context.getSharedPreferences("sunny_weather",
        Context.MODE_PRIVATE)

}