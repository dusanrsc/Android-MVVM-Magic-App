package com.example.mvvm_retrofit_magicapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvm_retrofit_magicapp.ui.theme.DefaultAppBackgroundColor
import com.example.mvvm_retrofit_magicapp.ui.theme.DefaultFontColor
import com.example.mvvm_retrofit_magicapp.viewmodel.HarryPotterViewModel

@Composable
fun View(modifier: Modifier = Modifier) {
    val harryPotterViewModel: HarryPotterViewModel = viewModel()
    val harryPotterData by harryPotterViewModel.harryPotterData.observeAsState(initial = "")
    var allowDataDisplay by remember { mutableStateOf(value = false) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(DefaultAppBackgroundColor)
        .padding(all = 16.dp)
        .verticalScroll(state = rememberScrollState())
        .clickable(onClick = { allowDataDisplay = !allowDataDisplay }),
        contentAlignment = Alignment.Center
    ) {
        if (allowDataDisplay) {
            SelectionContainer {
                Text(text = harryPotterData, fontSize = 20.sp, color = DefaultFontColor)
            }
        } else {
            Text(text = "Click Anywhere On The Screen To Display Raw Data!", fontSize = 15.sp, color = Color.Blue)
        }
    }
}