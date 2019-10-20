package com.example.recynestedgroupdate

import br.com.mirabilis.jambu_air.model.mTOP
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("jambu_air.php")
    fun getBuah() : Call<ArrayList<mTOP>>

}