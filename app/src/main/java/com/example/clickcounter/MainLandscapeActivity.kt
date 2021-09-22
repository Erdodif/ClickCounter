package com.example.clickcounter

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainLandscapeActivity : AppCompatActivity() {

    private lateinit var szoveg: TextView
    private lateinit var plusz: Button
    private lateinit var minusz: Button

    private fun iranyhozIgazodik() {
        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Allas", Fuggvenyek.jelenAllas(szoveg))
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_landscape)
        init()
        val passzoltAllas = intent.getIntExtra("Allas", 0)
        if (passzoltAllas != 0) {
            Fuggvenyek.setAllas(szoveg, passzoltAllas)
            intent.removeExtra("Allas")
        } else if (savedInstanceState != null) {
            val allas = savedInstanceState.getInt("Allas")
            Fuggvenyek.setAllas(szoveg, allas)
        }
        iranyhozIgazodik()
        Fuggvenyek.halgatosag(szoveg, plusz, minusz)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val allas = Fuggvenyek.jelenAllas(szoveg)
        outState.putInt("Allas", allas)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    private fun init() {
        szoveg = findViewById(R.id.lSzam)
        plusz = findViewById(R.id.lPlusz)
        minusz = findViewById(R.id.lMinusz)
    }


}