package com.mindrebuild.ui.inbox

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * صفحه صندوق ورودی (تخلیه ذهن)
 * طبق مشخصات FINAL_SPEC.md و INBOX.md
 */
@Composable
fun InboxScreen(
    onBack: () -> Unit = {}
) {
    var inputText by remember { mutableStateOf("") }
    // در نسخه واقعی این لیست از Room می‌آید
    val items = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // هدر
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = onBack) {
                Text("بازگشت")
            }
            Text(
                text = "تخلیه ذهن",
                style = MaterialTheme.typography.headlineSmall
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ورودی سریع
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "هر چیزی که در ذهنت هست را بنویس...",
                    textAlign = TextAlign.Right,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            minLines = 3
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (inputText.isNotBlank()) {
                    items.add(0, inputText)
                    inputText = ""
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("ثبت")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // لیست آیتم‌ها
        if (items.isEmpty()) {
            Text(
                text = "ذهنت الان خلوت است. هر وقت چیزی آمد، اینجا بنویس.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            )
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items) { item ->
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = item,
                            modifier = Modifier.padding(16.dp),
                            textAlign = TextAlign.Right
                        )
                    }
                }
            }
        }
    }
}
