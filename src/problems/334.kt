package problems


//453ms
fun increasingTriplet(nums: IntArray): Boolean {
    var small = Int.MAX_VALUE
    var big = Int.MAX_VALUE
    nums.forEach { num ->
        if (num <= small) {
            small = num
        } else if (num <= big) {
            big = num
        } else {
            return true
        }
    }
    return false
}
//same time
fun increasingTriplet2(nums: IntArray): Boolean {
    var first = Int.MAX_VALUE
    var second = Int.MAX_VALUE
    for (num in nums) {
        when {
            num <= first -> first = num
            num <= second -> second = num
            else -> return true
        }
        if (first < Int.MAX_VALUE && second < Int.MAX_VALUE) {
            return true
        }
    }
    return false
}

fun main() {
    timeIt { increasingTriplet(intArrayOf(1, 2, 3, 4, 5)) == true }

//    timeIt { increasingTriplet(intArrayOf(5, 4, 3, 2, 1)) == false }

//    timeIt { increasingTriplet(intArrayOf(2, 1, 5, 0, 4, 6)) == true }

    timeIt { increasingTriplet(intArrayOf(20, 100, 10, 12, 5, 13)) == true }

//    timeIt { increasingTriplet(intArrayOf(6, 7, 1, 2)) == false }

//    timeIt { increasingTriplet(intArrayOf(1, 2, 1, 3)) == true }
    timeIt { increasingTriplet2(intArrayOf(2, 4, -2, -3)) == false }
//
}