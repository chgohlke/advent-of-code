package days

/**
 * Advent of Code 2021, Day 1 - Sonar Sweep
 * Problem Description: http://adventofcode.com/2021/day/1
 */
class Day1 : Day(1) {

    override fun partOne(): Any {
        val inputAsInt = inputList.map { it.toInt() }

        return inputAsInt
            .zipWithNext()
            .count { (firstMeasurement, secondsMeasurements) ->
                secondsMeasurements > firstMeasurement
            }
    }

    override fun partTwo(): Any {
        val inputAsInt = inputList.map { it.toInt() }
        return inputAsInt
            .windowed(3, 1)
            .zipWithNext()
            .count { (firstWindow, secondWindow) ->
                secondWindow.sum() > firstWindow.sum()
            }
    }
}
