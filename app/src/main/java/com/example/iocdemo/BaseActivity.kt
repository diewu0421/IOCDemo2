package com.example.iocdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   12/29/20 11:11 PM
 */
open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        InjectUtils.inject(this)
    }
}