package com.kamalnayan.catgallery.di

import com.kamalnayan.catgallery.BuildConfig
import com.kamalnayan.data.api.AppApiService
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/** @Author Kamal Nayan
Created on: 25/01/24
 **/
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    fun provideOkHttpClient(
    ): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .apply {
                if (BuildConfig.DEBUG){
                    addInterceptor(logging)
                }
            }
            .build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): AppApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()

        return retrofit.create(AppApiService::class.java)
    }
}