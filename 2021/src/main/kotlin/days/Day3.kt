package days

/**
 * Advent of Code 2021, Day 3 - Binary Diagnostic
 * Problem Description: http://adventofcode.com/2021/day/3
 */
class Day3 : Day(3) {

    override fun partOne(): Any {
        val sumOfBitsPerColumn = sumOfBitsPerColumn(inputList)

        val gamma = sumOfBitsPerColumn
            .map { if (inputList.size - it > it) 0 else 1 }
            .joinToString("")
            .toInt(2)
        val epsilon = sumOfBitsPerColumn
            .map { if (inputList.size - it > it) 1 else 0 }
            .joinToString("")
            .toInt(2)

        return gamma * epsilon
    }

    private fun sumOfBitsPerColumn(lines: List<String>): Array<Int> {
        val numberDigitsPerLine = lines[0].length
        val sumEachColumn = Array(numberDigitsPerLine) { 0 }

        lines.forEach { oneLine ->
            oneLine.forEachIndexed { index, zeroOrOne ->
                sumEachColumn[index] += zeroOrOne.digitToInt()
            }
        }
        return sumEachColumn
    }

    override fun partTwo(): Any {
        val oxygenRating = findRating(inputList, '1', '0')
        val co2Rating = findRating(inputList, '0', '1')

        return oxygenRating * co2Rating
    }

    private fun findRating(fixInputLines: List<String>, highBit: Char, lowBit: Char): Int {
        val ratingCandidates = fixInputLines.toMutableList()
        var index = 0
        while (ratingCandidates.size > 1) {
            val oneCounts = ratingCandidates.sumOf { it[index].digitToInt() }
            val comparisonBit = if (oneCounts >= ratingCandidates.size - oneCounts) highBit else lowBit
            ratingCandidates.removeIf { it[index] != comparisonBit }
            index += 1
        }
        return ratingCandidates[0].toInt(2)
    }

}
