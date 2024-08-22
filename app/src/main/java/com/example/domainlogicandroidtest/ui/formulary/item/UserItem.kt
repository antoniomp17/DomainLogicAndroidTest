package com.example.domainlogicandroidtest.ui.formulary.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.domainlogicandroidtest.ui.model.User

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UserItem(
    user: User,
    onSelectUser: (User) -> Unit
){

    Card(
    modifier = Modifier
    .fillMaxWidth()
    .height(150.dp)
    .padding(4.dp),
    shape = ShapeDefaults.Large,
    onClick = {
        onSelectUser(user)
    }
    ){
        Column (modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){

            GlideImage(
                modifier = Modifier
                    .padding(top = 16.dp, end = 8.dp, start = 8.dp, bottom = 8.dp)
                    .size(64.dp),
                model = user.avatar_url,
                contentDescription = user.gravatar_id
            )

            Row {
                Text(
                    text = "User: ",
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = user.login,
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
            }

            Row {
                Text(
                    text = "Id: ",
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = user.id.toString(),
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
            }
        }
    }
}