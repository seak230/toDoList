package com.nohjason.todolist

import android.app.LauncherActivity.ListItem
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MainView(
//    names: List<String> = List(0) { "$it" }
){
    Column(
        modifier = Modifier
            .padding(30.dp)
            .fillMaxSize()
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center
    ) {
        var add by remember { mutableStateOf(0) }
        var list by remember { mutableStateOf(emptyList<Int>()) }
//        val dataList = listOf("Apple", "Banana", "Orange", "Grape", "Cherry")

//        Text(text = "$list")

        Button(onClick = {
            add += 1
            list = list + add
        }) {
            Text(text = "+")
        }

        LazyRow() {
            items(list) { name ->
                CardContent(name = "$add")
            }
        }
    }
}