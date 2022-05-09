package com.example.chapter6baru

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserManager(context : Context) {

    private val dataStore : DataStore<Preferences> = context.createDataStore(name = "user_prefs")

    companion object {
        val NAMA = preferencesKey<String>("USER_NAMA")
        val UMUR = preferencesKey<Int>("USER_UMUR")
    }

    suspend fun saveData(nama : String, umur : Int){
        dataStore.edit {
            it[NAMA] = nama
            it[UMUR] = umur
        }
    }
    val userNama : Flow<String> = dataStore.data.map {
        it[NAMA] ?: ""
    }
    val userUmur : Flow<Int> = dataStore.data.map {
        it[UMUR] ?: 0
    }

    suspend fun clearData(){
        dataStore.edit {
            it.clear()
        }
    }
}