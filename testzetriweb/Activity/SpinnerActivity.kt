package com.example.testzetriweb.Activity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmroomretro.Api.QuoteService
import com.example.testzetriweb.R
import android.content.Intent
import android.widget.Toast






class SpinnerActivity  : AppCompatActivity() {
    var api: QuoteService? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_activtiy)
        val spinner =findViewById<Spinner>(R.id.spinner_first)
        var spinnerstring: String

        val list: MutableList<String> = ArrayList()
        list.add("android1")
        list.add("java1")
        list.add("million1")
        list.add("billion1")
        list.add("android1")

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var  item: Any = parent!!.getItemAtPosition(position);

               spinnerstring = spinner.selectedItem as String
                if (item == 0) {
                    val intent = Intent(this@SpinnerActivity, LoginActivity::class.java)
                    startActivity(intent)
                } else if (item == 1) {
                    val intent = Intent(this@SpinnerActivity, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                  Toast.makeText( this@SpinnerActivity,"spinner",Toast.LENGTH_LONG).show()

                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }










    }
}