package com.sunnyweather.android.logic.model

import RealtimeResponse


//天气类用于将Dailu和Realtime封装起来
data class Weather(val realtime:RealtimeResponse.Realtime,val daily:DailyResponse.Daily) {
}