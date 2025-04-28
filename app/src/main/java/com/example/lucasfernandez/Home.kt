package com.istea.notepad

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
fun HomeView( navController: NavController, modifier: Modifier = Modifier, onAgregarDatos: (Datos) -> Unit) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text("Soy una TopBar")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {

            var titulo by remember { mutableStateOf("") }
            var texto by remember { mutableStateOf("") }
            Text("Ingresar titulo")
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = titulo,
                onValueChange = { texto ->
                    titulo = texto
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                modifier = Modifier.weight(1f).fillMaxWidth(),
                value = texto,
                label = {
                    Text("Ingresar Texto")
                },
                onValueChange = {
                    texto = it
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.popBackStack()
                    val nota = Datos(titulo = titulo, texto = texto)
                    onAgregarDatos(nota)
                },
                modifier = Modifier.align(Alignment.End)) {
                Text("Crear Nota")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    LucasFernandezTheme {
        HomeView(
            rememberNavController()
        ) { _ -> }
    }
}