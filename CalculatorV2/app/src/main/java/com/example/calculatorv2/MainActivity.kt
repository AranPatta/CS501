package com.example.calculatorv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var add : Boolean = false
        var sub : Boolean = false
        var mul : Boolean = false
        var div : Boolean = false

        var display : String = "0"
        var ans : Float

        val guide = Toast.makeText(this, "sqrt(2 + 2) -> 2 + 2 sqrt.\n Add spaces between operations", Toast.LENGTH_LONG)
        guide.show()

        findViewById<Button>(R.id.button0).setOnClickListener{
            display = display.plus("0")
            findViewById<EditText>(R.id.ans).setText(display)
        }
        findViewById<Button>(R.id.button1).setOnClickListener{
            display = display.plus("1")
            findViewById<EditText>(R.id.ans).setText(display)
        }
        findViewById<Button>(R.id.button2).setOnClickListener{
            display = display.plus("2")
            findViewById<EditText>(R.id.ans).setText(display)
        }
        findViewById<Button>(R.id.button3).setOnClickListener{
            display = display.plus("3")
            findViewById<EditText>(R.id.ans).setText(display)
        }
        findViewById<Button>(R.id.button4).setOnClickListener{
            display = display.plus("4")
            findViewById<EditText>(R.id.ans).setText(display)
        }
        findViewById<Button>(R.id.button5).setOnClickListener{
            display = display.plus("5")
            findViewById<EditText>(R.id.ans).setText(display)
        }
        findViewById<Button>(R.id.button6).setOnClickListener{
            display = display.plus("6")
            findViewById<EditText>(R.id.ans).setText(display)
        }
        findViewById<Button>(R.id.button7).setOnClickListener{
            display = display.plus("7")
            findViewById<EditText>(R.id.ans).setText(display)
        }
        findViewById<Button>(R.id.button8).setOnClickListener{
            display = display.plus("8")
            findViewById<EditText>(R.id.ans).setText(display)
        }
        findViewById<Button>(R.id.button9).setOnClickListener{
            display = display.plus("9")
            findViewById<EditText>(R.id.ans).setText(display)
        }
        findViewById<Button>(R.id.buttonAdd).setOnClickListener{
            display = display.plus(" + ")
            findViewById<EditText>(R.id.ans).setText(display)
        }
        findViewById<Button>(R.id.buttonSub).setOnClickListener{
            display = display.plus(" - ")
            findViewById<EditText>(R.id.ans).setText(display)
        }
        findViewById<Button>(R.id.buttonSqrt).setOnClickListener{
            display = display.plus(" sqrt ")
            findViewById<EditText>(R.id.ans).setText(display)
        }
        findViewById<Button>(R.id.buttonMul).setOnClickListener{
            display = display.plus(" * ")
            findViewById<EditText>(R.id.ans).setText(display)
        }
        findViewById<Button>(R.id.buttonDiv).setOnClickListener{
            display = display.plus(" \\ ")
            findViewById<EditText>(R.id.ans).setText(display)
        }
        findViewById<Button>(R.id.buttonDot).setOnClickListener{
            display = display.plus(".")
            findViewById<EditText>(R.id.ans).setText(display)
        }
        findViewById<Button>(R.id.buttonEqual).setOnClickListener{
            display = findViewById<EditText>(R.id.ans).getText().toString()
            val tokens = display.split(" ")
            var ans = 0f
            var op : String? = null

            print(tokens)

            for (token in tokens) {
                if (op != null){
                    val num = token.toFloatOrNull() ?: 0f
                    when (op){
                        "+" -> {
                            ans = ans + num
                            op = null
                        }
                        "-" -> {
                            ans = ans - num
                            op = null
                        }
                        "*" -> {
                            ans = ans * num
                            op = null
                        }
                        "\\" -> {
                            if (num == 0f){
                                display = "0"
                                ans = 0f
                                op = null
                                val zero = Toast.makeText(this, "Divide by zero not allowed", Toast.LENGTH_SHORT)
                                zero.show()
                                findViewById<EditText>(R.id.ans).setText(display)
                            }else{
                                ans = ans / num
                                op = null
                            }
                        }
                        "sqrt" -> {
                            if (ans < 0f){
                                display = "0"
                                ans = 0f
                                op = null
                                val imagine = Toast.makeText(this, "Imaginary number not allowed", Toast.LENGTH_SHORT)
                                imagine.show()
                                findViewById<EditText>(R.id.ans).setText(display)
                            }else{
                                ans = sqrt(ans)
                                op = null
                            }
                        }
                    }
                }
                else if (token.toFloatOrNull() != null){
                    ans = token.toFloat()
                }
                else if (token == "+" || token == "*" || token == "\\" || token == "sqrt" || token == "-"){
                    op = token
                }
                else{
                    display = "0"
                    ans = 0f
                    val format = Toast.makeText(this, "Incorrect format", Toast.LENGTH_SHORT)
                    format.show()
                    guide.show()
                    findViewById<EditText>(R.id.ans).setText(display)
                }
            }
            display = ans.toString()
            findViewById<EditText>(R.id.ans).setText(display)
        }
    }
}