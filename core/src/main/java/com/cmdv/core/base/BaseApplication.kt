package com.cmdv.core.base

import android.app.Application
import com.cmdv.core.base.di.BaseComponent
import com.cmdv.core.base.di.BaseModule
import com.cmdv.core.base.di.DaggerBaseComponent
import com.cmdv.core.navigator.Navigator

abstract class BaseApplication : Application() {

	companion object {
		lateinit var baseComponent: BaseComponent
		internal lateinit var navigator: Navigator
	}

	abstract fun bindNavigator(): Navigator

	override fun onCreate() {
		super.onCreate()
		initInjector()
		initNavigator()
	}

	private fun initInjector() {
		baseComponent = DaggerBaseComponent
			.builder()
			.baseModule(BaseModule(this))
			.build()
	}

	private fun initNavigator() {
		navigator = bindNavigator()
	}

}