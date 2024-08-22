package com.example.domainlogicandroidtest.ui.formulary

import com.example.domainlogicandroidtest.ui.model.User

data class FormularyState(
    val nameToSearch: String = "",
    val users: List<User> = emptyList(),
    val error: String = ""
)