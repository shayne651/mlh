package com.example.shayne.mlh

import java.io.Serializable
import kotlin.collections.ArrayList

/**
 * Created by andrei on 12/2/17.
 */
data class Grade (var name: String, var mark: Float, var weight: Float,
                  internal var dropped: Boolean = false): Serializable

data class Class (var name: String,
                  val assignments: ArrayList<Grade> = ArrayList<Grade>()): Serializable

data class Semsester  (var name: String,
                       val classes: ArrayList<Class> = ArrayList<Class>()): Serializable

fun newClass(name: String) : Class {
    return Class(name)
}

fun newSemester(name: String) : Semsester {
    return Semsester(name)
}

fun addClass(s:Semsester, c:Class): Semsester {
    s.classes.add(c)
    return s
}

fun addClass(s:Semsester, name:String): Semsester {
    s.classes.add(Class(name))
    return s
}

fun addGrade(c:Class, g:Grade): Class  {
    c.assignments.add(g)
    return c;
}

fun addGrade(c:Class, name: String, mark: Float, weight: Float): Class  {
    c.assignments.add(Grade(name,mark,weight))
    return c;
}

fun drop(g: Grade): Grade {
    g.dropped = true
    return g
}

fun undrop(g: Grade): Grade {
    g.dropped = false
    return g
}

fun Boolean.toInt() = if (this) 1 else 0

fun avg(c: Class): Float {
    return c.assignments.map { it.mark * it.weight * it.dropped.toInt() }.sum() /
            c.assignments.map { (!it.dropped).toInt() }.sum()
}


