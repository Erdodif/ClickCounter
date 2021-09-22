package com.example.clickcounter

import android.graphics.Color
import android.widget.Button
import android.widget.TextView
import kotlin.math.sqrt

class Fuggvenyek {
    companion object {
        fun jelenAllas(szoveg: TextView): Int {
            return Integer.parseInt(szoveg.text.toString())
        }

        fun setAllas(szoveg: TextView, allas: Int): Boolean {
            szoveg.text = allas.toString()
            when {
                allas == 0 -> {
                    szoveg.setTextColor(Color.rgb(0, 56, 255))
                }
                allas < 0 -> {
                    szoveg.setTextColor(Color.rgb(255, 56, 0))
                }
                else -> {
                    szoveg.setTextColor(Color.rgb(0, 255, 56))
                }
            }
            if (primSzam(jelenAllas(szoveg))) {
                szoveg.setTextColor(Color.rgb(255, 255, 255))
            }
            return true
        }

        private fun primSzam(szam: Int): Boolean {
            if (szam < 2) {
                return false
            }
            var prim = 0
            for (i in 1..(sqrt(szam.toDouble()).toInt())) {
                if (szam % i == 0) {
                    prim++
                }
            }
            return prim == 1
        }

        fun halgatosag(szoveg: TextView, plusz: Button, minusz: Button) {
            plusz.setOnClickListener {
                setAllas(szoveg, jelenAllas(szoveg) + 1)
            }
            minusz.setOnClickListener {
                setAllas(szoveg, jelenAllas(szoveg) - 1)
            }
            szoveg.setOnLongClickListener {
                setAllas(szoveg, 0)
            }
        }
    }
}