package com.nohjason.todolist

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nohjason.todolist.ui.theme.DisableDarkGray
import com.nohjason.todolist.ui.theme.DisableGray
import com.nohjason.todolist.ui.theme.PigmaBlue
import com.nohjason.todolist.ui.theme.White


@Composable
fun TodoList(textState: String){
    var list: List<Any> by rememberSaveable { mutableStateOf(listOf()) }

    fun addTodo(){ list = list.toMutableList() + textState }
    fun deleteTodo(index: Int){ list = list.toMutableList().also { it.removeAt(index) } }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            itemsIndexed(list) { index, item ->
                Card(list = list, index = index, delete = { deleteTodo(index) })
            }
        }

        Button(
            onClick = { addTodo() },
            colors = ButtonDefaults.buttonColors(
                containerColor = PigmaBlue,
                contentColor = White,
                disabledContainerColor = DisableGray,
                disabledContentColor = DisableDarkGray
            ),
            enabled = textState.isNotEmpty(),
            modifier = Modifier
                .width(300.dp)
                .align(Alignment.BottomCenter),
        ) { Text(text = "+", fontSize = 25.sp) }
    }
}