package com.example.laba3mobile1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    lateinit var butsNumber : Array<Button>
    lateinit var butsZnak : Array<Button>
    lateinit var ravnoBtn : Button
    lateinit var resetBtn : Button
    lateinit var resultText : TextView
    lateinit var mainT : EditText
    var text : String = ""
    var helpText : String = ""
    lateinit var znak : String

    var number1 : Double = 0.0
    var number2 : Double = 0.0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        butsNumber = arrayOf(findViewById(R.id.button0),findViewById(R.id.button1),findViewById(R.id.button2),findViewById(R.id.button3),
            findViewById(R.id.button4),findViewById(R.id.button5),findViewById(R.id.button6),
            findViewById(R.id.button7),findViewById(R.id.button8),findViewById(R.id.button9),
            findViewById(R.id.buttonDot))

        butsZnak = arrayOf(findViewById(R.id.buttonDel),findViewById(R.id.buttonMult),findViewById(R.id.buttonMinus),findViewById(R.id.buttonPlus))
        ravnoBtn = findViewById(R.id.buttonRavno)
        resetBtn = findViewById(R.id.buttonReset)

        resultText = findViewById(R.id.resultText)
        mainT = findViewById(R.id.mainText)

    }
    @SuppressLint("ResourceAsColor")
    fun numberButtonPress(v : View){
        if(!butsZnak[0].isClickable){
            helpText +=" ${mainT.text} "
            resultText.text = helpText
            ravnoBtn.isClickable = true
        }
        for (n in butsNumber){
            if (n.id == v.id) {
                text += n.text
            }
        }
        mainT.setText(text)
    }
    fun znakButtonPress(v : View){
        number1 = text.toDouble()
        helpText += text
        resultText.text = helpText
        text = ""
        for (n in butsZnak){
            if (n.id == v.id) {
                mainT.setText(n.text)
                znak = n.text.toString()
            }
            n.isClickable = false
        }
    }
    @SuppressLint("SetTextI18n")
    fun ravnoButtonPress(v: View){
        for (n in butsNumber){
            n.isClickable = false
        }
        ravnoBtn.isClickable = false

        number2 = text.toDouble()
        helpText += text
        resultText.text = helpText
        text = ""
        helpText += " = "
        if (znak == "+") {
            helpText += number1 + number2
            resultText.text = helpText
            mainT.setText((number1 + number2).toString())
        }
        else if (znak == "-"){
            helpText += number1 - number2
            resultText.text = helpText
            mainT.setText((number1 - number2).toString())
        }
        else if (znak == "*"){
            helpText += number1 * number2
            resultText.text = helpText
            mainT.setText((number1 * number2).toString())
        }
        else if (znak == "/"){
            helpText += number1 / number2
            resultText.text = helpText
            mainT.setText((number1 / number2).toString())
        }
    }
    fun resetButtonPress(v : View){
        for (n in butsNumber){
            n.isClickable = true
        }
        for (n in butsZnak){
            n.isClickable = true
        }
        text = ""
        helpText = ""
        number1 = 0.0
        number2 = 0.0
        mainT.text = null
        resultText.text = null
    }
}