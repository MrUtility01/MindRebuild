package com.mindrebuild.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * صفحه خانه (امروز)
 * طبق مشخصات FINAL_SPEC.md
 */
@Composable
fun HomeScreen(
    onNavigateToInbox: () -> Unit = {},
    onNavigateToLearning: () -> Unit = {},
    onNavigateToTasks: () -> Unit = {},
    onNavigateToJournal: () -> Unit = {},
    onNavigateToReports: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // هدر با تاریخ شمسی
        Text(
            text = "امروز",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Right
        )

        Spacer(modifier = Modifier.height(8.dp))

        // جمله انگیزشی (نمونه)
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Text(
                text = "هر روز فرصت تازه‌ای برای شروع دوباره است.",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Right
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // دکمه اصلی تخلیه ذهن
        Button(
            onClick = onNavigateToInbox,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("ذهنم را خالی کن")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // بخش یادگیری فعال
        Text(
            text = "یادگیری فعال",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Right
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "هنوز موضوع فعالی نداری",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Right,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedButton(
                    onClick = onNavigateToLearning,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("شروع موضوع جدید")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // کارهای امروز
        Text(
            text = "کارهای امروز",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Right
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(
                text = "هیچ کاری برای امروز ثبت نشده",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Right
            )
        }
    }
}
