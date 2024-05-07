package problems

//1768. Merge Strings Alternately

fun mergeAlternately(word1: String, word2: String): String {
    val word1Length=word1.length
    val word2Length=word2.length
    var i=0
    var j=0
    var newString=""
    while(i< word1Length || j< word2Length){
        if(i<word1Length){
            newString+=word1[i]
            i+=1
        }
        if(j<word2Length){
            newString+=word2[j]
            j+=1
        }
    }
    return newString
}

fun main(){
    println(mergeAlternately("abcd","pq"))
}