package michaelsgroi.adventofcode2024

import michaelsgroi.adventofcode.toFileLines
import michaelsgroi.adventofcode2024.Day2.Safety.DAMPENABLE
import michaelsgroi.adventofcode2024.Day2.Safety.SAFE
import michaelsgroi.adventofcode2024.Day2.Safety.UNSAFE
import kotlin.math.abs

class Day2 {
    fun part1(filePath: String): Int = computeSafetyScore(filePath = filePath, dampenerEnabled = false)

    fun part2(filePath: String): Int = computeSafetyScore(filePath = filePath, dampenerEnabled = true)

    private fun computeSafetyScore(
        filePath: String,
        dampenerEnabled: Boolean,
    ): Int =
        filePath
            .toFileLines()
            .map { reportLine -> reportLine.split(" ").map { it.toInt() } }
            .map { levels ->
                val isSafeWithoutDampening = isSafe(levels)
                val safetyLevel =
                    if (isSafeWithoutDampening) {
                        SAFE
                    } else {
                        val safeCount =
                            levels
                                .filterIndexed { indexToRemove, _ ->
                                    val filteredLevels = levels.filterIndexed { index, _ -> index != indexToRemove }
                                    isSafe(filteredLevels)
                                }.count()
                        if (safeCount > 0) {
                            DAMPENABLE
                        } else {
                            UNSAFE
                        }
                    }
                Report(levels, safetyLevel)
            }.count {
                val acceptableSafety = if (dampenerEnabled) setOf(DAMPENABLE, SAFE) else setOf(SAFE)
                acceptableSafety.contains(it.safety)
            }

    private fun isSafe(levels: List<Int>): Boolean {
        val isIncreasing = levels[0] < levels[1]
        return levels.withIndex().indexOfFirst { indexedValue ->
            val index = indexedValue.index
            val current = indexedValue.value
            val previous = if (index == 0) null else levels[index - 1]
            val trendSafety = isTrendSafe(previous, current, isIncreasing)
            val diffSafety = isDiffSafe(previous, current)
            val isSafe = trendSafety && diffSafety
            !isSafe
        } == -1
    }

    enum class Safety {
        SAFE,
        UNSAFE,
        DAMPENABLE,
    }

    private val acceptableDiff = 1..3

    private fun isTrendSafe(
        earlier: Int?,
        later: Int?,
        isTrendIncreasing: Boolean,
    ): Boolean {
        if (earlier == null || later == null) return true
        val diff = later - earlier
        return diff > 0 == isTrendIncreasing
    }

    private fun isDiffSafe(
        earlier: Int?,
        later: Int?,
    ): Boolean {
        if (earlier == null || later == null) return true
        val diff = later - earlier
        return acceptableDiff.contains(abs(diff))
    }

    data class Report(
        val levels: List<Int>,
        val safety: Safety,
    )
}
