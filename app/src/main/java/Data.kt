import java.util.*

/**
 * Created by andrei on 12/2/17.
 */
data class Grade (var name: String, var mark: Float, var weight: Float)

data class Class (var name: String, var assignments: ArrayList<Grade>)

data class Semsester  (var name: String, var classes: ArrayList<Class>)

fun avg(c:Class): Float {
    return c.assignments.map { it.mark * it.weight }.sum() / c.assignments.size
}


