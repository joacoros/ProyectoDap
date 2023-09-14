package com.example.proyectofinaldap

class superheroesProvider {
    private val superheroesList:MutableList<superheroes> = mutableListOf()
    init{
        superheroesList.add(superheroes("Batman", "el señor de la noche"))
        superheroesList.add(superheroes("Superman", "el hombre de hierro"))
        superheroesList.add(superheroes("Acuaman", "habla con los peces"))
        superheroesList.add(superheroes("Flash","corre a la velocidad de la luz"))
        superheroesList.add(superheroes("Spiderman", "tiene poderes de araña"))
        superheroesList.add(superheroes("IronMan","es millonario"))
        superheroesList.add(superheroes("SuperAle","masteriza el arte de la programación en kotlin"))
    }
    fun Getsuperhero(): MutableList<superheroes>{
        return superheroesList
    }
}

