package com.example.figma_app.recadapters

import com.example.figma_app.R

data class state(val title:String, val text_state:String, val image_state: Int)
class MyState  {
    val state_list = arrayListOf(state("Заголовок статьи", "Краткое описание\nблока с двумя строчками", R.drawable.image_note1),
        state("Заголовок статьи", "Краткое описание\nблока с двумя строчками", R.drawable.image_note2),
        state("TITLE", "Text", R.drawable.image_note2))
}