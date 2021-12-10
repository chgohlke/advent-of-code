package days

import kotlin.math.max
import kotlin.math.min

data class Point(val x: Int, val y: Int)
data class Line(val p1: Point, val p2: Point)
data class Diagram(val lines: List<Line>, val maxX: Int, val maxY: Int)

/**
 * Advent of Code 2021, Day 5 - Hydrothermal Venture
 * Problem Description: http://adventofcode.com/2021/day/5
 *
 * Part 1: 5145        (60.424101ms)
 * Part 2: unresolved  (4.627us)
 */
class Day5 : Day(5) {

    override fun partOne(): Any {
        val diagram = parseInput(inputList)
        return countOverlaps(diagram)
    }

    private fun countOverlaps(diagram: Diagram): Any {
        val grid = Array(diagram.maxY + 1) { Array(diagram.maxX + 1) { 0 } }
        
        val filteredLines = diagram.lines.filter { line ->
            line.p1.x == line.p2.x || line.p1.y == line.p2.y
        }

        var counter = 0

        filteredLines.forEach { line ->
            val (point1, point2) = line
            val (x1, y1) = point1
            val (x2, y2) = point2

            when {
                x1 == x2 -> {
                    for (y in min(y1, y2)..max(y1, y2)) {
                        if (++grid[y][x1] == 2) {
                            counter++
                        }
                    }
                }
                y1 == y2 -> {
                    for (x in min(x1, x2)..max(x1, x2)) {
                        if (++grid[y1][x] == 2) {
                            counter++
                        }
                    }
                }
            }
        }

        return counter

    }

    private fun parseInput(input: List<String>): Diagram {
        var maximumX = 0
        var maximumY = 0
        val lines = input.map { line ->
            val (point1, point2) = line.split("->").map { point ->
                val (xCoordinate, yCoordinate) = point.trim().split(",").map { it.toInt() }
                maximumX = maxOf(maximumX, xCoordinate)
                maximumY = maxOf(maximumY, yCoordinate)
                Point(xCoordinate, yCoordinate)
            }

            Line(point1, point2)
        }
        
        return Diagram(lines, maximumX, maximumY)
    }

    
    override fun partTwo(): Any {
        return 0
    }

}
