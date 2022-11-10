import com.google.gson.annotations.SerializedName
data class RealtimeResponse(val status:String, val result:Result){

    data class Result(val realtime:Realtime)

    data class Realtime(val skycon:String,val temperature:Float,@SerializedName("air_quality") val airQuality:AirQuality)

    data class AirQuality(val aqi:AQI)

    data class AQI(val chn:Float)


}
//实时天气数据   链接https://api.caiyunapp.com/v2.5/nhPN9uZunMNattmi/121.6544,25.1552/realtime.json   其json数据如下
//{"status":"ok","api_version":"v2.5",
// "api_status":"active","lang":"zh_CN",
// "unit":"metric",
// "tzshift":28800,
// "timezone":"Asia/Taipei",
// "server_time":1667889667,
// "location":[25.1552,121.6544],
// "result":{
// "realtime":{
// "status":"ok",
// "temperature":20.0,
// "humidity":0.86,
// "cloudrate":0.93,
// "skycon":"MODERATE_RAIN",
// "visibility":1.23,
// "dswrf":93.4,
// "wind":{
// "speed":21.45,"direction":59.35},
// "pressure":100057.49,
// "apparent_temperature":18.2,
// "precipitation":{
// "local":
// {"status":"ok","datasource":"gfs","intensity":0.2732}},
// "air_quality":{"pm25":4,"pm10":0,"o3":0,"so2":0,"no2":0,"co":0,
// "aqi":{"chn":8,"usa":0},
// "description":{"usa":"","chn":"优"}},
// "life_index":{"ultraviolet":{"index":2.0,"desc":"很弱"},"comfort":{"index":5,"desc":"舒适"}}},"primary":0}}
