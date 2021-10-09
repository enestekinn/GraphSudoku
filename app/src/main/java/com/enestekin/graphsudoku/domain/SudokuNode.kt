package com.enestekin.graphsudoku.domain

import java.io.Serializable

data class SudokuNode(
    val x: Int,
    val y: Int,
    var color: Int = 0,
    var readOnly: Boolean = true  // create new Sudoku then remove a certain number of clues
): Serializable {


    override fun hashCode(): Int {
        return getHash(x,y)
    }


}

internal  fun getHash(x: Int, y: Int): Int {
val newX = x*100
    return "$newX$y".toInt()
}