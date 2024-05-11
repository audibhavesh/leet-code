package problems

fun <T> timeIt(message: String = "", block: () -> T): T {
    val start = System.currentTimeMillis()
    val r = block()
    val end = System.currentTimeMillis()
    println("$message: ${end - start} ms")
    if(r is String){
        println("$r")
    }
    return r
}