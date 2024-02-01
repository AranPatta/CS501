package com.example.calculatorv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var add : Boolean = false
        var sub : Boolean = false
        var mul : Boolean = false
        var div : Boolean = false

        findViewById<RadioGroup>(R.id.radio_group).setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radio_add -> {
                    add = true
                    sub = false
                    mul = false
                    div = false
                }
                R.id.radio_sub -> {
                    add = false
                    sub = true
                    mul = false
                    div = false
                }
                R.id.radio_mul -> {
                    add = false
                    sub = false
                    mul = true
                    div = false
                }
                R.id.radio_div -> {
                    add = false
                    sub = false
                    mul = false
                    div = true
                }
            }
        }

        var num1 : Float = 0f
        var num2 : Float = 0f
        var ans : String = "0"

        findViewById<Button>(R.id.calc).setOnClickListener {

            num1 = findViewById<EditText>(R.id.NumberDecimal).getText().toString().toFloatOrNull() ?: 0f
            num2 = findViewById<EditText>(R.id.NumberDecimal2).getText().toString().toFloatOrNull() ?: 0f

            when {
                add -> {
                    ans = (num1 + num2).toString()
                }
                sub -> {
                    ans = (num1 - num2).toString()
                }
                mul -> {
                    ans = (num1 * num2).toString()
                }
                div -> {
                    if (num2 == 0f){
                        ans = "Divide by zero not allowed"
                    } else {
                        ans = (num1 / num2).toString()
                    }
                }
            }

            findViewById<TextView>(R.id.ans).text = ans
        }
    }
}