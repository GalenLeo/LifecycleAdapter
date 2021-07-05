package com.example.demoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = TestLifecycleAdapter()
        recyclerView.adapter = adapter

        // 测试数据（数字列表）
        val list = mutableListOf<Int>()
        for (i in 0..1000) {
            list.add(i)
        }
        adapter.setData(list)
    }
}