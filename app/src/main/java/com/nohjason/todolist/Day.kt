package com.nohjason.todolist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nohjason.todolist.ui.theme.PigmaBlue
import com.nohjason.todolist.ui.theme.White
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun Day(currentTime: Long){
    val dateDay = SimpleDateFormat("dd", Locale.ENGLISH)
    val date = SimpleDateFormat("E", Locale.ENGLISH)

    Box(
        modifier = Modifier
            .size(60.dp)
            .background(PigmaBlue, shape = RoundedCornerShape(10.dp))
    ){
        Column(modifier = Modifier.align(Alignment.Center)) {
            Text(text = "${dateDay.format(currentTime)}", color = White, modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 28.sp)
            Text(text = "${date.format(currentTime)}", color = White, modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 12.sp)
        }
    }
}