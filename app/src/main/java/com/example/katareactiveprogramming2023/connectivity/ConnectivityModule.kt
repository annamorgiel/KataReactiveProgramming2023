package com.example.katareactiveprogramming2023.connectivity

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ConnectivityModule {

    @Provides
    @Singleton
    internal fun connectivityObserver(@ApplicationContext context: Context): ConnectivityObserver = NetworkConnectivityObserver(context)

}
