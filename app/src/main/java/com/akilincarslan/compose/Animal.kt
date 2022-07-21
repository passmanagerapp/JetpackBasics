package com.akilincarslan.compose

data class Animal(
    val imageDrawable: Int,
    val name: String,
    val type: String
) {
    companion object {
        val dummyAnimalList = listOf<Animal>(
            Animal(
                R.drawable.animal1,
                "Zürafa",
                "Vahşi"
            ),
            Animal(
                R.drawable.animal2,
                "Fil",
                "Vahşi"
            ),
            Animal(
                R.drawable.animal3,
                "Aslan",
                "Vahşi"
            ),
            Animal(
                R.drawable.animal4,
                "Kaplan",
                "Vahşi"
            ),
            Animal(
                R.drawable.animal5,
                "Köpek",
                "Evcil"
            ),
            Animal(
                R.drawable.animal6,
                "Kedi",
                "Evcil"
            ),
            Animal(
                R.drawable.animal7,
                "Balık",
                "Evcil"
            ),
            Animal(
                R.drawable.animal8,
                "Tavuk",
                "Evcil"
            )
        )
    }
}
