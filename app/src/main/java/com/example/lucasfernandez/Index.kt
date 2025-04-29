package com.example.lucasfernandez

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lucasfernandez.ui.theme.LucasFernandezTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IndexView(navController: NavController, datos: Datos, modifier: Modifier = Modifier) {

    var retiroInput by remember { mutableStateOf(datos.motoRetiro) }
    var valorActual by remember { mutableStateOf(datos.valorActual) }
    if (valorActual <= 0){
        valorActual = datos.valorInicial
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text("Mi Bialletera virtual", color =MaterialTheme.colorScheme.onPrimary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary

                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Dinero Total en cuenta:",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(text = "$valorActual",
                style = MaterialTheme.typography.headlineMedium,
                modifier = modifier.padding(bottom = 16.dp))

            Text("Ingrese monto a retirar", modifier = Modifier.align(Alignment.Start))

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                value = retiroInput,
                onValueChange = { retiroInput = it },
                shape = MaterialTheme.shapes.medium,
                singleLine = true
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp).height(55.dp),
                onClick = {
                    val monto = retiroInput.toIntOrNull()
                    if (monto != null && monto <= valorActual) {
                        valorActual -= monto
                        val montoRetiro = retiroInput
                        retiroInput = ""

                        datos.valorActual = valorActual
                        datos.motoRetiro = montoRetiro

                        navController.navigate("Home/$montoRetiro")
                    }
                }
            ) {
                Text(text="Retirar", style = MaterialTheme.typography.titleLarge )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    val datos = Datos()
    LucasFernandezTheme {
        IndexView(
            rememberNavController(),
            datos
        )
    }
}
