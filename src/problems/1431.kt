package problems

//196ms
fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
    return  candies.map { it + extraCandies }.map { extraAdded ->
        !candies.map {
            it <= extraAdded
        }.any { !it }
    }
}

//195ms
fun kidsWithCandies2(candies: IntArray, extraCandies: Int): List<Boolean> {
    val maxCandies = candies.maxOrNull() ?: return emptyList()
    val threshold = maxCandies - extraCandies

    return candies.map { it >= threshold }
}

//200ms
fun kidsWithCandies3(candies: IntArray, extraCandies: Int): List<Boolean> {
    val maxCandies = candies.maxOrNull() ?: return emptyList()
    return candies.map { it + extraCandies >= maxCandies }
}



fun main() {
    println(kidsWithCandies(intArrayOf(2, 3, 5, 1, 3), 3))
    println(kidsWithCandies(intArrayOf(4, 2, 1, 1, 2), 1))
    println(kidsWithCandies(intArrayOf(12, 1, 12), 10))

    println(kidsWithCandies2(intArrayOf(2, 3, 5, 1, 3), 3))
    println(kidsWithCandies2(intArrayOf(4, 2, 1, 1, 2), 1))
    println(kidsWithCandies2(intArrayOf(12, 1, 12), 10))

    println(kidsWithCandies3(intArrayOf(2, 3, 5, 1, 3), 3))
    println(kidsWithCandies3(intArrayOf(4, 2, 1, 1, 2), 1))
    println(kidsWithCandies3(intArrayOf(12, 1, 12), 10))
}