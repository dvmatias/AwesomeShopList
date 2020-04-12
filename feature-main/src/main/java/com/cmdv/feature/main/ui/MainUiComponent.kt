package com.cmdv.feature.main.ui

import com.cmdv.core.base.BaseApplication
import com.cmdv.feature.main.di.DaggerMainComponent
import com.cmdv.feature.main.di.MainComponent
import com.cmdv.feature.main.di.MainModule

internal class MainUiComponent {

	companion object {
		internal val component: MainComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
			createComponent()
		}

		@Suppress("DEPRECATION")
		private fun createComponent(): MainComponent =
			DaggerMainComponent.builder()
				.baseComponent(BaseApplication.baseComponent)
				.mainModule(MainModule())
				.build()
	}

}