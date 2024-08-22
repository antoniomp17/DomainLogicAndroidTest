package com.example.domainlogicandroidtest.ui.formulary

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.domainlogicandroidtest.domain.model.User
import com.example.domainlogicandroidtest.domain.usecase.GetUsers
import com.example.domainlogicandroidtest.platform.interactor.GetUsersInteractor
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class FormularyPresenter @Inject constructor(
    private val getUsersInteractor: GetUsersInteractor
): FormularyContract.Presenter, GetUsers.Listener {
    override var state by mutableStateOf(FormularyState())
        private set

    init {
        getUsersInteractor.getAsync(this)
    }

    override fun search(){
        if(state.nameToSearch.length in 4..20){
            getUsersInteractor.setName(state.nameToSearch)
            getUsersInteractor.run()
        } else {
            state = state.copy(
                error = "El nombre no cumple con los requisitos"
            )
        }
    }

    override fun changeNameToSearch(nameToSearch: String){
        state = state.copy(
            nameToSearch = nameToSearch
        )
    }

    override fun onUsersReceived(users: MutableList<User>?, isCached: Boolean) {
        if (users != null) {
            state = state.copy(
                users = users.take(10).map{
                    com.example.domainlogicandroidtest.ui.model.User(
                        it.login,
                        it.id,
                        it.login,
                        it.avatarUrl,
                        it.gravatarId,
                        it.url,
                        it.htmlUrl,
                        it.followersUrl,
                        it.followingUrl,
                        it.gistsUrl,
                        it.starredUrl,
                        it.subscriptionsUrl,
                        it.organizationsUrl,
                        it.reposUrl,
                        it.eventsUrl,
                        it.receivedEventsUrl,
                        it.type,
                        it.isSiteAdmin,
                        it.score
                    )
                }
            )
            state = state.copy(
                error = ""
            )
        }
    }

    override fun onError(e: Exception?) {
        if (e != null) {
            state = state.copy(
                error = e.message.toString()
            )
        }
    }

    override fun onNoInternetAvailable() {
        state = state.copy(
            error = "No hay conexión a internet"
        )
    }
}