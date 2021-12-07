package days

import kotlin.math.abs

/**
 * Advent of Code 2021, Day 7 - The Treachery of Whales
 * Problem Description: http://adventofcode.com/2021/day/7
 *
 * Result Part 1: 351901
 * Result Part 2:
 */
class Day7 : Day(7) {

    override fun partOne(): Int {
        return fuel(true)
    }

    override fun partTwo(): Int {
        return fuel(false)
    }

    private fun fuel(constantFuelRate: Boolean): Int {
        val listOfHorizontalPositions = inputString.split(",").map { it.toInt() }
        val maxPosition = listOfHorizontalPositions.maxOrNull()!!
        val minPosition = listOfHorizontalPositions.minOrNull()!!

        val possibleFuel = Array(abs((maxPosition-minPosition)) +1 ) { 0L }

        for (position in listOfHorizontalPositions) {
            for (possibleTargetPosition in minPosition..maxPosition) {
                var distance = abs(possibleTargetPosition - position)

                if (!constantFuelRate) {
                  distance = (1 until distance + 1).sum()
                }

                possibleFuel[possibleTargetPosition] = possibleFuel[possibleTargetPosition] + distance
            }
        }

        return possibleFuel.toList().minOrNull()?.toInt()!!
    }
}
