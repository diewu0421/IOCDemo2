package com.example.iocdemo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * 浙江集商优选电子商务有限公司
 *
 * @author zenglw
 * @date 1/1/21 12:58 AM
 */
internal class TestActivity : AppCompatActivity() {
    @BindView(R.id.tv)
    var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}