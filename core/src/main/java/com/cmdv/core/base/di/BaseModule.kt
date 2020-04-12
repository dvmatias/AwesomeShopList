package com.cmdv.core.base.di

import android.app.Application
import android.content.Context
import com.cmdv.core.base.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BaseModule(private val app: BaseApplication) {
    
    @Provides
    @Singleton
    fun provideApplication(): Application = app
    
    @Provides
    @Singleton
    fun provideContext(): Context = app
    
}