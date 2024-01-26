package com.nohjason.todolist

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.dp

@Composable
fun Card(list: List<Any>, index: Int, delete: () -> Unit) {
    var label by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier
            .padding(12.dp)
            .border(4.dp, Color.Black)
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Row {
            label = list[index].toString()
            Text(text = "$label")
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = delete) { Text(text = "x") }
        }
    }
}