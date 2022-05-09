package com.example.demowechat.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.demowechat.R
import com.example.demowechat.model.MyItem

class MyListAdapter(context: Context, val resource: Int, val objects: MutableList<MyItem>) :
    ArrayAdapter<MyItem>(context, resource, objects) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val obj = objects.get(position) as MyItem
        val view = LayoutInflater.from(context).inflate(resource, parent, false)
        view.findViewById<TextView>(R.id.tv_title).setText(obj.title)
        view.findViewById<ImageView>(R.id.iv_icon).setImageResource(obj.icon)
        return view
    }
}
