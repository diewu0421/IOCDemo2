package com.example.iocdemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView


@SuppressLint("NonConstantResourceId")
@ContentView(value = R.layout.activity_main)
class MainActivity : BaseActivity() {

    @BindView(R.id.tv)
    var tv: TextView? = null

    @BindView(R.id.button)
    var button: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("MainActivity","onCreate $tv $button")
    }

    @OnClick(value = [R.id.button])
    fun onClick(view: View) {
        Thread.sleep(1000)
        Log.e("MainActivity","oncLick $view")
        val id = view.id.toBigInteger()
        Log.e("MainActivity","onClick $id")
    }

    @Test
    fun test() {

    }

}