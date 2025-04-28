package com.example.lucasfernandez

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lucasfernandez.ui.theme.LucasFernandezTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IndexView(navController : NavController,listaDeDatos: List<Datos> ,modifier : Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("Home")
            }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Agregar")
            }
        },
        topBar = {
            TopAppBar(
                title = { Text("Nav Bar") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }

    ) { paddind ->
        LazyColumn(
            modifier = Modifier.padding(paddind),
            contentPadding = PaddingValues(15.dp)
        ) {
            items(listaDeDatos) {
                ElevatedCard(
                    modifier = Modifier.fillMaxWidth()
                        .clickable(onClick = {
                            navController.navigate("detalle")
                        })
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(horizontal = 15.dp)
                                .padding(top = 10.dp),
                            text = it.titulo,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            modifier = Modifier
                                .padding(horizontal = 15.dp)
                                .padding(bottom = 10.dp),
                            text = it.texto,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Spacer(modifier.height(8.dp))
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun Preview() {
    var listaDeDatos = listOf<Datos>()
    LucasFernandezTheme {
        IndexView(
            rememberNavController(),
            listaDeDatos
        )
    }
}