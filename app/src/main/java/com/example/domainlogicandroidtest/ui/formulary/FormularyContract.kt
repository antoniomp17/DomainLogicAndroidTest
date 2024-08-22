package com.example.domainlogicandroidtest.ui.formulary

interface FormularyContract {
    interface View {}

    interface Presenter {
        val state: FormularyState
        fun search()
        fun changeNameToSearch(nameToSearch: String)
    }
}