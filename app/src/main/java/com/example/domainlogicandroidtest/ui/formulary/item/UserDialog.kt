package com.example.domainlogicandroidtest.ui.formulary.item

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.domainlogicandroidtest.ui.model.User

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun GlassDialog(
    user: User,
){

    Dialog(
        onDismissRequest = {
        },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = true
        )
    ) {
        Column(
            modifier = Modifier
                .height(524.dp)
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
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

            Row {
                Text(
                    text = "Type: ",
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = user.type,
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
            }

            Row {
                Text(
                    text = "Syte Admin: ",
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = user.site_admin.toString(),
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
            }
        }
    }
}