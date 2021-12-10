package days

/**
 * Advent of Code 2021, Day 10 -
 * Problem Description: http://adventofcode.com/2021/day/10
 *
 * Part 1: 344193          (27.013864ms)
 * Part 2: 3241238967      (3.756616ms)
 */
class Day10 : Day(10) {

    private val corruptChar = 0L
    private val openChars = listOf('<', '(', '{', '[')
    private val closeChars = listOf('>', ')', '}', ']')
    private val corruptedScores = mapOf(
        ')' to 3,
        ']' to 57,
        '}' to 1197,
        '>' to 25137
    )
    private val missingScores = mapOf(
        ')' to 1,
        ']' to 2,
        '}' to 3,
        '>' to 4
    )

    override fun partOne(): Int {
        return inputList.sumOf { getCorruptedChunkScore(it) }
    }


    override fun partTwo(): Long {
        val scores = inputList.map { getIncompleteScore(it) }.filter { it != corruptChar }.sorted()
        return scores[scores.size / 2]
    }

    private fun getIncompleteScore(line: String): Long {
        val chunkStack = ArrayDeque<Char>()
        line.toCharArray().forEach {
            when (it) {
                in openChars ->
                    chunkStack.addFirst(getChunkClosingCharFor(it))
                in closeChars -> {
                    if (chunkStack.removeFirst() != it) {
                        return corruptChar
                    }
                }
            }
        }

        var score = 0L
        while (chunkStack.isNotEmpty()) {
            score *= 5
            score += missingScores[chunkStack.removeFirst()] ?: 0
        }
        return score
    }

    private fun getCorruptedChunkScore(line: String): Int {
        val chunkStack = ArrayDeque<Char>()
        line.toCharArray().forEach {
            when (it) {
                in openChars ->
                    chunkStack.addFirst(getChunkClosingCharFor(it))
                in closeChars -> {
                    if (chunkStack.removeFirst() != it) {
                        return corruptedScores[it] ?: 0
                    }
                }
            }
        }
        return 0
    }

    private fun getChunkClosingCharFor(openChar: Char): Char {
        return closeChars[openChars.indexOf(openChar)]
    }

}
