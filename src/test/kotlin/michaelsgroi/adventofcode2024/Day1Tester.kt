package michaelsgroi.adventofcode2024

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1Tester {
    private val test = "src/main/resources/day1_test"
    private val live = "src/main/resources/day1_live"

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
