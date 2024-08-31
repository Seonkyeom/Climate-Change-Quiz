package com.khjqwer.wildanimalapp

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Collections

class MainViewModel : ViewModel() {
    var ranks = MutableLiveData<MutableList<LeaderBoardRank>>()

    fun getLeaderBoardRank() {
        viewModelScope.launch(Dispatchers.IO) {
            val repository = Repository()
            val response = repository.getLeaderBoardRank()
            if (response is Response.Success) {
                ranks.postValue(response.data)
            }
        }
    }

    fun updateLeaderBoardRank(username: String, score: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val repository = Repository()
            val response = repository.getLeaderBoardRank()
            if (response is Response.Success) {
                response.data.add(LeaderBoardRank(username, score, 0))

                Collections.sort(response.data,
                    Comparator { rank1: LeaderBoardRank, rank2: LeaderBoardRank -> rank2.score - rank1.score })

                for (i in response.data.indices) {
                    val leaderBoardRank = response.data[i]
                    leaderBoardRank.rank = i + 1
                }

                if (response.data.size > 5) {
                    response.data.removeLast()
                }

                repository.updateLeaderBoardRank(response.data)
                ranks.postValue(response.data)
            } else {
                ranks.postValue(ArrayList())
            }
        }
    }
}