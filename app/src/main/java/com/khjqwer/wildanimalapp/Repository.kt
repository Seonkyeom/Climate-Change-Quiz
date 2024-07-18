package com.khjqwer.wildanimalapp

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.microsoft.azure.storage.CloudStorageAccount
import com.microsoft.azure.storage.blob.CloudBlobClient
import com.microsoft.azure.storage.blob.CloudBlobContainer
import com.microsoft.azure.storage.blob.CloudBlockBlob


class Repository {
    private val blob: CloudBlockBlob
        get() {
            val account: CloudStorageAccount = CloudStorageAccount.parse(StorageConnectionString)
            val blobClient: CloudBlobClient = account.createCloudBlobClient()
            val cloudBlobContainer: CloudBlobContainer = blobClient.getContainerReference(
                StoragePersonContainer
            )
            return cloudBlobContainer.getBlockBlobReference("rank")
        }

    fun getLeaderBoardRank(): Response {
        return try {
            val blob: CloudBlockBlob = blob
            if (blob.exists()) {
                val type = object : TypeToken<ArrayList<LeaderBoardRank?>?>() {}.type
                val gson = Gson()
                val leaderBoardRank: MutableList<LeaderBoardRank> = gson.fromJson(blob.downloadText(), type)
                Response.Success(leaderBoardRank)
            } else {
                Response.NotExist
            }
        } catch (e: Exception) {
            Response.Failure
        }
    }

    fun updateLeaderBoardRank(ranks: MutableList<LeaderBoardRank>): Response {
        return try {
            val blob: CloudBlockBlob = blob
            val gson = Gson()
            blob.uploadText(gson.toJson(ranks))
            Response.Success(ranks)
        } catch (e: Exception) {
            Response.Failure
        }
    }

    companion object {
        const val StorageConnectionString = ("DefaultEndpointsProtocol=https;"
                + "AccountName=dreamstudy;"
                + "AccountKey=NV+ttpT3qnE4f2HoRuM03NIqcAeKj0M4kkZvqnvviEfRxDu+C5r12OcmJUgYKudwsyih3VQDuXPzJW8RTzUioA==")
        const val StoragePersonContainer = "0928eric"
    }
}