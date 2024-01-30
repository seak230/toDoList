package com.nohjason.todolist

import android.app.TimePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nohjason.todolist.ui.theme.BackgoundGray
import com.nohjason.todolist.ui.theme.White
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun Time(currentTime: Long){
    val dataFormat = SimpleDateFormat("LLL  yyyy", Locale.ENGLISH)
//    val dataFormat2 = SimpleDateFormat("yy-MM-dd-E") // 년(20XX) 월 일 요일
//    val dataFormat3 = SimpleDateFormat("hh:mm:ss") // 시(1~12) 분 초
//    val dataFormat4 = SimpleDateFormat("HH:mm:ss") // 시(0~23) 분 초
//    val dataFormat5 = SimpleDateFormat("현재시각은 \nyyyy-MM-dd \nhh:mm:ss")

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${dataFormat.format(currentTime)}", fontSize = 30.sp, color = White, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier
            .height(150.dp)
            .width(300.dp)
            .background(BackgoundGray, shape = RoundedCornerShape(10.dp))) {
            Text(text = "To-do List", modifier = Modifier.padding(10.dp), fontWeight = FontWeight.Bold, color = Color.Black)
        }
    }
}