package com.example.dutyplanner.core.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = DutyColors.GradientStart,
    onPrimary = Color.White,
    primaryContainer = DutyColors.GradientEnd,
    onPrimaryContainer = Color.White,
    secondary = DutyColors.MeetingPrimary,
    onSecondary = Color.White,
    tertiary = DutyColors.LeavePrimary,
    onTertiary = Color.White,
    background = DutyColors.Gray900,
    onBackground = Color.White,
    surface = DutyColors.Gray800,
    onSurface = Color.White,
    surfaceVariant = DutyColors.Gray700,
    onSurfaceVariant = DutyColors.Gray300,
    error = DutyColors.Error,
    onError = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = DutyColors.GradientStart,
    onPrimary = Color.White,
    primaryContainer = DutyColors.GradientEnd.copy(alpha = 0.1f),
    onPrimaryContainer = DutyColors.GradientEnd,
    secondary = DutyColors.MeetingPrimary,
    onSecondary = Color.White,
    tertiary = DutyColors.LeavePrimary,
    onTertiary = Color.White,
    background = Color.White,
    onBackground = DutyColors.Gray900,
    surface = Color.White,
    onSurface = DutyColors.Gray900,
    surfaceVariant = DutyColors.Gray100,
    onSurfaceVariant = DutyColors.Gray600,
    error = DutyColors.Error,
    onError = Color.White
)

@Composable
fun DutyListTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = DutyTypography,
        content = content
    )
}
