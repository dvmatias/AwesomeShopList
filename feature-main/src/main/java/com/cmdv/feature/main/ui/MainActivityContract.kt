package com.cmdv.feature.main.ui

import com.cmdv.core.base.mvp.BaseContract

interface MainActivityContract {

	interface View : BaseContract.View {

	}

	interface Presenter<V : View> : BaseContract.Presenter<V> {

	}

}