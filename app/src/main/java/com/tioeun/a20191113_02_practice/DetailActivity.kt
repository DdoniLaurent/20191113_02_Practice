package com.tioeun.a20191113_02_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.tioeun.a20191113_02_practice.datas.PizzaData
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {

    var pizzaData:PizzaData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        pizzaData = intent.getSerializableExtra("pizzaData") as PizzaData

        Glide.with(mContext).load("${pizzaData?.logoUrl}").into(pizzaLogo)

        storeName.text = pizzaData?.name
        phoneNum.text = pizzaData?.phoneNum
    }


}
