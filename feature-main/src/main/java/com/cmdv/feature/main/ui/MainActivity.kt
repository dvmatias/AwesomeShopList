package com.cmdv.feature.main.ui

import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.cmdv.core.base.mvp.BaseActivity
import com.cmdv.feature.R
import com.cmdv.feature.main.di.mainactivity.MainActivityModule
import com.cmdv.feature.main.di.mainactivity.MainActivitySubComponent
import com.google.android.material.navigation.NavigationView


class MainActivity :
	BaseActivity<
			MainActivity,
			MainActivityPresenter,
			MainActivitySubComponent>(),
	MainActivityContract.View {

	private lateinit var drawerLayout: DrawerLayout
	private lateinit var navView: NavigationView
	private lateinit var mainContent: FrameLayout
	private lateinit var toolbar: Toolbar

	override fun bindComponent(): MainActivitySubComponent =
		MainUiComponent.component.plus(MainActivityModule())

	override fun bindLayout(): Int =
		R.layout.activity_main

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		drawerLayout = findViewById(R.id.drawer_layout)
		navView = findViewById(R.id.nav_view)
		mainContent = findViewById(R.id.main_content)
		toolbar = findViewById(R.id.toolbar)

		setSupportActionBar(toolbar)
		setupDrawerLayout()

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			val decor = window.decorView
			decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

		}
	}

	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		// Inflate the menu; this adds items to the action bar if it is present.
		menuInflater.inflate(R.menu.main, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		when (item.itemId) {
			R.id.action_add -> {
				showToast("Add shop list")
			}
			R.id.action_search -> {
				showToast("Search shop list")
			}
		}
		return super.onOptionsItemSelected(item)
	}

	private fun setupDrawerLayout() {
		val displayMetrics = DisplayMetrics()
		windowManager.defaultDisplay.getMetrics(displayMetrics)
		val params = navView.layoutParams as DrawerLayout.LayoutParams
		params.width = (displayMetrics.widthPixels * 0.8).toInt()
		navView.layoutParams = params

		val drawerToggle = object : ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.acc_drawer_open, R.string.acc_drawer_close) {
			override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
				super.onDrawerSlide(drawerView, slideOffset)
				val moveFactor: Float = navView.width * slideOffset
				mainContent.translationX = moveFactor
			}
		}

		drawerLayout.addDrawerListener(drawerToggle)
		drawerToggle.syncState()
	}

}
