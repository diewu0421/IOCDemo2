package com.example.iocdemo

import android.view.View
import kotlin.reflect.KClass

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   1/1/21 12:29 PM
 */
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class EventBase(
    val listenerSetter: String,
    val listenerType: KClass<*>,
    val callbackMethod: String
)
