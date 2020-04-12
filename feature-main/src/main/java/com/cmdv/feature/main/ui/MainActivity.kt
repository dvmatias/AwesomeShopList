package com.cmdv.feature.main.ui

import android.os.Bundle
import android.view.Menu
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
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar


class MainActivity :
	BaseActivity<
			MainActivity,
			MainActivityPresenter,
			MainActivitySubComponent>(),
	MainActivityContract.View {

	private lateinit var appBarConfiguration: AppBarConfiguration

	override fun bindComponent(): MainActivitySubComponent =
		MainUiComponent.component.plus(MainActivityModule())

	override fun bindLayout(): Int =
		R.layout.activity_main

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val toolbar: Toolbar = findViewById(R.id.toolbar)
		setSupportActionBar(toolbar)

		val fab: FloatingActionButton = findViewById(R.id.fab)
		fab.setOnClickListener { view ->
			Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
				.setAction("Action", null).show()
		}
		val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
		val navView: NavigationView = findViewById(R.id.nav_view)
		val mainContent: FrameLayout = findViewById(R.id.main_content)
		val navController = findNavController(R.id.main_nav_host_fragment)
		appBarConfiguration = AppBarConfiguration(
			setOf(
				R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
			), drawerLayout
		)
		navView.setupWithNavController(navController)

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

	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		// Inflate the menu; this adds items to the action bar if it is present.
		menuInflater.inflate(R.menu.main, menu)
		return true
	}

	override fun onSupportNavigateUp(): Boolean {
		val navController = findNavController(R.id.main_nav_host_fragment)
		return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
	}

}
