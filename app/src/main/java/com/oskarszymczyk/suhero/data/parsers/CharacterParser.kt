package com.oskarszymczyk.suhero.data.parsers

import com.oskarszymczyk.core.rest.models.Character
import com.oskarszymczyk.core.rest.models.base.CharacterDataWrapper
import com.oskarszymczyk.suhero.data.Superhero
import com.oskarszymczyk.suhero.data.SuperheroList

fun CharacterDataWrapper.parseToDomain(): SuperheroList {
    return SuperheroList(this.characterDataContainer.totalResults, this.characterDataContainer.characterList.map { it.parseToDomain() })
}

fun Character.parseToDomain(): Superhero {
    return Superhero(this.name, this.image.createPath())
}