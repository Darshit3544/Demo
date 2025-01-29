package org.example.demoproject.UI.HomeScreen

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchStateModel {
    private val _query = MutableStateFlow("")
    val query = _query.asStateFlow()

    fun updateQuery(newQuery: String) {
        _query.value = newQuery
    }
}