package com.enestekin.graphsudoku.domain

data class Settings(
    val difficulty: Difficulty,
    val boundary: Int // 4x4 9x9 sudoku
)
