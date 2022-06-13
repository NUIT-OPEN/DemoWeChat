package com.example.demowechat.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.demowechat.CommonVariables
import com.example.demowechat.R
import com.example.demowechat.adapter.MyListAdapter
import com.example.demowechat.model.MyItem

class DiscoverFragment : Fragment(R.layout.fragment_discover) {
    lateinit var common_vars: CommonVariables
    lateinit var list: ArrayList<MyItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        common_vars = activity?.application as CommonVariables
        initList()
    }

    fun initList() {
        list = ArrayList()
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
                androidx.appcompat.R.drawable.abc_ic_menu_share_mtrl_alpha,
                getString(R.string.my_item_weather)
            )
        )
        list.add(
            MyItem(
                androidx.appcompat.R.drawable.abc_ic_menu_overflow_material,
                getString(R.string.my_item_offline)
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
            val lv_my_list = view.findViewById<ListView>(R.id.lv_discover)
            activity?.let {
                lv_my_list?.adapter = MyListAdapter(it, R.layout.layout_discover_item, list)
                lv_my_list.setOnItemClickListener { parent, view, position, id ->
                    val obj = list.get(position)
                    if (obj.title.equals(getString(R.string.my_item_weather))) {
                        Toast.makeText(
                            context, "国内 | 广东 | 广州 2022/06/12 17:00更新\n" +
                                    "24.9℃\n" +
                                    "\n" +
                                    " 997hPa  87%  -  西南风 5级", Toast.LENGTH_SHORT
                        ).show()
                    } else if (obj.title.equals(getString(R.string.my_item_offline))) {
                        val dialog = AlertDialog.Builder(context)
                        dialog.setIcon(androidx.appcompat.R.drawable.abc_ic_menu_overflow_material)
                        dialog.setTitle(getString(R.string.my_item_offline))
                        dialog.setMessage("Oops!")
                        dialog.setNegativeButton(
                            "わかりました"
                        ) { _, which ->
                            System.exit(0)
                        }
                        dialog.show()
                    }
                }
            }
            return view
        }

        return null
    }
}