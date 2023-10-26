package com.example.limonada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.limonada.ui.theme.LimonadaTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimonadaTheme {

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppLimonada() {
    var tela by remember { mutableStateOf(1) }
    var idImagem = 1
    var idString = 1
    var onClickImage : () -> Unit = {}
    var qtdClick  by remember { mutableStateOf(1) }

    when (tela) {
        1 -> {
            idImagem = R.drawable.limoeiro
            idString = R.string.limoeiro
            onClickImage = {
                tela=2
                qtdClick = (2..4).random()
            }
        }

        2 -> {
            idImagem = R.drawable.espremer
            idString = R.string.limao
            onClickImage = {
            if(qtdClick >1 && qtdClick<5)
                qtdClick--
                else
                tela=3
            }
        }

        3 -> {
            idImagem = R.drawable.limonada_drink
            idString = R.string.limonada
            onClickImage = {
                tela=4
            }
        }

        4 -> {
            idImagem = R.drawable.copovazio
            idString = R.string.copovazio
            onClickImage = {
                tela=1
            }
        }
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = idImagem),
            contentDescription = null,
            modifier = Modifier.clickable (onClick = onClickImage)
            )
        Text(
            text = stringResource(id = idString) + qtdClick
        )
    }
}