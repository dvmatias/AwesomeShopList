package com.cmdv.awesomeshoplist

import com.cmdv.awesomeshoplist.navigator.NavigatorImp
import com.cmdv.core.base.BaseApplication
import com.cmdv.core.navigator.Navigator

class ProjectApp : BaseApplication() {

	override fun onCreate() {
		super.onCreate()
	}

	override fun bindNavigator(): Navigator =
		NavigatorImp()

}