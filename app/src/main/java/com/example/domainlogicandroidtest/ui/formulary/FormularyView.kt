package com.example.domainlogicandroidtest.ui.formulary

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.domainlogicandroidtest.ui.formulary.item.UserItem
import com.example.domainlogicandroidtest.ui.model.User

@Composable
fun Formulary(presenter: FormularyPresenter, userSelected: (String) -> Unit){
    Column{
        SearchUser(presenter)
        UserList(presenter){
            userSelected(it)
        }
    }
}

@Composable
fun SearchUser(
    presenter: FormularyPresenter
){
    var text by remember { mutableStateOf(presenter.state.nameToSearch) }
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .border(width = 1.dp, color = Color.Gray, shape = ShapeDefaults.Large)
            .clip(shape = ShapeDefaults.Large),
        shape = ShapeDefaults.Large,
        singleLine = true,
        maxLines = 1,
        value = text,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            keyboardController?.hide()
            presenter.search()
        }),
        onValueChange =
        {
            text = it
            presenter.changeNameToSearch(it)
        },
        placeholder =
        {
            Text(text = "Buscar", color = Color.Gray)
        },
        trailingIcon =
        {
            IconButton(onClick = {
                presenter.search()
            })
            {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Icono de buscar"
                )

            }
        }
    )
}

@Composable
fun UserList(presenter: FormularyPresenter, userSelected: (String) -> Unit){
    val state = presenter.state
    val gridState = rememberLazyGridState()

    if(state.error.isEmpty()){
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            state = gridState,
            content = {
                items(items = state.users,
                    key = { user -> user.id },
                    contentType = { it }
                ) { user ->
                    // Agrega tu vista para mostrar el usuario
                    UserItem(user = user) {
                        userSelected(it.html_url)
                    }
                }
            }
        )
    } else {
        Text(text = state.error)
    }
}