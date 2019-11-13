package com.tioeun.a20191113_02_practice

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
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

        callBtn.setOnClickListener {

            var permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
                    var uri = Uri.parse("tel: ${phoneNum.text.toString().replace("-", "")}")
                    var intent = Intent(Intent.ACTION_CALL, uri)
                    startActivity(intent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "권한을 설정해야 전화 사용이 가능합니다.", Toast.LENGTH_SHORT).show()
                }

            }
            TedPermission.with(mContext)
                .setPermissionListener(permissionListener)
                .setRationaleMessage("전화 권한을 설정해야 바로 연결 가능합니다.")
                .setDeniedMessage("설정 > 권한에서 허용 가능합니다.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }

        okBtn.setOnClickListener {
            finish()
        }
    }

    override fun setValues() {
        pizzaData = intent.getSerializableExtra("pizzaData") as PizzaData

        Glide.with(mContext).load("${pizzaData?.logoUrl}").into(pizzaLogo)

        storeName.text = pizzaData?.name
        phoneNum.text = pizzaData?.phoneNum
    }


}
