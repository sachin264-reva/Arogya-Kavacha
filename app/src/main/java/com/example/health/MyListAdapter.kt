package com.example.health

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyListAdapter(var mCtx:Context,var resource:Int,var items:List<Model>)
    :ArrayAdapter<Model>(mCtx,resource,items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val Layoutnflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = Layoutnflater.inflate(resource, null)
       // val imageView: ImageView = view.findViewById(R.id.iconIv)
        val textView : TextView = view.findViewById(R.id.titleTv)
        val textView2 : TextView = view.findViewById(R.id.CovidHos)
        val textView3 : TextView = view.findViewById(R.id.HosAdd)
        val textView4 : TextView = view.findViewById(R.id.Beds)

        var mItems: Model = items[position]
      //  imageView.setImageDrawable(mCtx.resources.getDrawable(mItems.photo))
        textView.text = mItems.title
        textView2.text = mItems.name
        textView3.text = mItems.address
        textView4.text = mItems.beds

        return view
    }
}