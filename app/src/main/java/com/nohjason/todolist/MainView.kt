package com.nohjason.todolist

import android.app.LauncherActivity.ListItem
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalMaterial3Api
@Composable
fun MainView(){
    Column(
        modifier = Modifier
            .padding(30.dp)
            .fillMaxSize()
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center
    ) {
        var list by remember { mutableStateOf(emptyList<Int>()) }
        var textState by remember { mutableStateOf("") }
        var buttonClick by remember { mutableStateOf(false) }

        Row {
            TextField(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(0.8f)
                ,
                value = textState,
                onValueChange = {
                    textState = it
                    buttonClick = it.isNotEmpty()
                }
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .align(CenterVertically)
                    .padding(end = 10.dp),
                enabled = buttonClick,
                onClick = {
                    if (textState != ""){
                        list += 1
                    }
                }) {
//                Text(text = "nothing")
            }
        }
        LazyRow {
//            items(list) {
//                if (textState != ""){
//                    Text(
//                        text = "$textState",
//                        modifier = Modifier.background(Color.White)
//                    )
//                }
//                }
            if (buttonClick) {
                items(list) {
                    Text(text = "$textState")
                }
            }
        }
    }
}