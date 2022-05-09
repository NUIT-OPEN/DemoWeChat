package com.example.demowechat.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.demowechat.CommonVariables
import com.example.demowechat.R
import com.example.demowechat.adapter.MyListAdapter
import com.example.demowechat.model.MyItem
import com.example.demowechat.model.User

class MeFragment : Fragment(R.layout.fragment_me) {
    lateinit var common_vars: CommonVariables
    lateinit var user: User
    lateinit var list: ArrayList<MyItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        common_vars = activity?.application as CommonVariables
        user = common_vars.user!!
        initList()
    }

    fun initList() {
        list = ArrayList()
        list.add(
            MyItem(
                androidx.appcompat.R.drawable.abc_ic_menu_overflow_material,
                getString(R.string.my_item_service)
            )
        )
        list.add(
            MyItem(
                androidx.appcompat.R.drawable.abc_ic_menu_copy_mtrl_am_alpha,
                getString(R.string.my_item_favourites)
            )
        )
        list.add(
            MyItem(
                androidx.appcompat.R.drawable.abc_ic_menu_cut_mtrl_alpha,
                getString(R.string.my_item_sms)
            )
        )
        list.add(
            MyItem(
                androidx.appcompat.R.drawable.abc_ic_menu_paste_mtrl_am_alpha,
                getString(R.string.my_item_video)
            )
        )
        list.add(
            MyItem(
                androidx.appcompat.R.drawable.abc_ic_menu_selectall_mtrl_alpha,
                getString(R.string.my_item_card)
            )
        )
        list.add(
            MyItem(
                androidx.appcompat.R.drawable.abc_ic_menu_share_mtrl_alpha,
                getString(R.string.my_item_sticker)
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
            view.findViewById<TextView>(R.id.tv_username)?.setText(user.username)
            view.findViewById<TextView>(R.id.tv_birthday)?.setText(user.birthday)

            val lv_my_list = view.findViewById<ListView>(R.id.lv_my_list)
            activity?.let { lv_my_list?.adapter = MyListAdapter(it, R.layout.layout_my_item, list) }

            return view
        }

        return null
    }
}