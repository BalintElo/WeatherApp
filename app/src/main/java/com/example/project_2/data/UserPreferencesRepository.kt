/*
package com.example.project_2.data

import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences

val STORE_KEY_LOCATION = stringPreferencesKey("weather_location")
class UserPreferencesRepository(
    private val dataStore: DataStore<Preferences>

){
    val location: Flow<String> = dataStore.data
        .map { preferences ->
// No type safety.
          preferences[STORE_KEY_LOCATION] ?: "Kapfenberg"
        }
}
*/