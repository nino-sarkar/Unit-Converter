package sarkar.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sarkar.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Surface {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text("Unit Converter",
            fontSize = 30.sp)

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Enter length") })

        Spacer(modifier = Modifier.height(25.dp))

        Row {
            Button(onClick = {}) {
                Text("Select")
                Icon(Icons.Default.ArrowDropDown,
                    contentDescription = "drop down arrow")
            }

            Spacer(modifier = Modifier.width(25.dp))

            Button(onClick = {}) {
                Text("Select")
                Icon(
                    Icons.Default.ArrowDropDown,
                    contentDescription = "drop down arrow"
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text("Result:",
            fontSize = 30.sp)
    }
}

@Composable
@Preview(showBackground = true)
fun UnitConverterPreview() {
    UnitConverter()
}