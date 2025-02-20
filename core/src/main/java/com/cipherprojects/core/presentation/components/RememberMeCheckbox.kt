package com.cipherprojects.core.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RememberMeCheckbox(
    modifier: Modifier = Modifier,
    rememberMe: Boolean,
    toggleRememberMe: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 8.dp, bottom = 4.dp, top = 4.dp)
            .clickable { toggleRememberMe() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = rememberMe,
            onCheckedChange = { toggleRememberMe() },
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.primary,
                uncheckedColor = MaterialTheme.colorScheme.secondary
            )
        )
        Text(
            text = "Remember me",
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            color = when (rememberMe) {
                true -> MaterialTheme.colorScheme.primary
                false -> MaterialTheme.colorScheme.secondary
            },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}