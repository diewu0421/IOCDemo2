package com.example.iocdemo

import android.view.View

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   1/1/21 4:16 PM
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@EventBase(
    listenerSetter = "setOnClickListener",
    listenerType = View.OnClickListener::class,
    callbackMethod = "onClick"
)
annotation class OnClick(val value: IntArray) {

}

