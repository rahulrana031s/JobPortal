package com.example.jobportal.ui.di

import com.example.jobportal.ui.api.PortalData
import com.example.jobportal.ui.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }



    @Singleton
    @Provides
    fun providesUserAPI(retrofitBuilder: Retrofit.Builder): PortalData {
        return retrofitBuilder.build().create(PortalData::class.java)
    }




}
