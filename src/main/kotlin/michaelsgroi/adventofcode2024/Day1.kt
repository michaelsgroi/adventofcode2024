package michaelsgroi.adventofcode2024

import java.io.File
import kotlin.math.abs

class Day1 {
    fun part1(filePath: String): Long {
        val pairs =
            File(filePath).readLines().map {
                val values = it.split("   ")
                Pair(values[0].toLong(), values[1].toLong())
            }
        val left = pairs.map { it.first }.sorted()
        val right = pairs.map { it.second }.sorted()
        return left
            .zip(right)
            .sumOf { abs(it.second - it.first) }
    }

    fun part2(filePath: String): Long {
        val pairs =
            File(filePath).readLines().map {
                val values = it.split("   ")
                Pair(values[0].toLong(), values[1].toLong())
            }
        val right = pairs.map { it.second }
        val rightOccurrenceCount = right.groupingBy { it }.eachCount()
        val left = pairs.map { it.first }
        val similarityScores =
            left.map { leftValue ->
                leftValue * (rightOccurrenceCount[leftValue] ?: 0)
            }
        return similarityScores.sum()
    }
}
