package com.example.clickcounter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var szoveg : TextView
    lateinit var plusz : Button
    lateinit var minusz : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        plusz.setOnClickListener(){
            setAllas(jelenAllas() + 1)
        }
        minusz.setOnClickListener(){
            setAllas(jelenAllas() - 1)
        }
        szoveg.setOnLongClickListener(){
            setAllas(0)
        }
    }

    fun init(){
        szoveg = findViewById(R.id.Szam)
        plusz = findViewById(R.id.Plusz)
        minusz = findViewById(R.id.Minusz)
    }

    fun jelenAllas():Int{
        return Integer.parseInt(szoveg.text.toString())
    }
    fun setAllas(allas:Int): Boolean {
        szoveg.text = allas.toString();
        if (allas == 0){
            szoveg.setTextColor(Color.rgb(0,56,255))
        }
        else if(allas > 0){
            szoveg.setTextColor(Color.rgb(255,56,0))
        }
        else{
            szoveg.setTextColor(Color.rgb(0,255,56))
        }
        return true
    }
}
