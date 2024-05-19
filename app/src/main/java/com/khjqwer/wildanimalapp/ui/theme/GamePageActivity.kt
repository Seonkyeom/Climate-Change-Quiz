package com.khjqwer.wildanimalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khjqwer.wildanimalapp.ui.theme.WildAnimalAppTheme


class GamePageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WildAnimalAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(40.dp),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Column {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.home_botton),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)

                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Image(
                                painter = painterResource(id = R.drawable.pass),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)
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
                                    text = "000",
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
                        Image(
                            painter = painterResource(id = R.drawable.right_arrow),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 200.dp, start = 200.dp)
                                .size(50.dp)
                        )
                    }
                }
            }

        }
    }
}