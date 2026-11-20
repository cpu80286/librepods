/*
    LibrePods - AirPods liberated from Apple’s ecosystem
    Copyright (C) 2025 LibrePods contributors

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

package me.kavishdevar.librepods.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

val ColorScheme.sectionHeader: Color
    get() = onBackground.copy(alpha = 0.6f)

private val AppleDarkColorScheme = darkColorScheme(
    surfaceContainer = Color(0xFF000000), // for some reason background is not used as the background in gmail and settings app, but surfacecontainer, so using that
    onBackground = Color(0xFFFFFFFF),
    surface = Color(0xFF1C1C1E),
    onSurface = Color(0xFFFFFFFF),
    surfaceDim = Color(0x40888888),
    primary = Color(0xFF0091FF),
    secondaryContainer = Color(0xFF366AA8),
    onSecondaryContainer = Color(0xFF0091FF),
    onPrimary = Color(0xFFFFFFFF)
)

private val AppleLightColorScheme = lightColorScheme(
    surfaceContainer = Color(0xFFF2F2F7),
    onBackground = Color(0xFF000000),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF000000),
    surfaceDim = Color(0x40D9D9D9),
    secondaryContainer = Color(0xFF6BC0FF),
    onSecondaryContainer = Color(0xFF0088FF),
    primary = Color(0xFF0088FF),
    onPrimary = Color(0xFFFFFFFF)
)


private val OneUiLightColorScheme = lightColorScheme(
    primary = Color(0xFF1A5FC7),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFD8E5FF),
    onPrimaryContainer = Color(0xFF001B3D),
    secondary = Color(0xFF52617A),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFDCE5F5),
    onSecondaryContainer = Color(0xFF101C2D),
    background = Color(0xFFF5F6FA),
    onBackground = Color(0xFF191C22),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF191C22),
    surfaceVariant = Color(0xFFE1E5ED),
    onSurfaceVariant = Color(0xFF434A55),
    surfaceContainerLowest = Color(0xFFFFFFFF),
    surfaceContainerLow = Color(0xFFF8F9FC),
    surfaceContainer = Color(0xFFF0F2F7),
    surfaceContainerHigh = Color(0xFFE9ECF3),
    surfaceContainerHighest = Color(0xFFE1E5ED),
    outline = Color(0xFF737985),
    outlineVariant = Color(0xFFC3C8D2)
)

private val OneUiDarkColorScheme = darkColorScheme(
    primary = Color(0xFFA8C7FA),
    onPrimary = Color(0xFF062E69),
    primaryContainer = Color(0xFF174A8B),
    onPrimaryContainer = Color(0xFFD6E3FF),
    secondary = Color(0xFFB9C7DF),
    onSecondary = Color(0xFF263141),
    secondaryContainer = Color(0xFF293B56),
    onSecondaryContainer = Color(0xFFD9E5FA),
    background = Color(0xFF111318),
    onBackground = Color(0xFFE2E2E9),
    surface = Color(0xFF191B20),
    onSurface = Color(0xFFE2E2E9),
    surfaceVariant = Color(0xFF424750),
    onSurfaceVariant = Color(0xFFC2C7D0),
    surfaceContainerLowest = Color(0xFF0C0E12),
    surfaceContainerLow = Color(0xFF17191E),
    surfaceContainer = Color(0xFF20232A),
    surfaceContainerHigh = Color(0xFF2A2D34),
    surfaceContainerHighest = Color(0xFF353840),
    outline = Color(0xFF8C919B),
    outlineVariant = Color(0xFF424750)
)
@Composable
fun LibrePodsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    m3eEnabled: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        m3eEnabled -> if (darkTheme) OneUiDarkColorScheme else OneUiLightColorScheme
        darkTheme -> AppleDarkColorScheme
        else -> AppleLightColorScheme
    }

    CompositionLocalProvider(
        LocalDesignSystem provides
            if (m3eEnabled) DesignSystem.Material
            else DesignSystem.Apple
    ) {
        MaterialExpressiveTheme(
            colorScheme = colorScheme,
            motionScheme = MotionScheme.expressive(),
            typography = if (m3eEnabled) MaterialTypography else AppleTypography,
            content = content
        )
    }
}
