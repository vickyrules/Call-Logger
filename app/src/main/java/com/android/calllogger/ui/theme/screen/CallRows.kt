package com.android.calllogger.ui.theme.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Divider
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.calllogger.R
import com.android.calllogger.data.Calls

@Composable
fun CallRows(items: List<Calls>, modifier: Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = 10.dp)
    ) {
        items(items = items) { item->
            CallItem(item = item)
        }
    }
}

@Composable
fun CallItem(item: Calls) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.padding(bottom = 15.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = item.to.toString(), modifier = Modifier.padding(all = 5.0.dp),style = MaterialTheme.typography.titleLarge)
            Box(
                modifier = Modifier.height(28.dp).clip(RoundedCornerShape(5.dp))
                    .background(Color.DarkGray),
                contentAlignment = Alignment.Center
            ) {
                Text(modifier = Modifier.padding(5.dp), text = item.type, color = Color.White)
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Date: ${item.dateTime} | ",style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Light))
            Text(text = "Dur: ${item.duration} s",style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Light))
        }


        Text(
            text = "From: ${item.from}",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Light)
        )

        Divider(modifier = Modifier.fillMaxWidth())

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            FilledIconButton(
                onClick = {},
                shape = RoundedCornerShape(10.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_mic_24),
                    contentDescription = "mic icon"
                )
            }
            Text(
                modifier = Modifier.weight(0.8f),
                text = "${item.callId.hashCode()}_${item.callId}${item.from}.mp3",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Light)
            )

            OutlinedButton(
                onClick = {},
                modifier = Modifier.size(40.0.dp),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(0.dp)
                ) {
                Icon(
                    modifier = Modifier.size(24.0.dp),
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = "mic icon",
                    tint = Color.Black
                )
            }
        }

    }
}

