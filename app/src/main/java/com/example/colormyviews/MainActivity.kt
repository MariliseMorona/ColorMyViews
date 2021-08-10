package com.example.colormyviews

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var boxOne : TextView
    lateinit var boxTwo : TextView
    lateinit var boxThree : TextView
    lateinit var boxFour : TextView
    lateinit var boxFive : TextView
    var boxOneColor = R.color.grey
    var boxTwoColor = R.color.grey
    var boxThreeColor = R.color.grey
    var boxFourColor = R.color.grey
    var boxFiveColor = R.color.grey
    val sharedPreferences : SharedPreferences
        get() {
            return this.getSharedPreferences("colors", Context.MODE_PRIVATE)

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boxOne = findViewById(R.id.box_one_text)
        boxTwo = findViewById(R.id.box_two_text)
        boxThree = findViewById(R.id.box_three_text)
        boxFour = findViewById(R.id.box_four_text)
        boxFive = findViewById(R.id.box_five_text)

        boxOneColor = sharedPreferences.getInt("boxOne", R.color.grey)
        boxTwoColor = sharedPreferences.getInt("boxTwo", R.color.grey)
        boxThreeColor = sharedPreferences.getInt("boxThree", R.color.grey)
        boxFourColor = sharedPreferences.getInt("boxFour", R.color.grey)
        boxFiveColor = sharedPreferences.getInt("boxFive", R.color.grey)

        boxOne.setBackgroundResource(boxOneColor)
        boxTwo.setBackgroundResource(boxTwoColor)
        boxThree.setBackgroundResource(boxThreeColor)
        boxFour.setBackgroundResource(boxFourColor)
        boxFive.setBackgroundResource(boxFiveColor)

        var changeColor = R.color.grey
        var redBtn = findViewById<Button>(R.id.btn_red)
        var greenBtn = findViewById<Button>(R.id.btn_green)
        var yellowBtn = findViewById<Button>(R.id.btn_yellow)

        redBtn.setOnClickListener {
            changeColor = R.color.red
        }
        greenBtn.setOnClickListener {
            changeColor = R.color.green
        }
        yellowBtn.setOnClickListener {
            changeColor = R.color.yellow
        }

        boxOne.setOnClickListener {
            boxOne.setBackgroundResource(changeColor)
            boxOneColor = changeColor
        }
        boxTwo.setOnClickListener {
            boxTwo.setBackgroundResource(changeColor)
            boxTwoColor = changeColor
        }
        boxThree.setOnClickListener {
            boxThree.setBackgroundResource(changeColor)
            boxThreeColor = changeColor
        }
        boxFour.setOnClickListener {
            boxFour.setBackgroundResource(changeColor)
            boxFourColor = changeColor
        }
        boxFive.setOnClickListener {
            boxFive.setBackgroundResource(changeColor)
            boxFiveColor = changeColor
        }

    }

    override fun onStop() {
        super.onStop()

        val editor = sharedPreferences.edit()

        editor.putInt("boxOne", boxOneColor)
        editor.putInt("boxTwo", boxTwoColor)
        editor.putInt("boxThree", boxThreeColor)
        editor.putInt("boxFour", boxFourColor)
        editor.putInt("boxFive", boxFiveColor)

        editor.apply()
    }
}