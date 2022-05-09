package com.example.demowechat.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.demowechat.CommonVariables
import com.example.demowechat.R
import com.example.demowechat.adapter.MyListAdapter
import com.example.demowechat.model.MyItem

class ContactFragment : Fragment(R.layout.fragment_contact) {
    lateinit var common_vars: CommonVariables
    lateinit var list: ArrayList<MyItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        common_vars = activity?.application as CommonVariables
        initList()
    }

    fun initList() {
        list = ArrayList()
        for (index in 1..100)
            list.add(
                MyItem(
                    androidx.appcompat.R.drawable.abc_ic_menu_copy_mtrl_am_alpha,
                    String.format("%s %d", getString(R.string.contact), index)
                )
            )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        view?.let {
            val lv_my_list = view.findViewById<ListView>(R.id.lv_contact)
            activity?.let { lv_my_list?.adapter = MyListAdapter(it, R.layout.layout_my_item, list) }
            return view
        }

        return null
    }
}