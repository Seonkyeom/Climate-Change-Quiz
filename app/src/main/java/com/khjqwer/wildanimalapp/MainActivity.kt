package com.khjqwer.wildanimalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.khjqwer.wildanimalapp.ui.theme.WildAnimalAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WildAnimalAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Column {
                        var buttonClickCount by remember {
                            mutableStateOf(1)
                        }
                        var buttonClickForKyungminCount by remember {
                            mutableStateOf(5)
                        }
                        Text(
                            text = "Eric " + buttonClickCount,
                        )
                        Text(
                            text = "Hello Kyungmin!" + buttonClickForKyungminCount,
                        )

                        Button(
                            onClick = {
                                buttonClickCount = buttonClickCount + 1
                                buttonClickForKyungminCount = buttonClickForKyungminCount + 10
                            }
                        ) {
                            Text(
                                text = "Click me!!"
                            )
                        }

                        Image(
                            painter = painterResource(id = R.drawable.chameleon),
                            contentDescription = null,
                        )
                    }
                }
            }
        }
    }
}
