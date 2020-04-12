package com.cmdv.feature.main.ui.shoplistlistfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.cmdv.feature.R

/**
 * A simple [Fragment] subclass.
 */
class ShopListListFragment : Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_shop_list_list, container, false)
	}

}
