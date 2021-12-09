package days

/**
 * Advent of Code 2021, Day 9 - Smoke Basin
 * Problem Description: http://adventofcode.com/2021/day/9
 *
 * Part 1: 439      (67.514722ms)
 * Part 2: unresolved        (8.696us)
 */
class Day9 : Day(9) {

    override fun partOne(): Int {
        return solve(inputList)
    }

    private fun List<String>.neighboursOf(x: Int, y: Int): List<Pair<Int, Int>> {
        val leftNeighbour: Pair<Int, Int> = x - 1 to y
        val rightNeighbour: Pair<Int, Int> = x + 1 to y
        val topNeighbour: Pair<Int, Int> = x to y - 1
        val downNeighbour: Pair<Int, Int> = x to y + 1

        return listOf(leftNeighbour, rightNeighbour, topNeighbour, downNeighbour)
            .filter { (xIndex, yIndex) -> xIndex in indices && yIndex in this[0].indices }
    }

    private fun solve(inputList: List<String>): Int {
        var sum = 0
        val lineLength = inputList[0].length

        for (lineIndex in inputList.indices) {
            for (columnIndex in 0 until lineLength) {
                if (inputList[lineIndex][columnIndex] < inputList.neighboursOf(lineIndex, columnIndex).minOf { (x, y) -> inputList[x][y] }) {
                    sum += inputList[lineIndex][columnIndex].toString().toInt() + 1
                }
            }
        }
        return sum
    }

    override fun partTwo(): Int {
        return 1
    }

}
