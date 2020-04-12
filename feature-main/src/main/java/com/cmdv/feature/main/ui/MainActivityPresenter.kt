package com.cmdv.feature.main.ui

import com.cmdv.core.base.mvp.BasePresenter
import javax.inject.Inject

class MainActivityPresenter @Inject constructor(

) : BasePresenter<MainActivityContract.View>(),
	MainActivityContract.Presenter<MainActivityContract.View> {

}