package problems

import kotlin.math.absoluteValue

fun gcdOfStrings(str1: String, str2: String): String {
    var ans = ""
    var gcd = ""
    var i = 0
    while (i < str1.length && i < str2.length && str1[i] == str2[i]) {
        gcd += str1[i]
        i += 1
        if (str1.length % gcd.length == 0 && str2.length % gcd.length == 0) {
            ans = gcd
        }
    }
    if (ans != "") {
        var j = (str1.length / ans.length)
        if (ans.repeat(j) != str1) {
            return ""
        }
        j = str2.length / ans.length
        if (ans.repeat(j) != str2) {
            return ""
        }
    }
    return ans
}

fun main() {
    println(gcdOfStrings("ABABABAB", "ABAB"))
    println(gcdOfStrings("LEET", "CODE"))
    println(gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"))
}