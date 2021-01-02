package com.example.iocdemo

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   12/29/20 11:13 PM
 */
@Target(AnnotationTarget.CLASS)
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ContentView(val value: Int)

