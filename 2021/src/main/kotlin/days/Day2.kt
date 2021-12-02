package days

abstract class Command(var x: Int)
class Forward(x: Int): Command(x)
class Down(x: Int):Command(x)
class Up(x: Int): Command(x)


class Day2 : Day(2) {

    override fun partOne(): Any {
        val commandList = inputList.map { parse(it) }

        var position = 0
        var depth = 0

        commandList.forEach { command ->
            when (command) {
                is Forward -> position += command.x
                is Down -> depth += command.x
                is Up -> depth -= command.x
            }
        }
        return depth * position
    }

    override fun partTwo(): Any {
        val commandList = inputList.map { parse(it) }

        var position = 0
        var depth = 0
        var aim = 0

        commandList.forEach { command ->
            when (command) {
                is Forward -> {
                    position += command.x
                    depth += command.x * aim
                }
                is Down -> aim += command.x
                is Up -> aim -= command.x
            }
        }
        return depth * position
    }

    private fun parse(line: String) = line.split(' ').let { (command, x) ->
        when (command) {
            "forward" -> Forward(x.toInt())
            "up" -> Up(x.toInt())
            "down" -> Down(x.toInt())
            else -> throw IllegalArgumentException("unknown command found: $command")
        }
    }
}