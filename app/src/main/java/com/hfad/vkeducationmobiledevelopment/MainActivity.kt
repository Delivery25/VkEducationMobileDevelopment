package com.hfad.vkeducationmobiledevelopment

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hfad.vkeducationmobiledevelopment.ui.theme.VkEducationMobileDevelopmentTheme
import androidx.core.net.toUri

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkEducationMobileDevelopmentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FirstScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun FirstScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = text,
            onValueChange = {
                text = it
            },

            label = { Text(stringResource(R.string.label_enter_text)) }
        )

        Button(
            onClick = {
                val intent = Intent(context, SecondActivity::class.java)
                intent.putExtra("text", text.trim())
                context.startActivity(intent)
            },

            modifier = Modifier.padding(top = 10.dp)
        )
        {
            Text(stringResource(R.string.button_open_second_activity))
        }

        Button(
            onClick = {
                if (!PhoneValidator.isValidPhone(text.trim())) {
                    Toast.makeText(context,
                        context.getString(R.string.toast_incorrect_phone_number), Toast.LENGTH_SHORT).show()
                } else {
                    val implicitIntent = Intent(Intent.ACTION_DIAL).apply {
                        data = "tel:$text".toUri()
                    }
                    if (implicitIntent.resolveActivity(context.packageManager) != null) {
                        context.startActivity(implicitIntent)
                    }
                    else {
                        Toast.makeText(context, "toast_no_suitable_application_for_this_action", Toast.LENGTH_SHORT).show()
                    }
                }
            },

            modifier = Modifier.padding(top = 10.dp)
        )
        {
            Text(stringResource(R.string.button_call_friend))
        }

        Button(
            onClick = {
                if (text.isEmpty()) {
                    Toast.makeText(context,
                        context.getString(R.string.toast_enter_text_in_field), Toast.LENGTH_SHORT).show()
                } else {
                    val implicitIntent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, text.trim())
                    }
                    if (implicitIntent.resolveActivity(context.packageManager) != null) {
                        context.startActivity(implicitIntent)
                    }
                    else {
                        Toast.makeText(context, "toast_no_suitable_application_for_this_action", Toast.LENGTH_SHORT).show()
                    }
                }
            },

            modifier = Modifier.padding(top = 10.dp)
        )
        {
            Text(stringResource(R.string.button_share_text))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    VkEducationMobileDevelopmentTheme {
        FirstScreen()
    }
}