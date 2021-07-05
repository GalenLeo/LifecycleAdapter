package com.example.demoapplication

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by liuguansheng on 2021/7/4.
 */
abstract class LifecycleAdapter<VH : LifecycleViewHolder> : RecyclerView.Adapter<VH>() {

    override fun onViewAttachedToWindow(holder: VH) {
        super.onViewAttachedToWindow(holder)
        holder.onAttached()
    }

    override fun onViewDetachedFromWindow(holder: VH) {
        super.onViewDetachedFromWindow(holder)
        holder.onDetached()
    }

    override fun onViewRecycled(holder: VH) {
        super.onViewRecycled(holder)
        holder.onRecycled()
    }
}