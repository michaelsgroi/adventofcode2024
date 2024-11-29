package michaelsgroi.adventofcode

import java.io.File

class DayWriter {
    fun write(
        year: Int,
        day: Int,
    ) {
        val dayStr = day.toString()

        fun String.writeFileInNotExists(contents: String) {
            val file = File(this)
            if (file.exists()) {
                "File already exists: $file"
            } else {
                println("Creating file: $file")
                file.writeText(contents)
            }
        }

        "src/main/kotlin/michaelsgroi/adventofcode$year/Day$dayStr.kt".writeFileInNotExists(
            """
            package michaelsgroi.adventofcode2024
            
            class Day$dayStr {
                fun part1() {
                    TODO("Day$dayStr.part1() not implemented")
                }
            
                fun part2() {
                    TODO("Day$dayStr.part2() not implemented")
                }
            }
            """.trimIndent(),
        )

        "src/test/kotlin/michaelsgroi/adventofcode$year/Day${dayStr}Tester.kt".writeFileInNotExists(
            """
            package michaelsgroi.adventofcode2024

            import org.junit.jupiter.api.Test

            class Day${dayStr}Tester {
                @Test
                fun part1() {
                    Day$dayStr().part1()
                }

                @Test
                fun part2() {
                    Day$dayStr().part2()
                }
            }

            """.trimIndent(),
        )

        "src/main/resources/day${day}_test".writeFileInNotExists("")
        "src/main/resources/day${day}_live".writeFileInNotExists("")
    }
}
