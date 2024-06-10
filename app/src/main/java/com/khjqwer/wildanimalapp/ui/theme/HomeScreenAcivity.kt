package com.khjqwer.wildanimalapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khjqwer.wildanimalapp.ui.theme.WildAnimalAppTheme


class HomeScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WildAnimalAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                            ){
                        Text(
                            "Climate Change Quiz",
                            fontWeight = FontWeight.Bold,
                            fontSize = 50.sp,
                            lineHeight = 43.sp,
                            modifier = Modifier
                                ,

                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(70.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ranking),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(80.dp)
                            )
                            Text(
                                "Ranking",
                                fontSize = 50.sp,
                            )

                        }
                        for (i in 1..5) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                if (i == 1) {
                                    Image(
                                        painter = painterResource(id = R.drawable.golden_medal),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(45.dp)
                                            .weight(1f),
                                    )
                                } else if (i == 2) {
                                    Image(
                                        painter = painterResource(id = R.drawable.silver_medal),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(45.dp)
                                            .weight(1f),
                                    )
                                } else if (i == 3){
                                    Image(
                                        painter = painterResource(id = R.drawable.bronze_medal),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(45.dp)
                                            .weight(1f),
                                    )
                                } else{
                                    Spacer(modifier = Modifier
                                        .width(45.dp)
                                        .height(45.dp)
                                        .weight(1f)
                                    )
                                }

                                Text(
                                    text = "Item $i-2",
                                    modifier = Modifier.weight(1f)
                                )
                                Text(
                                    text = "Item $i-3",
                                    modifier = Modifier.weight(1f)
                                )
                            }
                            Divider(color = Color.Gray)
                        }
                        Image(
                            painter = painterResource(id = R.drawable.start),
                            contentDescription = null,
                            modifier = Modifier
                                .clickable(
                                        onClick = {
                                            Session.questionsAnsweredCount = 0
                                            val intent = Intent(this@HomeScreenActivity, GamePageActivity::class.java)
                                            startActivity(intent)
                                        }
                                    )
                        )

                    }
                }
            }
        }
    }
}