package com.cmdv.core.base

import android.app.Application
import com.cmdv.core.base.di.BaseComponent
import com.cmdv.core.base.di.BaseModule

abstract class BaseApplication : Application() {

	companion object {
		lateinit var baseComponent: BaseComponent
	}

	override fun onCreate() {
		super.onCreate()
//		initInjector()
	}

	private fun initInjector() {
//		baseComponent = DaggerBaseComponent
//			.builder()
//			.baseModule(BaseModule(this))
//			.build()
	}

}