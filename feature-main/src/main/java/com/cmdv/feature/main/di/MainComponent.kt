package com.cmdv.feature.main.di

import com.cmdv.core.base.di.BaseComponent
import com.cmdv.feature.main.di.mainactivity.MainActivityModule
import com.cmdv.feature.main.di.mainactivity.MainActivitySubComponent
import dagger.Component

@Component(
	dependencies = [BaseComponent::class],
	modules = [MainModule::class]
)
@MainScope
interface MainComponent {

	fun plus(target: MainActivityModule): MainActivitySubComponent

}