data class Rectangle(val x1: Int, val y1: Int, val x2: Int, val y2: Int) {

    init {
        require(x1 <= x2 && y1 <= y2) { "Coordenadas inválidas: x1 deve ser menor ou igual a x2 e y1 deve ser menor ou igual a y2." }
    }

    fun intersects(other: Rectangle): Boolean {
        return !(x1 > other.x2 ||
                x2 < other.x1 ||
                y1 > other.y2 ||
                y2 < other.y1)
    }

    fun areaOfIntersection(other: Rectangle): Int {
        if (!intersects(other)) {
            return 0
        }
        val ix1 = maxOf(x1, other.x1)
        val iy1 = maxOf(y1, other.y1)
        val ix2 = minOf(x2, other.x2)
        val iy2 = minOf(y2, other.y2)
        return (ix2 - ix1 + 1) * (iy2 - iy1 + 1)
    }

    override fun toString(): String {
        return "($x1, $y1; $x2, $y2)"
    }
}