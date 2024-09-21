package com.example.retrofitbogulyanov.data

data class Results(val results: List<Character>)
data class Character(val id: Int, val name: String, val species: String, val image: String) {
    fun getType(): Int {
        if (species.lowercase() == "human") {
            return 1
        } else if (species.lowercase() == "alien") {
            return 2
        }

        return 0
    }
}