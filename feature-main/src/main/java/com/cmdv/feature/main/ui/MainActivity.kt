package com.cmdv.feature.main.ui

import android.os.Bundle
import com.cmdv.core.base.mvp.BaseActivity
import com.cmdv.feature.R
import com.cmdv.feature.main.di.mainactivity.MainActivityModule
import com.cmdv.feature.main.di.mainactivity.MainActivitySubComponent

class MainActivity :
	BaseActivity<
			MainActivity,
			MainActivityPresenter,
			MainActivitySubComponent>(),
	MainActivityContract.View {

	override fun bindComponent(): MainActivitySubComponent =
		MainUiComponent.component.plus(MainActivityModule())

	override fun bindLayout(): Int =
		R.layout.activity_main

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

	}

}
