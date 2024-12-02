package michaelsgroi.adventofcode2024

import java.io.File
import kotlin.math.abs

class Day1 {
    fun part1(filePath: String): Long {
        val (left, right) = filePath.toLeftAndRight()
        return left
            .sorted()
            .zip(right.sorted())
            .sumOf { abs(it.second - it.first) }
    }

    fun part2(filePath: String): Long {
        val (left, right) = filePath.toLeftAndRight()
        val rightOccurrenceCount = right.groupingBy { it }.eachCount()
        val similarityScores =
            left.map { leftValue ->
                leftValue * (rightOccurrenceCount[leftValue] ?: 0)
            }
        return similarityScores.sum()
    }

    private fun String.toLeftAndRight(): Pair<List<Long>, List<Long>> {
        val pairs =
            File(this).readLines().map {
                val values = it.split("   ")
                Pair(values[0].toLong(), values[1].toLong())
            }
        return Pair(pairs.map { it.first }, pairs.map { it.second })
    }
}
