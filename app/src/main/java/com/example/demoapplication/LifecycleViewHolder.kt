package com.example.demoapplication

import android.view.View
import androidx.annotation.CallSuper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.RecyclerView.ViewHolder

/**
 * Created by liuguansheng on 2021/7/4.
 */
open class LifecycleViewHolder(view: View) : ViewHolder(view), LifecycleOwner {

    protected val mContext = view.context

    private var lifecycleRegistry: LifecycleRegistry

    init {
        lifecycleRegistry = createLifeCycle()
    }

    private fun createLifeCycle(): LifecycleRegistry {
        val lifecycle = LifecycleRegistry(this)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
        return lifecycle
    }

    @CallSuper
    open fun onAttached() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
    }

    @CallSuper
    open fun onDetached() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    }

    @CallSuper
    open fun onRecycled() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        lifecycleRegistry = createLifeCycle()
    }

    override fun getLifecycle(): Lifecycle = lifecycleRegistry

}