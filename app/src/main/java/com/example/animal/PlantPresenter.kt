package com.example.animal

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlantPresenter(private val view: SecondFragment):PlantViewInterfacePresenter {
    val Name = mutableListOf("")//儲存植物名稱
    val Info = mutableListOf("")//儲存植物資訊
    val Pic = mutableListOf("")//儲存植物圖片URL

    override fun processCall() {
        val service =
            RetrofitInstance().retrofitInstance.create(APIinterface::class.java)
        val call=service.getPosts2()
        call.enqueue(object : Callback<Plant> {
            override fun onFailure(call: Call<Plant>, t: Throwable) {
            }
            override fun onResponse(call: Call<Plant>, response: Response<Plant>) {
                val data=response.body()
                val lim = data?.result?.results.toString()
                Log.d("ooo",lim)
                for (i in 0..data!!.result?.results!!.size-1){
                    Name.add(data!!.result?.results!![i].F_AlsoKnown)
                    Info.add(data!!.result?.results!![i].F_Location)
                    Pic.add(data!!.result?.results!![i].F_Pic01_URL)
                }
                Name.removeAt(0)
                Info.removeAt(0)
                Pic.removeAt(0)
                view.show(Name,Info,Pic)
            }
        })
    }
}


