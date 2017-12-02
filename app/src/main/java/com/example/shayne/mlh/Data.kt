package com.example.shayne.mlh

import java.io.Serializable
import kotlin.collections.ArrayList

/**
 * Created by andrei on 12/2/17.
 */
data class Grade(var name: String, var weight: Float,
                 internal var totalComponents: Int, internal var drop_lowest: Int = 0,
                 private var _components: Array<Float>, var mark: Float = 0f,
                 var totalMark: Float = 0f) : Serializable {
    var components: Array<Float>
        get() = _components
        set(components) {
            val size = components.size
            val validMarks = components.sortedArray().sliceArray(drop_lowest until size)
            val sum = validMarks.sum()
            if (totalComponents < size)
                totalComponents = size

            mark = sum / size
            totalMark = sum / totalComponents

            _components = components
        }
}

data class Class(var name: String,
                 val assignments: ArrayList<Grade> = ArrayList<Grade>()) : Serializable

data class Semsester(var name: String,
                     val classes: ArrayList<Class> = ArrayList<Class>()) : Serializable

fun newGrade(name: String, weight: Float, components: Array<Float>): Grade {
    val sum = components.sum()
    val mark = sum / components.size
    return Grade(name, weight, components.size, _components = components, mark = mark)
}

fun newGrade(name: String, weight: Float, components: Array<Float>, totalComponents: Int): Grade {
    val sum = components.sum()
    val mark = sum / components.size
    val totalMark = sum / totalComponents
    var count = totalComponents
    if (totalComponents < components.size)
        count = components.size
    return Grade(name, weight, count, _components = components, mark = mark,
            totalMark = totalMark)
}

fun newGrade(name: String, weight: Float, components: Array<Float>, totalComponents: Int, drop_lowest: Int): Grade {
    val size = components.size
    val validMarks = components.sortedArray().sliceArray(drop_lowest until size)
    val sum = validMarks.sum()
    val mark = sum / components.size
    val totalMark = sum / totalComponents
    var count = totalComponents
    if (totalComponents < components.size)
        count = components.size
    return Grade(name, weight, count, _components = components, mark = mark,
            totalMark = totalMark, drop_lowest = drop_lowest)
}


fun newClass(name: String): Class {
    return Class(name)
}

fun newSemester(name: String): Semsester {
    return Semsester(name)
}

fun addClass(s: Semsester, c: Class): Semsester {
    s.classes.add(c)
    return s
}


fun addClass(s: Semsester, name: String): Semsester {
    s.classes.add(Class(name))
    return s
}

fun addGrade(c: Class, g: Grade): Class {
    c.assignments.add(g)
    return c;
}

fun addGrade(c: Class, name: String, weight: Float, components: Array<Float>): Class {
    c.assignments.add(newGrade(name, weight, components))
    return c;
}

fun gradeNeeded(c: Class): Float {
    return gradeNeeded(c, 0.5f)
}

fun gradeNeeded(c: Class, target: Float): Float {
    return (target - avg(c)) / (1 - c.assignments.map { it.weight }.sum())
}

fun Boolean.toInt() = if (this) 1 else 0

fun avg(c: Class): Float {
    return c.assignments.map { it.mark * it.weight }.sum() / c.assignments.count()
}


