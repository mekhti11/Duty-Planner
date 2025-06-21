package com.example.dutyplanner.core.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun EmptyState(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Filled.List,
    actionButton: @Composable (() -> Unit)? = null
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Icon container
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                modifier = Modifier.size(32.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Title
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Medium
            ),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
            textAlign = TextAlign.Center
        )

        // Subtitle
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp, start = 32.dp, end = 32.dp)
        )

        // Optional action button
        actionButton?.let {
            Spacer(modifier = Modifier.height(24.dp))
            it()
        }
    }
}

@Preview(
    name = "Empty State - Light",
    showBackground = true
)
@Composable
private fun EmptyStatePreview() {
    MaterialTheme {
        EmptyState(
            title = "No duties for this day",
            subtitle = "Tap + to add a new duty"
        )
    }
}

@Preview(
    name = "Empty State - Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun EmptyStateDarkPreview() {
    MaterialTheme {
        EmptyState(
            title = "No duties for this day",
            subtitle = "Tap + to add a new duty"
        )
    }
}

@Preview(
    name = "Empty State with Action",
    showBackground = true
)
@Composable
private fun EmptyStateWithActionPreview() {
    MaterialTheme {
        EmptyState(
            title = "No duties scheduled",
            subtitle = "Start by creating your first duty to organize your schedule",
            actionButton = {
                Button(onClick = { }) {
                    Text("Add First Duty")
                }
            }
        )
    }
}