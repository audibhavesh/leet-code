package problems

fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {

    var canPlanted = true
    var totalFlower = n
    if (totalFlower == 0) {
        return true
    }
    if (flowerbed.size == 1) {
        return flowerbed[0] == 0 && totalFlower >= 1
    } else {
        for (i in flowerbed.indices) {
            val previousIndex = i - 1
            val nextIndex = i + 1
            if (previousIndex != -1 && nextIndex < flowerbed.size) {
                if (flowerbed[previousIndex] == 0 && flowerbed[i] == 0 && flowerbed[nextIndex] == 0) {
                    flowerbed[i] = 1
                    totalFlower -= 1
                }
            } else if (previousIndex == -1 && nextIndex < flowerbed.size) {
                if (flowerbed[i] == 0 && flowerbed[nextIndex] == 0) {
                    flowerbed[i] = 1
                    totalFlower -= 1
                }
            } else if (nextIndex > flowerbed.size - 1) {
                if (flowerbed[previousIndex] == 0 && flowerbed[i] == 0) {
                    flowerbed[i] = 1
                    totalFlower -= 1
                }
            }
            if (totalFlower == 0) {
                break
            }
        }
    }

    if (totalFlower != 0) {
        canPlanted = false
    }
    return canPlanted
}

fun canPlaceFlowers1(flowerbed: IntArray, n: Int): Boolean {
    var canPlanted = true
    var totalFlower = n
    if (totalFlower == 0) {
        return true
    }
    if (flowerbed.size == 1) {
        return flowerbed[0] == 0 && totalFlower >= 1
    } else {
        for (i in flowerbed.indices) {
            val previousIndex = i - 1
            val nextIndex = i + 1
            if (previousIndex == -1 && nextIndex < flowerbed.size) {
                if (flowerbed[i] == 0 && flowerbed[nextIndex] == 0) {
                    flowerbed[i] = 1
                    totalFlower -= 1
                }
            } else if (previousIndex != -1 && nextIndex < flowerbed.size) {
                if (flowerbed[previousIndex] == 0 && flowerbed[i] == 0 && flowerbed[nextIndex] == 0) {
                    flowerbed[i] = 1
                    totalFlower -= 1
                }
            } else if (nextIndex == flowerbed.size) {
                if (flowerbed[previousIndex] == 0 && flowerbed[i] == 0) {
                    flowerbed[i] = 1
                    totalFlower -= 1
                }
            }
            if (totalFlower == 0) {
                break
            }
        }
    }

    if (totalFlower != 0) {
        canPlanted = false
    }
    return canPlanted
}

fun canPlaceFlowers2(flowerbed: IntArray, n: Int): Boolean {
    var totalFlower = n
    var canPlanted = true
    var i = 0

    while (i < flowerbed.size) {
        if (flowerbed[i] == 0) {
            val prev = if (i == 0) 0 else flowerbed[i - 1]
            val next = if (i == flowerbed.size - 1) 0 else flowerbed[i + 1]

            if (prev == 0 && next == 0) {
                flowerbed[i] = 1
                totalFlower--
            }
        }
        i++
    }

    if (totalFlower > 0) {
        canPlanted = false
    }

    return canPlanted
}

fun main() {
    //201 ms
    require(canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 1))
    require(canPlaceFlowers(intArrayOf(1), 0))
    require(!canPlaceFlowers(intArrayOf(1, 0), 1))
    require(canPlaceFlowers(intArrayOf(1, 0, 1), 0))
    require(!canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 2))
    require(!canPlaceFlowers(intArrayOf(1, 0, 0, 0, 0, 1), 2))
    require(canPlaceFlowers(intArrayOf(0, 0, 1, 0, 1), 1))
    require(canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1, 0, 0), 2))

    //184 ms
    require(canPlaceFlowers1(intArrayOf(1, 0, 0, 0, 1), 1))
    require(canPlaceFlowers1(intArrayOf(1), 0))
    require(!canPlaceFlowers1(intArrayOf(1, 0), 1))
    require(canPlaceFlowers1(intArrayOf(1, 0, 1), 0))
    require(!canPlaceFlowers1(intArrayOf(1, 0, 0, 0, 1), 2))
    require(!canPlaceFlowers1(intArrayOf(1, 0, 0, 0, 0, 1), 2))
    require(canPlaceFlowers1(intArrayOf(0, 0, 1, 0, 1), 1))
    require(canPlaceFlowers1(intArrayOf(1, 0, 0, 0, 1, 0, 0), 2))


    //>200 ms
    require(canPlaceFlowers2(intArrayOf(1, 0, 0, 0, 1), 1))
    require(canPlaceFlowers2(intArrayOf(1), 0))
    require(!canPlaceFlowers2(intArrayOf(1, 0), 1))
    require(canPlaceFlowers2(intArrayOf(1, 0, 1), 0))
    require(!canPlaceFlowers2(intArrayOf(1, 0, 0, 0, 1), 2))
    require(!canPlaceFlowers2(intArrayOf(1, 0, 0, 0, 0, 1), 2))
    require(canPlaceFlowers2(intArrayOf(0, 0, 1, 0, 1), 1))
    require(canPlaceFlowers2(intArrayOf(1, 0, 0, 0, 1, 0, 0), 2))
}