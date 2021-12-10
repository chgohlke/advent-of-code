package days

import kotlin.math.abs

/**
 * Advent of Code 2021, Day 8 - Seven Segment Search
 * Problem Description: http://adventofcode.com/2021/day/8
 *
 * Part 1: 421        (40.676736ms)
 * Part 2: unresolved (8.696us)
 */
class Day8 : Day(8) {

    override fun partOne(): Int {
        return inputList.sumOf { line ->
            line.split("|")[1].split(" ").count { it.length == 2 || it.length == 4 || it.length == 3 || it.length == 7 }
        }
    }

    override fun partTwo(): Int {
        return 1
    }

}
