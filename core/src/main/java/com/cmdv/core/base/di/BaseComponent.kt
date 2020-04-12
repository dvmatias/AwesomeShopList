package com.cmdv.core.base.di

import android.app.Application
import android.content.Context
import com.cmdv.core.base.di.coroutineDispatcher.CoroutinesModule
import com.cmdv.core.base.di.network.NetworkModule
import com.cmdv.core.base.di.storage.StorageModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
	modules = [
		BaseModule::class,
		NetworkModule::class,
		StorageModule::class,
		CoroutinesModule::class
	]
)
interface BaseComponent {

	fun application(): Application

	fun context(): Context

}