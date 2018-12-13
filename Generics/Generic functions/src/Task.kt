import java.util.*

fun <T, C: MutableCollection<T>> Collection<T>.partitionTo(collection1: C, collection2: C, predicate: (T) -> Boolean): Pair<C, C> {
    for (element in this) {
        if (predicate(element)) {
            collection1.add(element)
        } else {
            collection2.add(element)
        }
    }
    return Pair(collection1, collection2)
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e").
            partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
    words == listOf("a", "c")
    lines == listOf("a b", "d e")
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}').
            partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
    letters == setOf('a', 'r')
    other == setOf('%', '}')
}