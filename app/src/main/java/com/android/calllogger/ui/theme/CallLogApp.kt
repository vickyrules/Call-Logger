package com.android.calllogger.ui.theme

import androidx.compose.runtime.Composable
import com.android.calllogger.data.fakeData
import com.android.calllogger.ui.theme.screen.CallLogsScreen

@Composable
fun CallLogApp() {
    CallLogsScreen(callsList = fakeData )
}