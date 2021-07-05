package com.example.demoapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.Random

/**
 * 测试Adapter
 * Created by liuguansheng on 2021/7/4.
 */
class TestLifecycleAdapter : LifecycleAdapter<ViewHolder>() {

    private var list = emptyList<Int>()

    fun setData(list: List<Int>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lifecycle_test, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount() = list.size
}

class ViewHolder(view: View) : LifecycleViewHolder(view) {

    private val textTv = view.findViewById<TextView>(R.id.textTv)

    fun bindData(data: Int) {
        textTv.text = ""
        getLiveData(data).observe(this) {
            textTv.text = it.toString()
        }
    }
}

val random = Random()

/**
 * 测试
 */
fun getLiveData(value: Int): LiveData<Int> {
    val result = MutableLiveData<Int>()
    Thread {
        // LiveData随机时间设置数据，模拟列表异步数据情况
        // 验证列表数据是否会混乱
        Thread.sleep(random.nextInt(5) * 1000L)
        result.postValue(value)
    }.start()
    return result
}