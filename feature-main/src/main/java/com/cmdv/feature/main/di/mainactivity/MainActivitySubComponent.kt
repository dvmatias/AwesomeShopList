package com.cmdv.feature.main.di.mainactivity

import com.cmdv.core.base.di.ViewComponent
import com.cmdv.feature.main.ui.MainActivity
import dagger.Subcomponent

@Subcomponent(
	modules = [MainActivityModule::class]
)
interface MainActivitySubComponent : ViewComponent<MainActivity>