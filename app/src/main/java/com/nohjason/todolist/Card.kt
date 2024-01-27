package com.nohjason.todolist

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import com.nohjason.todolist.ui.theme.PigmaBlue
import com.nohjason.todolist.ui.theme.White

@Composable
fun Card(list: List<Any>, index: Int, delete: () -> Unit) {
    var label by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .height(100.dp)
            .background(PigmaBlue)
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxHeight()
        ){
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(10.dp)
            ) {
                label = list[index].toString()
                Text(
                    text = "$label",
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    color = White,
                )
                Spacer(modifier = Modifier.width(8.dp)) // 적절한 간격으로 조정
                Button(onClick = delete,) { Text(text = "x") }
            }
        }
    }
}