package com.example.figma_app.recadapters

import com.example.figma_app.R

data class feel(val image:Int, val name_feel:String)
class MyFeel {
    val feel_list = arrayListOf(feel(R.drawable.calm,"Спокойным"),
    feel(R.drawable.focus,"Расслабленным"),
    feel(R.drawable.relax,"Cосредоточеным"),
    feel(R.drawable.anxious,"Взволнованным"),
        feel(R.drawable.calm,""))
}