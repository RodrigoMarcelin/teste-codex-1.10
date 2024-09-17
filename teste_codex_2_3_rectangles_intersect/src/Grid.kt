
class Grid(private val width: Int, private val height: Int) {

    private val grid: Array<CharArray> = Array(height) { CharArray(width) { '.' } }

    fun drawRectangle(x1: Int, y1: Int, x2: Int, y2: Int, fill: Char) {
        for (y in y1..y2) {
            if (y in 0 until height) {
                for (x in x1..x2) {
                    if (x in 0 until width) {
                        if (x == x1 || x == x2 || y == y1 || y == y2) {
                            if ((x == x1 && y == y1) || (x == x2 && y == y1) ||
                                (x == x1 && y == y2) || (x == x2 && y == y2)
                            ) {
                                grid[height - 1 - y][x] = '+'
                            } else if (x == x1 || x == x2) {
                                grid[height - 1 - y][x] = '|'
                            } else if (y == y1 || y == y2) {
                                grid[height - 1 - y][x] = '-'
                            }
                        } else if (fill == '#') {
                            grid[height - 1 - y][x] = fill
                        }
                    }
                }
            }
        }
    }

    fun intersectionRect(x1: Int, y1: Int, x2: Int, y2: Int) {
        for (y in y1..y2) {
            if (y in 0 until height) {
                for (x in x1..x2) {
                    if (x in 0 until width) {
                        grid[height - 1 - y][x] = '#'
                    }
                }
            }
        }
    }

    fun drawInGrid(rectangles: List<Pair<Pair<Int, Int>, Pair<Int, Int>>>) {
        rectangles.forEach { (start, end) ->
            drawRectangle(start.first, start.second, end.first, end.second, '.')
        }

        for (i in rectangles.indices) {
            for (j in i + 1 until rectangles.size) {
                val (x1, y1) = Pair(
                    maxOf(rectangles[i].first.first, rectangles[j].first.first),
                    maxOf(rectangles[i].first.second, rectangles[j].first.second)
                )
                val (x2, y2) = Pair(
                    minOf(rectangles[i].second.first, rectangles[j].second.first),
                    minOf(rectangles[i].second.second, rectangles[j].second.second)
                )
                if (x1 <= x2 && y1 <= y2) {
                    intersectionRect(x1, y1, x2, y2)
                }
            }
        }
    }

    fun printGrid() {
        for (row in grid) {
            println('|' + row.joinToString("") + '|')
        }
        println('+' + "-".repeat(width) + '+')
    }
}
