package com.khjqwer.wildanimalapp

sealed class Response {
    data class Success(val data: MutableList<LeaderBoardRank>) : Response()
    data object Failure : Response()
    data object NotExist : Response()
    data object AlreadyExist : Response()
}