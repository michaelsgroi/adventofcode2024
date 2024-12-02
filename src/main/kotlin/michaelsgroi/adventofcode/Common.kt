package michaelsgroi.adventofcode

import java.io.File

const val RESOURCES = "src/main/resources"

fun String.toFileLines(): List<String> = File(this).readLines()
