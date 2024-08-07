package com.khjqwer.wildanimalapp

import android.content.Intent
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.khjqwer.wildanimalapp.ui.theme.WildAnimalAppTheme

class WrongPageActivity : ComponentActivity() {
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
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Spacer(modifier = Modifier.height(50.dp))
                        Image(
                            painter = painterResource(id = R.drawable.delete_button),
                            contentDescription = null,
                        )
                        Spacer(modifier = Modifier.height(50.dp))
                        Text(
                            text = Session.currentQuestion.explanation
                        )
                        Image(
                            painter = painterResource(id = R.drawable.right_arrow),
                            contentDescription = null,
                            modifier = Modifier
//                                .padding(top = 400.dp, start = 300.dp)
                                .clickable(
                                    onClick = {
                                        Session.currentQuestionIndex += 1
                                        if (Session.currentQuestionIndex == 2) {
                                            val intent = Intent(this@WrongPageActivity, NicknameActivity::class.java)
                                            startActivity(intent)
                                        }
                                        else{
                                            val intent = Intent(this@WrongPageActivity, GamePageActivity::class.java)
                                            startActivity(intent)
                                        }

                                    }
                                )
                                .size(70.dp)

                        )
                    }
                }
            }
        }
    }
}
