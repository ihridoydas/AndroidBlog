package com.hridoy.androidblog.di

import android.content.Context
import com.hridoy.androidblog.model.data.local.PrefDataStore
import com.hridoy.androidblog.model.interfaces.services.UserServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePreferencesDatastore(@ApplicationContext appContext: Context): PrefDataStore = PrefDataStore(appContext)

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideUserServices(retrofit: Retrofit):UserServices{
        return retrofit.create(UserServices::class.java)
    }

}