package com.hridoy.androidblog.view.ui.jsonplaceholderUsers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hridoy.androidblog.model.data.api.User
import com.hridoy.androidblog.view.ui.theme.AndroidBlogTheme

@Composable
fun UserItemView(user: User) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Black, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = user.name.substring(0, 1),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = user.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.padding(top = 3.dp))
            Text(
                text = "Username: ${user.username} (Id:${user.id})",
                fontSize = 10.sp,
                fontWeight = FontWeight.Light,
                color = Color.Black,
            )

            Spacer(modifier = Modifier.padding(top = 4.dp))
            Text(
                text = user.email,
                fontSize = 16.sp,
                color = Color.Black,
            )

        }

    }

}

@Preview(uiMode = 1, showBackground = true)
@Composable
fun ItemUserPreview() {
    AndroidBlogTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            UserItemView(user = User( 1,"User Full Name", "@User ","User@gmail.com"))
        }

    }

}