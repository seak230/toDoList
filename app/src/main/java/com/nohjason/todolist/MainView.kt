package com.nohjason.todolist

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.nohjason.todolist.ui.theme.BackgoundGray
import com.nohjason.todolist.ui.theme.DisableDarkGray
import com.nohjason.todolist.ui.theme.DisableGray
import com.nohjason.todolist.ui.theme.PigmaBlue
import com.nohjason.todolist.ui.theme.White
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(){
    val currentTime : Long = System.currentTimeMillis() // ms로 반환
    var textState by rememberSaveable { mutableStateOf("") }

    Box(modifier = Modifier.background(PigmaBlue)){
        Column {
            Box(
                modifier = Modifier
                    .padding(27.dp)
                    .fillMaxWidth()
                    .height(170.dp),
            ){
                Image(
                    painter = painterResource(R.drawable.group_1),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
                Time(currentTime)
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BackgoundGray, shape = RoundedCornerShape(topStart = 70.dp))
            ){
                Column(modifier = Modifier.padding(40.dp)) {
                    Row {
                        Day(currentTime)
                        Spacer(modifier = Modifier.width(10.dp))
                        TextField(
                            value = textState,
                            onValueChange = {textState = it},
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Bottom)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    TodoList(textState = textState)
                }
            }
        }
    }
}