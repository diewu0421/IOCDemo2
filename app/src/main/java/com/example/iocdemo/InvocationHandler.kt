package com.example.iocdemo

import android.util.Log
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   1/2/21 3:27 AM
 */
class MyInvocationHandler(
    private val activity: Any,
    private val activityMethod: Method
) : InvocationHandler {
    @Throws(Throwable::class)
    override fun invoke(proxy: Any, method: Method, args: Array<Any>): Any? {
        if (args != null && args.size > 0) {

            return activityMethod.invoke(activity, *args)
        } else {
            return activityMethod.invoke(activity)
        }

    }
}