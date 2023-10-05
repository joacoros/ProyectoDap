package com.example.recyclerview

class SuperHeroProvider {
    companion object {
        val superHerolist = listOf<SuperHero>(
            SuperHero(
                "SpiderMan",
                "Peter Parker",
                "Marvel",
                "https://static.wikia.nocookie.net/ficcion-sin-limites/images/6/6b/Spidey.png/revision/latest/scale-to-width-down/375?cb=20210226124716&path-prefix=es"
            ),
            SuperHero(
                "Capitan America",
                "Steve Rogers",
                "Marvel",
                "https://static.wikia.nocookie.net/disney/images/f/fa/Captain-America-AOU-Render.png/revision/latest?cb=20180420015558&path-prefix=es"
        ),
            SuperHero(
                "Iron Man",
                "Tony Stark",
                "Marvel",
                "https://static.wikia.nocookie.net/marvelcinematicuniverse/images/b/b9/Iron_Man_Mark_L.png/revision/latest?cb=20180716231556&path-prefix=es"
            ),
            SuperHero(
                "Black Widow",
                "Natasha Romanoff",
                "Marvel",
                "https://lumiere-a.akamaihd.net/v1/images/blueb_007d_g_spa-ar_70x100_43a5cf52.jpeg"
            )
        )
    }
}