import Logic.TruthTable.Gate

fun main(args: Array<String>) {
    val table = Logic.TruthTable(1, Gate.NOT)
    table.showTable()
}