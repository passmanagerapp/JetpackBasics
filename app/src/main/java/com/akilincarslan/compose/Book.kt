package com.akilincarslan.compose

data class Book(
    val title: String,
    val author: String,
    val publisher: String,
    val publishDate: Int,
    val authorImageDrawable: Int
) {

    companion object {
        val dummyBookList = listOf<Book>(
            Book(
                title = "Osmanlıda Bir Köle",
                author = "Michael Heberer",
                publisher = "Kitap Yayınevi",
                publishDate = 2003,
                authorImageDrawable = R.drawable.michael_heberer
            ),
            Book(
                title = "Garp Cephesinde Yeni Bir Şey Yok",
                author = "Erich Maria Remarque",
                publisher = "Everest Yayınları",
                publishDate = 2020,
                authorImageDrawable = R.drawable.erich_remarque
            ),
            Book(
                title = "Taşları Yemek Yasak",
                author = "İsmet Özel",
                publisher = "Tiyo",
                publishDate = 2018,
                authorImageDrawable = R.drawable.ismet_ozel
            ),
            Book(
                title = "Of Not Being a Jew",
                author = "İsmet Özel",
                publisher = "Tiyo",
                publishDate = 2021,
                authorImageDrawable = R.drawable.ismet_ozel
            ),
            Book(
                title = "Kotlin in Action",
                author = "Dmitry Jemerov",
                publisher = "Manning",
                publishDate = 2017,
                authorImageDrawable = R.drawable.dmitry_jemerov
            ),
            Book(
                title = "Clean Code",
                author = "Robert C. Martin",
                publisher = "P",
                1990,
                authorImageDrawable = R.drawable.robert_martin
            ),
            Book(
                title = "Waldo Sen Neden Burada Değilsin",
                author = "İsmet Özel",
                publisher = "Tiyo",
                publishDate = 1988,
                authorImageDrawable = R.drawable.ismet_ozel
            )

        )
    }

}
