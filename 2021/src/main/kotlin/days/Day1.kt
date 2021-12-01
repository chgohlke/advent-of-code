package days

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
