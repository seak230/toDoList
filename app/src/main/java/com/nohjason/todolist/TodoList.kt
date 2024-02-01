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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// Android Room 을 이용해 사용해보자!
// Context는 LocalContext.current 를 사용해 호출할 수 있다!
// Main Thread에서 동작을 권장하지 않음.
// 즉 IO Thread에서 통신 작업을 하고 뷰 작업을 Main Thread로 옮기는 걸 채택.
@Composable
fun TodoList(textState: String){
    var list: List<String> by rememberSaveable { mutableStateOf(listOf()) }

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        coroutineScope.launch {
            withContext(Dispatchers.IO) {
                // IO Thread내에서 작동함.
                // room호출
            }
        }
    }

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