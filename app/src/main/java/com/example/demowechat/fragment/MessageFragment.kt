package com.example.demowechat.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.demowechat.CommonVariables
import com.example.demowechat.R
import com.example.demowechat.adapter.MessageListAdapter
import com.example.demowechat.model.Message
import java.util.*

class MessageFragment : Fragment(R.layout.fragment_message) {
    lateinit var common_vars: CommonVariables
    lateinit var list: ArrayList<Message>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        common_vars = activity?.application as CommonVariables
        initList()
    }

    fun initList() {
        list = ArrayList()
        val date = Date()

        for (index in 1..100)
            list.add(
                Message(
                    String.format("%s %d", getString(R.string.message), index),
                    String.format(
                        getString(R.string.message_content),
                        String.format("%s%d", getString(R.string.item), index)
                    ),
                    String.format("%d:%d:%d", date.hours, date.minutes, date.seconds),
                    androidx.appcompat.R.drawable.abc_ic_menu_paste_mtrl_am_alpha,
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
            val lv_my_list = view.findViewById<ListView>(R.id.lv_message)
            activity?.let {
                lv_my_list.adapter = MessageListAdapter(it, R.layout.layout_message, list)
                lv_my_list.setOnItemClickListener { parent, view, position, id ->
                    val obj = list.get(position)
                    Toast.makeText(activity, obj.description, Toast.LENGTH_SHORT).show()
                }
            }

            return view
        }

        return null
    }
}