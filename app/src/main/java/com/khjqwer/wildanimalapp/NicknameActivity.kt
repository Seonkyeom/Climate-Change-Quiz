package com.khjqwer.wildanimalapp

import android.content.Intent
import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khjqwer.wildanimalapp.ui.theme.WildAnimalAppTheme

class NicknameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()
        setContent {
            WildAnimalAppTheme {
                var text by remember { mutableStateOf(TextFieldValue()) }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Spacer(modifier = Modifier.height(170.dp))
                        TextField(
                            value = text,
                            onValueChange = { newValue ->
                                text = newValue
                            },
                            label = { Text("Enter your Nickname") },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(160.dp))
                        Text(
                            text = "Score" ,
                            fontSize = 45.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = ""+Session.score,
                            fontSize = 45.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.right_arrow),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 400.dp, start = 300.dp)
                            .clickable(
                                onClick = {
                                    viewModel.updateLeaderBoardRank(text.text, Session.score)
                                    val intent = Intent(this@NicknameActivity, HomeScreenActivity::class.java)
                                    startActivity(intent)
                                }
                            )
                            .size(70.dp)

                    )
                }
            }
        }
    }
}