import kotlin.math.pow


class Logic {


    class TruthTable

        (numberOfInputs: Int, gate: Gate) {

        private var inputs: MutableList<List<Boolean>> = mutableListOf()
        private var output: MutableList<Boolean> = mutableListOf()

        private val variables: Int = numberOfInputs
        private val operation: Gate = gate

        init {
            val max = (2.0.pow(numberOfInputs) - 1).toInt()
            var current = max
            while(current >= 0) {
                val bits = Integer.toBinaryString(current).toCharArray().toMutableList()

                while(bits.size < numberOfInputs) {
                    bits.add(0, '0') //prepends a leading zero
                }

                inputs.add(bits.map{
                    when(it) {
                        '0' -> false
                        '1' -> true
                        else -> false
                    }
                })
                current -= 1
            }
            inputs.forEach { input ->
                output.add(performBooleanOperation(input, gate))
            }
        }

        fun showTable() {
            val rows: List<Pair<List<Boolean>, Boolean>> = inputs zip output

            println("------  $operation TRUTH TABLE WITH $variables ${ if(variables == 1){"INPUT"} else{"INPUTS"} }  ------")
            rows.forEach { println(it) }
        }

        private fun performBooleanOperation(input: List<Boolean>, gate: Gate): Boolean {
            return when (gate) {
                Gate.NOT -> !input[0]
                Gate.AND -> input.all { it }
                Gate.OR -> input.any { it }
                Gate.NAND -> performBooleanOperation(input, Gate.NOT) and performBooleanOperation(input, Gate.AND)
                Gate.NOR -> performBooleanOperation(input, Gate.NOT) and performBooleanOperation(input, Gate.OR)
            }
        }

        enum class Gate {
            NOT,
            AND,
            OR,
            NAND,
            NOR,
        }


    }

}