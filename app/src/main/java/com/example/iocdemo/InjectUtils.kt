package com.example.iocdemo

import android.content.Context
import android.util.Log
import android.view.View
import kotlin.coroutines.Continuation
import java.lang.annotation.Annotation
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   12/29/20 11:11 PM
 */

fun Any?.log(tag: String = "log") {

    Log.e("$tag", "$this")
}

class InjectUtils {

    companion object {
        fun inject(context: Context) {
            injectContentView(context)
            injectView(context)
            injectMethod(context)
            context.javaClass
                .declaredMethods
                .forEach { method ->
                    for (annotation in method.annotations) {
                        val annotationClass = annotation.annotationClass.java
                        val eventBase =
                            annotationClass.getAnnotation(EventBase::class.java) ?: continue

                        val listenerType = eventBase.listenerType
                        val listenerMethod = eventBase.callbackMethod
                        val listenerSetter = eventBase.listenerSetter
                        annotationClass.getDeclaredMethod("value").invoke(annotation)
                            ?.let { it as IntArray }
                            ?.forEach {
                                // 拿到控件的id findViewById
                                var view: View? = null

                                val handle = MyInvocationHandler(context, method)

                                val proxy = Proxy.newProxyInstance(
                                    context.classLoader,
                                    arrayOf(View.OnClickListener::class.java), handle
                                )

                                context.javaClass.getMethod("findViewById", Int::class.java)
                                    .invoke(context, it)
                                    ?.also { view = it as View }
                                    ?.javaClass
                                    ?.getMethod(
                                        "setOnClickListener",
                                        View.OnClickListener::class.java
                                    )
                                    ?.invoke(view, proxy)

                            }


                    }
                    method.annotations
                        .mapNotNull { it.annotationClass.java.getAnnotation(EventBase::class.java) }
                        .takeIf { it.isNotEmpty() }
                        ?.first()
                        ?.let { eventBase ->
                            val listenerType = eventBase.listenerType
                            val listenerMethod = eventBase.callbackMethod
                            val listenerSetter = eventBase.callbackMethod

                        }

                    method
                }

                .let { cls ->
//                    cls.declaredMethods

//                        .forEach {
//                            for (annotation in it.annotations) {
//                                annotation.annotationClass.java
//                                    .getAnnotation(EventBase::class.java)
//                                    ?.let { eventBase ->
//                                        val listenerType = eventBase.listenerType
//                                        val listenerMethod = eventBase.callbackMethod
//                                        val listenerSetter = eventBase.callbackMethod
//
//
//                                    }
//
//                            }
//                        }
//                        .log("annotation")
                }
        }

        private fun injectMethod(context: Context) {

        }

        private fun injectView(context: Context) {

            context.javaClass.let { cls ->

                cls.declaredFields.forEach { field ->
                    field.isAccessible = true
                    field.getAnnotation(BindView::class.java)
                        ?.value
                        .let { value ->
                            cls.superclass
                                ?.superclass
                                ?.getDeclaredMethod(
                                    "findViewById",
                                    Int::class.java
                                )
                                ?.invoke(context, value)
                                ?.also { field.set(context, it) }
                        }

                }
            }
        }

        private fun injectContentView(context: Context) {
            context.javaClass.let { cls ->
                cls.getAnnotation(ContentView::class.java)?.let { contentView ->
                    cls.superclass
                        ?.superclass
                        ?.getDeclaredMethod("setContentView", Int::class.java)
                        ?.invoke(context, contentView.value)
                }
            }
        }
    }
}