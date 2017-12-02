package com.example.shayne.mlh

import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by andrei on 12/2/17.
 */
data class Grade (var name: String, var mark: Float, var weight: Float)

data class Class (var name: String, val assignments: ArrayList<Grade> = ArrayList<Grade>())

data class Semsester  (var name: String, val classes: ArrayList<Class> = ArrayList<Class>())

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

fun addGrade(c:Class, g:Grade): Class  {
    c.assignments.add(g)
    return c;
}

fun avg(c: Class): Float {
    return c.assignments.map { it.mark * it.weight }.sum() / c.assignments.size
}

