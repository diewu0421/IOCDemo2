package com.example.iocdemo

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   1/1/21 12:59 AM
 */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class BindView(val value: Int)
