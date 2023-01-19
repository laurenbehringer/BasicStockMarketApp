package com.plcoding.stockmarketapp.datas.remote

import com.plcoding.stockmarketapp.datas.remote.dto.CompanyInfoDTO
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query


interface StockApi {

   @GET("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("apikey") apikey: String = API_KEY
    ): ResponseBody

    @GET("query?function=TIME_SERIES_INTRADAY&interval=60min&datatype=csv")
    suspend fun getIntradayInfo(
        @Query("symbol") symbol: String,
        @Query("apikey") apikey: String = API_KEY,
    ): ResponseBody

    @GET("query?function=OVERVIEW")
    suspend fun getCompanyInfo(
        @Query("symbol") symbol: String,
        @Query("apikey") apikey: String = API_KEY
    ): CompanyInfoDTO

    companion object{
        const val API_KEY = "T6ZX0XG18ZY943Q2"
        const val BASE_URL= "https://alphavantage.co"
    }



}