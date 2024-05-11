package problems

//190ms
fun reverseWords(s: String): String {
    return s.trim().split(" ").toMutableList().apply { removeIf { it.isEmpty() } }.reversed().joinToString(" ")
}

//214ms
fun reverseWords2(s: String): String {
//    return s.trim().split(" ").filter { it.isNotEmpty() }.reversed().joinToString(" ")
    val words = s.trim().split("\\s+".toRegex()).filter { it.isNotEmpty() }

    // Join the filtered words in reverse order
    return words.reversed().joinToString(" ")
}

//146ms
fun reverseWords3(s: String): String {
    val sb = StringBuilder()
    var start = 0
    var end = s.length - 1

    // Find the start of the first word
    while (start <= end && s[start] == ' ') start++

    // Find the end of the last word
    while (end >= start && s[end] == ' ') end--

    var i = end

    // Iterate through the string in reverse
    while (i >= start) {
        if (s[i] == ' ') {
            sb.append(s.substring(i + 1, end + 1)).append(' ')
            while (i >= start && s[i] == ' ') i--
            end = i
        }
        i--
    }

    sb.append(s.substring(start, end + 1))
    return sb.toString()
}



fun main() {
//    println(timeIt { reverseWords("the sky is blue") })
//    println(timeIt { reverseWords("  hello world  ") })
//    println(timeIt { reverseWords("a good   example") })

//    println(timeIt { reverseWords2("the sky is blue") })
//    println(timeIt { reverseWords2("  hello world  ") })
//    println(timeIt { reverseWords2("a good   example") })

    println(timeIt { reverseWords3("the sky is blue") })
    println(timeIt { reverseWords3("  hello world  ") })
    println(timeIt { reverseWords3("a good   example") })
}