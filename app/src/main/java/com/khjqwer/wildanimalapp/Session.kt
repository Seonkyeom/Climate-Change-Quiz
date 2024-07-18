package com.khjqwer.wildanimalapp

// Singleton
object Session {
    var questionsAnsweredCount = 0
    val score: Int
        get() = questionsAnsweredCount * 5
}