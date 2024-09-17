//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var listRectangle = mutableListOf<IntArray>()
    val readRectA = readRectangle("A")
    val readRectB = readRectangle("B")
    val readRectC = readRectangle("C")
    listRectangle.add(readRectA)
    listRectangle.add(readRectB)
    listRectangle.add(readRectC)

    var largest_counter = 16
    for (rect in listRectangle) {
        for (counter in rect) {
            if (counter > largest_counter) {
                largest_counter = counter
            }
        }
    }

    //Criando Grid
    val grid = Grid(largest_counter, largest_counter)
    val rectAGrid = Pair(readRectA[0] to readRectA[1], readRectA[2] to readRectA[3])
    val rectBGrid = Pair(readRectB[0] to readRectB[1], readRectB[2] to readRectB[3])
    val rectCGrid = Pair(readRectC[0] to readRectC[1], readRectC[2] to readRectC[3])
    grid.drawInGrid(listOf(rectAGrid, rectBGrid, rectCGrid))
    grid.printGrid()

    val rectA = Rectangle(readRectA[0], readRectA[1], readRectA[2], readRectA[3])
    val rectB = Rectangle(readRectB[0], readRectB[1], readRectB[2], readRectB[3])
    val rectC = Rectangle(readRectC[0], readRectC[1], readRectC[2], readRectC[3])



    // Calcula a área de interseção entre dois retângulos
    val areaAB = rectA.areaOfIntersection(rectB)
    val areaAC = rectA.areaOfIntersection(rectC)
    val areaBC = rectB.areaOfIntersection(rectC)

    if (areaAB > 0) {
        println("intersects(A, B) => true")
    } else {
        println("intersects(A, B) => false")
    }
    if (areaAC > 0) {
        println("intersects(A, C) => true")
    } else {
        println("intersects(A, C) => false")
    }
    if (areaBC > 0) {
        println("intersects(B, C) => true")
    } else {
        println("intersects(B, C) => false")
    }

    if (areaAB > 0) {
        println("areaOfIntersection(A, B) = $areaAB")
    }
    if (areaAC > 0) {
        println("areaOfIntersection(A, C) = $areaAC")
    }
    if (areaBC > 0) {
        println("areaOfIntersection(B, C) = $areaBC")
    }


}




fun parseRectangle(input: String): IntArray {
    val regex = """\(?\s*(\d+)\s*[;,]\s*(\d+)\s*[;,]\s*(\d+)\s*[;,]\s*(\d+)\s*\)?""".toRegex()
    val matchResult = regex.find(input)
    if (matchResult != null) {
        val (x1, y1, x2, y2) = matchResult.destructured
        return intArrayOf(x1.toInt(), y1.toInt(), x2.toInt(), y2.toInt())
    } else {
        throw IllegalArgumentException("Formato inválido para o retângulo")
    }
}


fun readRectangle(name: String): IntArray {
    println("Digite os pontos para o retângulo $name no formato (x1, y1; x2, y2): ")
    val input = readLine() ?: throw IllegalArgumentException("Entrada inválida")
    return parseRectangle(input)
}