package com.cmdv.awesomeshoplist.navigator

import android.app.Activity
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat
import com.cmdv.core.extensions.navigateTo
import com.cmdv.core.navigator.Navigator
import com.cmdv.feature.addshoplist.ui.AddShopListActivity

class NavigatorImp: Navigator {

	override fun toAddShopListScreen(activityOrigin: Activity, bundle: Bundle?, options: ActivityOptionsCompat?, finish: Boolean) {
		activityOrigin.navigateTo<AddShopListActivity>(bundle, options, finish)
	}
}