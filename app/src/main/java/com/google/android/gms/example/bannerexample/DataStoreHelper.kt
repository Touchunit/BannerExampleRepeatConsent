package com.google.android.gms.example.bannerexample

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import kotlinx.coroutines.flow.first

object DataStoreHelper {
    val THEME_KEY = intPreferencesKey("Utils.THEME")
    val COUNTER_KEY = intPreferencesKey("COUNTER")

    suspend fun readBoolean(dataStore: DataStore<Preferences>, key: String, defaultValue: Boolean): Boolean {
        val dataStoreKey = booleanPreferencesKey(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey] ?: defaultValue
    }

    suspend fun readInt(dataStore: DataStore<Preferences>, key: String, defaultValue: Int): Int {
        val dataStoreKey = intPreferencesKey(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey] ?: defaultValue
    }

    suspend fun saveInt(dataStore: DataStore<Preferences>, key: String, value: Int) {
        val dataStoreKey = intPreferencesKey(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }

    suspend fun saveBoolean(dataStore: DataStore<Preferences>, key: String, value: Boolean) {
        val dataStoreKey = booleanPreferencesKey(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }
    suspend fun saveLong(dataStore: DataStore<Preferences>, key: String, value: Long) {
        val dataStoreKey = longPreferencesKey(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }
    suspend fun readLong(dataStore: DataStore<Preferences>, key: String, defaultValue: Long = 0): Long {
        val dataStoreKey = longPreferencesKey(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey] ?: defaultValue
    }
}
