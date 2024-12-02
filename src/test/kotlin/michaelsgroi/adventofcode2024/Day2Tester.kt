package michaelsgroi.adventofcode2024

import michaelsgroi.adventofcode.RESOURCES
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day2Tester {
    private val day = 2
    private val test = "$RESOURCES/day${day}_test"
    private val live = "$RESOURCES/day${day}_live"

    @Test
    fun part1() {
        assertEquals(2, Day2().part1(test))
        assertEquals(534, Day2().part1(live))
    }

    @Test
    fun part2() {
        assertEquals(4, Day2().part2(test))
        assertEquals(577, Day2().part2(live))
    }
}
