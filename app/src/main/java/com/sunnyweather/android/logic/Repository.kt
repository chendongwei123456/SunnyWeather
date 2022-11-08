package com.sunnyweather.android.logic

import Place
import androidx.lifecycle.liveData
import com.sunnyweather.android.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers

object Repository {//返回一个liveData对象给调用层


    fun searchPlaces(query:String)= liveData(Dispatchers.IO){//换成Dispatcher保证代码块里的代码在子线程中运行
        //  Android不允许网络请求或读写数据库之类的本地数据库操作 在主线程中进行
        val result=try {
            val placeResponse=SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status =="ok"){
                val places =placeResponse.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)//将包装结果发送   相当于liveData里面的setValue
    }//liveData中提供一个挂起函数的上下文就可以在里面调用任意挂起函数


}