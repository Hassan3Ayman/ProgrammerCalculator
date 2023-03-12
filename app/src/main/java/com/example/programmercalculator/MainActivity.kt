package com.example.programmercalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    lateinit var binEditText: EditText
    lateinit var octEditText: EditText
    lateinit var decEditText: EditText
    lateinit var hexEditText: EditText

    var bin: String = ""
    var dec: Long = 0
    var oct: String = ""
    var hex: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        addCallback()

    }

    private fun initViews(){
        binEditText = findViewById(R.id.bin_input)
        octEditText = findViewById(R.id.oct_input)
        decEditText = findViewById(R.id.dec_input)
        hexEditText = findViewById(R.id.hex_input)
    }

    private fun addCallback(){
        binEditText.addTextChangedListener { text ->
            val newDec = text.toString().toLongOrNull(2)
            if (newDec != null && newDec != dec) {
                dec = newDec!!
                oct = dec.toString(8)
                hex = dec.toString(16)

                decEditText.setText(dec.toString())
                octEditText.setText(oct)
                hexEditText.setText(hex)
            }
            if(newDec == null  && text!!.isNotEmpty()){
                val e = "please Enter only 0 or 1"
                Toast.makeText(this, e, Toast.LENGTH_SHORT).show()
            }
        }

        decEditText.addTextChangedListener { text ->
            val newDec = text.toString().toLongOrNull()
            if (newDec != null && newDec != dec) {
                dec = newDec!!
                oct = dec.toString(8)
                hex = dec.toString(16)
                bin = dec.toString(2)

                binEditText.setText(bin)
                octEditText.setText(oct)
                hexEditText.setText(hex)
            }
            if(newDec == null && text!!.isNotEmpty()){
                val e = "please Enter only digit between 0 and 9"
                Toast.makeText(this, e, Toast.LENGTH_SHORT).show()
            }
        }

        octEditText.addTextChangedListener { text ->
            val newDec = text.toString().toLongOrNull(8)
            if (newDec != null && newDec != dec) {
                dec = newDec!!
                bin = dec.toString(2)
                hex = dec.toString(16)

                decEditText.setText(dec.toString())
                binEditText.setText(bin)
                hexEditText.setText(hex)
            }
            if(newDec == null && text!!.isNotEmpty()){
                val e = "please Enter only digit between 0 and 7"
                Toast.makeText(this, e, Toast.LENGTH_SHORT).show()
            }
        }

        hexEditText.addTextChangedListener { text ->
            val newDec = text.toString().toLongOrNull(16)
            if (newDec != null && newDec != dec) {
                dec = newDec!!
                oct = dec.toString(8)
                bin = dec.toString(2)

                decEditText.setText(dec.toString())
                octEditText.setText(oct)
                binEditText.setText(bin)
            }
            if(newDec == null && text!!.isNotEmpty()){
                val e = "please Enter only digit between 0 and 9 and char a to f"
                Toast.makeText(this, e, Toast.LENGTH_SHORT).show()
            }
        }
    }
}