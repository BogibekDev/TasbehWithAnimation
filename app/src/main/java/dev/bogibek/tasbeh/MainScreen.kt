package dev.bogibek.tasbeh

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen() {

    var count by remember {
        mutableIntStateOf(0)
    }
    var allCount by remember {
        mutableIntStateOf(0)
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                CircularProgressIndicator(
                    progress = { 1f },
                    color = Color.Gray, // Spinner color
                    strokeWidth = 6.dp, // Spinner stroke width
                    modifier = Modifier.size(200.dp) // Size of the spinner
                )

                CircularProgressIndicator(
                    progress = { count / 33f },
                    color = Color.Green, // Spinner color
                    strokeWidth = 6.dp, // Spinner stroke width
                    modifier = Modifier.size(200.dp) // Size of the spinner
                )

                Row {
                    AnimatedContent(
                        targetState = count/10,
                        label = "Onlar",
                        transitionSpec = {
                            slideInVertically(
                                animationSpec = tween(500),
                                initialOffsetY = { it }
                            ).togetherWith(slideOutVertically(
                                animationSpec = tween(500),
                                targetOffsetY = { -it }
                            ))
                        }
                    ) {
                        Text(
                            text = "${it}",
                            style = TextStyle(
                                fontSize = 100.sp,
                                fontFamily = FontFamily.SansSerif,
                                color = Color.White
                            )
                        )
                    }
                    AnimatedContent(
                        targetState = count,
                        label = "Timer",
                        transitionSpec = {
                            slideInVertically(
                                animationSpec = tween(500),
                                initialOffsetY = { it }
                            ).togetherWith(slideOutVertically(
                                animationSpec = tween(500),
                                targetOffsetY = { -it }
                            ))
                        }
                    ) {
                        Text(
                            text = "${it % 10}",
                            style = TextStyle(
                                fontSize = 100.sp,
                                fontFamily = FontFamily.SansSerif,
                                color = Color.White
                            )
                        )
                    }
                }

            }

            Text(
                "Jami : $allCount",
                style = TextStyle(
                    fontSize = 32.sp,
                    color = Color.White
                )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier
                        .size(200.dp)
                        .padding(16.dp),
                    shape = CircleShape,
                    onClick = {
                        if (count==33) count=0
                        count++
                        allCount++
                    },
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_1),
                        contentDescription = "Click",
                        modifier = Modifier.size(56.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }

        }

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreen()
}

