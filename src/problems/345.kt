package problems

//3352
fun reverseVowels(s: String): String {
    var reverseVowel = ""
    val vowels = "aeiouAEIOU".toCharArray()
    val positionIndex = mutableMapOf<Int, Char>()
    for (charIndex in s.indices) {
        if (s[charIndex] in vowels) {
            positionIndex[charIndex] = s[charIndex]
        }
    }
    val reverseAllVowels = positionIndex.values.joinToString("").reversed().toCharArray()
    positionIndex.keys.forEachIndexed { index, i ->
        positionIndex.replace(i, reverseAllVowels[index])
    }
    for (charIndex in s.indices) {
        if (positionIndex.containsKey(charIndex)) {
            reverseVowel += positionIndex[charIndex]
        } else {
            reverseVowel += s[charIndex]
        }
    }
    return reverseVowel
}

//3234
fun reverseVowels1(s: String): String {
    var reverseVowel = ""
    val vowels = "aeiouAEIOU"
    var allVowels = ""
    for (charIndex in s.indices) {
        if (s[charIndex] in vowels) {
            allVowels += (s[charIndex])
        }
    }
    for (charIndex in s.indices) {
        if (s[charIndex] in vowels) {
            reverseVowel += allVowels.last()
            allVowels = allVowels.dropLast(1)
        } else {
            reverseVowel += s[charIndex]
        }
    }
    return reverseVowel
}


//1964ms
fun reverseVowels2(s: String): String {
    var reverseVowel = ""
    val vowels = "aeiouAEIOU"
    var allVowels = ""
    for (charIndex in s.indices) {
        if (s[charIndex] in vowels) {
            allVowels += s[charIndex]
        }
    }

    var index = allVowels.length - 1
    for (char in s) {
        if (char in vowels) {
            reverseVowel += allVowels[index]
            index -= 1
        } else {
            reverseVowel += char
        }
    }
    return reverseVowel
}


//186 ms
fun reverseVowels3(s: String): String {
    val reverseVowel = s.toCharArray()
    val vowels = "aeiouAEIOU"
    var i = 0
    var j = s.length - 1
    while (i < j) {
        if (reverseVowel[i] in vowels && reverseVowel[j] in vowels) {
            val temp = s[i]
            reverseVowel[i] = reverseVowel[j]
            reverseVowel[j] = temp
            j--
            i++
        } else if (s[i] in vowels) {
            j--
        } else if (s[j] in vowels) {
            i++
        } else {
            i++
            j--
        }
    }
    return String(reverseVowel)
}

fun main() {
    require(timeIt {
        reverseVowels2("A man, a plan, a canal: Panama")
    } == "a man, a plan, a canal: PanamA")
    require(timeIt { reverseVowels2("hello") } == "holle")
    require(timeIt { reverseVowels2("leetcode") } == "leotcede")

    require(timeIt {
        reverseVowels3("A man, a plan, a canal: Panama")
    } == "a man, a plan, a canal: PanamA")
    require(timeIt { reverseVowels3("hello") } == "holle")
    require(timeIt { reverseVowels3("leetcode") } == "leotcede")
}