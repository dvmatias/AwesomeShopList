package com.cmdv.core.base.mvp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cmdv.core.base.di.ViewComponent
import javax.inject.Inject

val ROOT: Nothing? = null

abstract class BaseActivity<in V : BaseContract.View, P : BaseContract.Presenter<V>, out C : ViewComponent<V>> : AppCompatActivity() {

	@Inject
	protected lateinit var presenter: P

	protected abstract fun bindComponent(): C

	protected abstract fun bindLayout(): Int

	@Suppress("UNCHECKED_CAST")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		bindComponent().inject(this as V)
		setContentView(layoutInflater.inflate(bindLayout(), ROOT))

		presenter.attachView(this as V)
		presenter.create()
	}

	override fun onResume() {
		super.onResume()
		presenter.resume()
	}

	override fun onPause() {
		super.onPause()
		presenter.pause()
	}

	override fun onDestroy() {
		super.onDestroy()
		presenter.destroy()
	}

	protected fun showToast(msg: String) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
	}

}