package com.tioeun.a20191113_02_practice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.bumptech.glide.Glide
import com.tioeun.a20191113_02_practice.R
import com.tioeun.a20191113_02_practice.datas.PizzaData

class PizzaAdapter(context: Context, res:Int, list: ArrayList<PizzaData>) : ArrayAdapter<PizzaData>(context, res, list) {

    var mContext = context

    var mList = list

    var inf = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if(tempRow == null){
            tempRow = inf.inflate(R.layout.pizza_list_item, null)
        }
        var row = tempRow!!

        var pizzaLogo = row.findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.pizzaLogo)
        var storeName = row.findViewById<TextView>(R.id.storeName)

        Glide.with(mContext).load("${mList[position].logoUrl}").into(pizzaLogo)
        storeName.text = mList[position].name

        return row
    }


}