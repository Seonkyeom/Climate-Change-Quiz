package com.khjqwer.wildanimalapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khjqwer.wildanimalapp.ui.theme.WildAnimalAppTheme


class GamePageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()
        setContent {
            WildAnimalAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(40.dp),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.home_botton),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(50.dp)
                                    .clickable {
                                        val intent = Intent(
                                            this@GamePageActivity,
                                            NicknameActivity::class.java
                                        )
                                        startActivity(intent)
                                    }
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Image(
                                painter = painterResource(id = R.drawable.pass),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(50.dp)
                                    .clickable {
                                        val intent = Intent(
                                            this@GamePageActivity,
                                            WrongPageActivity::class.java
                                        )
                                        startActivity(intent)
                                    }
                                )
                            Spacer(modifier = Modifier.width(80.dp))
                            val colorFromHex = Color(android.graphics.Color.parseColor("#71eeeb"))
                            Box(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(50.dp)
                                    .background(color = colorFromHex),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "0",
                                    color = Color.Black,
                                    fontSize = 20.sp
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(60.dp))
                        Text(
                            "which of following is greenhouse gas(GHG)?",
                            fontSize = 30.sp,
                            lineHeight = 40.sp
                        )
                        Spacer(modifier = Modifier.height(60.dp))
                        var selectedAnswer by remember { mutableStateOf(-1) }
                        Text(
                            text = "CO2",
                            fontSize = 25.sp,
                            color = if (selectedAnswer == 0) {
                                Color.Green
                            } else {
                                Color.Black
                            },
                            modifier = Modifier.clickable(
                                onClick = {
                                    selectedAnswer = 0
                                }
                            )
                        )
                        Text(
                            text = "CH4",
                            fontSize = 25.sp,
                            color = if (selectedAnswer == 1) {
                                Color.Green
                            } else {
                                Color.Black
                            },
                            modifier = Modifier.clickable(
                                onClick = {
                                    selectedAnswer = 1
                                }
                            )
                        )
                        Text(
                            text = "Water Vapor",
                            fontSize = 25.sp,
                            color = if (selectedAnswer == 2) {
                                Color.Green
                            } else {
                                Color.Black
                            },
                            modifier = Modifier.clickable(
                                onClick = {
                                    selectedAnswer = 2
                                }
                            )
                        )
                        Text(
                            text = "All of the above",
                            fontSize = 25.sp,
                            color = if (selectedAnswer == 3) {
                                Color.Green
                            } else {
                                Color.Black
                            },
                            modifier = Modifier.clickable(
                                onClick = {
                                    selectedAnswer = 3
                                }
                            )
                        )


                        Image(
                            painter = painterResource(id = R.drawable.right_arrow),
                            contentDescription = null,
                            modifier = Modifier
                                .align(alignment = Alignment.End)
                                .size(50.dp)
                                .clickable {
                                    if  (selectedAnswer != -1) {
                                        Session.questionsAnsweredCount = Session.questionsAnsweredCount + 1
                                        val intent = Intent(this@GamePageActivity, WrongPageActivity::class.java)
                                        startActivity(intent)
                                    }
                                }
                        )
                    }
                }
            }
        }
    }
}