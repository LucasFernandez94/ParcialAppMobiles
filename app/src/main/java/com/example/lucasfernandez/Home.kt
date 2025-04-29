package com.istea.notepad

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lucasfernandez.Datos
import com.example.lucasfernandez.ui.theme.LucasFernandezTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController, montoRetiro: String, datos: Datos, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text("Recibo por retiro",  color =MaterialTheme.colorScheme.onPrimary)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .padding(top = 10.dp),

                text = "Retiro Exitoso",
                style = MaterialTheme.typography.titleLarge
            )
            Card(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Monto retirado $montoRetiro")
                }
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp).height(55.dp),
                onClick = {
                navController.popBackStack()
            }) {
                Text("Volver")
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    val datos = Datos().apply {
        motoRetiro = ""
        valorActual = 0
    }
    LucasFernandezTheme {
        HomeView(
            rememberNavController(),
            montoRetiro = "",
            datos
        )
    }
}