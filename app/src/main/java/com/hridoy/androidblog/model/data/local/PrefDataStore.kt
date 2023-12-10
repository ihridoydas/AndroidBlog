package com.hridoy.androidblog.model.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Preference data store class
 * @param context get activity context
 */
class PrefDataStore(private val context: Context) {

    private val defaultLanguage = 1

    // to make sure there's only one instance
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("appPref")
        //For MultiLanguage
        val PREF_LANGUAGE = intPreferencesKey("language")

    }
    //set and get value

    //For MultiLanguage
    suspend fun setLanguage(language: Int) {
        context.dataStore.edit { preferences ->
            preferences[PREF_LANGUAGE] = language
        }
    }

    val getLanguage: Flow<Int> = context.dataStore.data
        .map { preferences ->
            preferences[PREF_LANGUAGE] ?: defaultLanguage
        }
}