package problems

import kotlin.random.Random

fun mul(nums: IntArray, index: Int, currIndex: Int, acc: Int): Int {
    if (currIndex == nums.size) {
        return acc
    }
    return if (currIndex == index) {
        mul(nums, index, currIndex + 1, acc)
    } else {
        mul(nums, index, currIndex + 1, nums[currIndex] * acc)
    }
}

//time exceeded in some cases
fun productExceptSelf(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    for (index in nums.indices) {
        result[index] = mul(nums, index, 0, 1)
    }
    return result
}

//347 ms
fun productExceptSelf1(nums: IntArray): IntArray {
    val n = nums.size
    val result = IntArray(n)
    // Initialize left and right product arrays
    val leftProducts = IntArray(n) { 1 }
    val rightProducts = IntArray(n) { 1 }
    // Calculate left products
    for (i in 1..<n) {
        leftProducts[i] = leftProducts[i - 1] * nums[i - 1]
    }
    // Calculate right products
    for (i in n - 2 downTo 0) {
        rightProducts[i] = rightProducts[i + 1] * nums[i + 1]
    }
    // Calculate result
    for (i in nums.indices) {
        result[i] = leftProducts[i] * rightProducts[i]
    }

    return result
}

//343ms

//most optimsed version
fun productExceptSelf2(nums: IntArray): IntArray {
    val n = nums.size
    val result = IntArray(n) { 1 }
    var leftProducts = 1
    var rightProducts = 1

    for (i in nums.indices) {
        result[i] *= leftProducts
        leftProducts *= nums[i]

        result[(nums.size - 1) - i] *= rightProducts
        rightProducts *= nums[(nums.size - 1) - i]
    }
    return result
}


fun main() {
    println(timeIt {
        productExceptSelf(intArrayOf(1, 2, 3, 4))
    }.toList().toString())

    val randomArray = IntArray(1000) { Random.nextInt(0, 2) * 2 - 1 }
    println(randomArray.toList().toString())
    println(timeIt {
        productExceptSelf(randomArray)
    }.toList().toString())

    println(timeIt {
        productExceptSelf2(intArrayOf(1, 2, 3, 4))
    }.toList().toString())

    println(randomArray.toList().toString())
    println(timeIt {
        productExceptSelf1(randomArray)
    }.toList().toString())

    println(timeIt {
        productExceptSelf1(intArrayOf(1, 2, 3, 4))
    }.toList().toString())

    println(randomArray.toList().toString())
    println(timeIt {
        productExceptSelf2(randomArray)
    }.toList().toString())
}

