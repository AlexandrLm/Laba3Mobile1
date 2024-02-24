package com.example.laba3mobile1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var butsNumber : Array<Button>
    lateinit var butsZnak : Array<Button>
    var text : String = ""

    var number1 : Int = 0
    var number2 : Int = 0
    var znak : Char = ' '

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        butsNumber = arrayOf(findViewById(R.id.button0),findViewById(R.id.button1),findViewById(R.id.button2),findViewById(R.id.button3),
            findViewById(R.id.button4),findViewById(R.id.button5),findViewById(R.id.button6),
            findViewById(R.id.button7),findViewById(R.id.button8),findViewById(R.id.button9))

        butsZnak = arrayOf(findViewById(R.id.buttonDel),findViewById(R.id.buttonMult),findViewById(R.id.buttonMinus),
            findViewById(R.id.buttonDot),findViewById(R.id.buttonPlus),findViewById(R.id.buttonRavno), findViewById(R.id.buttonReset))
    }
    fun numberButtonPress(v : View){
        val mainT : EditText = findViewById(R.id.mainText)
        var button : Button = butsNumber[0]

        for (n in butsNumber){
            if (n.id == v.id)
                button = n
        }
        text += button.text
        mainT.setText(text)
    }
    fun znakButtonPress(v : View){
        val mainT : EditText = findViewById(R.id.mainText)
        var button : Button = butsZnak[0]

        for (n in butsZnak){
            if (n.id == v.id)
                button = n
        }
        mainT.setText(button.text)
    }
}