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
import com.example.demowechat.model.Message

class MessageListAdapter(context: Context, val resource: Int, val objects: MutableList<Message>) :
    ArrayAdapter<Message>(context, resource, objects) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val obj = objects.get(position) as Message
        val view = LayoutInflater.from(context).inflate(resource, parent, false)
        view.findViewById<TextView>(R.id.tv_username).setText(obj.name)
        view.findViewById<TextView>(R.id.tv_description).setText(obj.description)
        view.findViewById<TextView>(R.id.tv_time).setText(obj.time)
        view.findViewById<ImageView>(R.id.iv_icon).setImageResource(obj.thumb)
        return view
    }
}
