import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lucasfernandez.Datos

@Composable
fun DetalleView(
    navController: NavController,
    datos : Datos,
    modifier: Modifier= Modifier
) {
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            Text(datos.titulo)
            Text(datos.texto)
        }
    }
}

@Composable
@Preview
fun DetallePreview(){
    val navController = rememberNavController()
    DetalleView(navController, datos = Datos("",""))
}