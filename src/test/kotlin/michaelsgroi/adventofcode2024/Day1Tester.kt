package michaelsgroi.adventofcode2024

import michaelsgroi.adventofcode.RESOURCES
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1Tester {
    private val day = 1
    private val test = "$RESOURCES/day${day}_test"
    private val live = "$RESOURCES/day${day}_live"

    @Test
    fun part1() {
        assertEquals(11, Day1().part1(test))
        assertEquals(2192892, Day1().part1(live))
    }

    @Test
    fun part2() {
        assertEquals(31, Day1().part2(test))
        assertEquals(22962826, Day1().part2(live))
    }
}
