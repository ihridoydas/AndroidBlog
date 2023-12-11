package com.hridoy.androidblog.di

import android.content.Context
import com.hridoy.androidblog.local.PrefDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * Ajhbjh
 * jbnkj
 * jbhjhbkj
 * jkn kj
 *
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePreferencesDatastore(@ApplicationContext appContext: Context): PrefDataStore = PrefDataStore(appContext)

}