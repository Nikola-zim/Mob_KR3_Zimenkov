package com.example.kr3_zimenkov

import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ShowActivity2 : AppCompatActivity() {
    private var signState = "empty"
    private var visitors_list_tmp = ArrayList<String>()
    private var listview: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show2)
        listview = findViewById(R.id.visitors_list)

        var visitors = ArrayList<Visitor>()
        intent?.let{
            val visitors = intent.getParcelableArrayListExtra<Visitor>(EXTRA_MESSAGE)
            visitors?.forEach(){
                var visitor_str = "Имя: " + it.name + " | | " + "Фамилия: "+ it.last_name + " | | " + "Вес: " + it.weight
                visitors_list_tmp.add(visitor_str.toString())
            }
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,visitors_list_tmp)
        listview!!.adapter = adapter
    }

    fun return_mainActivity(view: View?){
        finish()
    }
}

