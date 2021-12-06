package days

/**
 * Advent of Code 2021, Day 6 - Lanternfish
 * Problem Description: http://adventofcode.com/2021/day/6
 */
class Day6 : Day(6) {

    override fun partOne(): Long {
        return calculatePopulation(80)
    }

    override fun partTwo(): Long {
        return calculatePopulation(256)
    }

    private fun calculatePopulation(maxDays: Int): Long {
        val day = Array(9) { 0L }

        inputList[0].split(",").forEach { day[it.toInt()]++ }

        repeat(maxDays) {
            val numberFishesWithZeroDay = day[0]
            (0..7).forEach { day[it] = day[it + 1] }

            day[8] = numberFishesWithZeroDay
            day[6] += numberFishesWithZeroDay
        }

        return day.sum()
    }
    
}
