package com.android.calllogger.ui.theme.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.calllogger.data.Calls
import com.android.calllogger.data.fakeData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CallLogsScreen(callsList:List<Calls>?) {

    Scaffold(
        topBar = { TopBar() },
        bottomBar = {
            Button(onClick = {}, modifier = Modifier.fillMaxWidth().padding(10.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Upload", style = MaterialTheme.typography.headlineMedium)
            }
        }

    )
    { innerPadding ->
        CallRows(fakeData, modifier = Modifier.padding(innerPadding))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    Column {
        TopAppBar(
            title = {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        text = "Call Logs",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = "Last Sync: 2023-09-12, 14:02:12",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = null)
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Refresh, contentDescription = null)
                }
            }
        )
        Divider(thickness = 2.dp)
    }
}