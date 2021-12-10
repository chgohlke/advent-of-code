package days

class Value(val value: Int, var marked: Boolean = false)
class Row(val column: List<Value>)
class Bingo(val rows: MutableList<Row>, var position: Int = -1, var lastMarkedNumber: Int = -1)

/**
 * Advent of Code 2021, Day 4 - Giant Squid
 * Problem Description: http://adventofcode.com/2021/day/4
 *
 * Part 1: 50008      (133.119998ms)
 * Part 2: 17408      (26.587793ms)
 */
class Day4 : Day(4) {

    override fun partOne(): Any {
        val allBingos = readBingos(inputList)
        val draws = readDraws(inputList)

        solveBingos(allBingos, draws)

        return calculateResult(allBingos, 1)
    }

    override fun partTwo(): Any {
        val allBingos = readBingos(inputList)
        val draws = readDraws(inputList)

        val lastSolvedBingo = solveBingos(allBingos, draws)

        return calculateResult(allBingos, lastSolvedBingo)
    }

    private fun solveBingos(bingos: List<Bingo>, draws: List<Int>): Int {
        var solvedBingos = 1
        draws.forEach { draw ->
            bingos.forEach { bingo ->
                if (markAndCheck(bingo, draw, solvedBingos)) {
                    solvedBingos += 1
                }
            }
        }
        return solvedBingos - 1
    }

    private fun calculateResult(bingos: List<Bingo>, rank: Int): Int {

        var sum = 0
        var foundBingo = bingos.first { it.position == rank }
        foundBingo.rows.forEach { row ->
                row.column.forEach { column ->
                  if (!column.marked) sum += column.value
             }
        }
        println("$sum, ${foundBingo.lastMarkedNumber}")
        return sum * foundBingo.lastMarkedNumber
    }

    private fun markAndCheck(bingo: Bingo, number: Int, rank: Int): Boolean {
        if (bingo.position != -1) {
            return false
        }

        bingo.rows.forEach { row ->
            row.column.forEach { column ->
                if (column.value == number) {
                    column.marked = true
                }
            }
        }

        //check row
        bingo.rows.forEach { row ->
            var isCompleteRow = true
            row.column.forEach { column ->
                isCompleteRow = isCompleteRow && column.marked
            }
            if (isCompleteRow) {
                bingo.position = rank
                bingo.lastMarkedNumber = number
                return isCompleteRow
            }
        }

        //check column
        var columnIndex = 0
        while (columnIndex < 5) {
            var isCompleteColumn = true
            bingo.rows.forEach { row ->
                isCompleteColumn = isCompleteColumn && row.column[columnIndex].marked
            }
            if (isCompleteColumn) {
                bingo.position = rank
                bingo.lastMarkedNumber = number
                return true
            }
            columnIndex += 1
        }

        return false
    }

    private fun readDraws(inputList: List<String>): List<Int> {
        return inputList[0].split(",").map  { it.toInt() }
    }

    private fun readBingos(inputList: List<String>): List<Bingo> =
        inputList
            .asSequence()
            .drop(1)
            .filter { it.isNotEmpty() }
            .chunked(5)
            .map { parseSingleBingo(it)}
            .toList()


    private fun parseSingleBingo(input: List<String>): Bingo {
        var listOfRows = mutableListOf<Row>()
        input.forEach {
            listOfRows.add(parseLineAsRow(it))
        }
        return Bingo(listOfRows.toMutableList())
    }

    private fun parseLineAsRow(lineWithNumbers: String): Row {
        return Row(lineWithNumbers.trim()
            .split("\\s+".toRegex())
            .map { Value(it.toInt()) })
    }


}
