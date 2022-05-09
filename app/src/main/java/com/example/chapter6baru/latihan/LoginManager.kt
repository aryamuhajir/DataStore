package com.example.chapter6baru.latihan

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import com.example.chapter6baru.UserManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LoginManager(context : Context) {

    private val dataStore : DataStore<Preferences> = context.createDataStore(name = "user_prefs2")
    private val dataStore2 : DataStore<Preferences> = context.createDataStore(name = "status")

    companion object {
        val USERNAME = preferencesKey<String>("USERNAME")
        val PASSWORD = preferencesKey<String>("PASSWORD")
        val STATUS = preferencesKey<String>("STATUS")
    }

    suspend fun register(username : String, password : String){
        dataStore.edit {
            it[USERNAME] = username
            it[PASSWORD] = password
        }
    }
    suspend fun setStatus(status : String){
        dataStore2.edit {
            it[STATUS] = status
        }
    }

    val userNAME : Flow<String> = dataStore.data.map {
        it[LoginManager.USERNAME] ?: ""
    }
    val userPASS : Flow<String> = dataStore.data.map {
        it[LoginManager.PASSWORD] ?: ""
    }
    val userSTATUS : Flow<String> = dataStore2.data.map {
        it[LoginManager.STATUS] ?: "no"
    }

}