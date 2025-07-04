package sarkar.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

    var inputUnit by remember { mutableStateOf("Meter") }
    var outputUnit by remember { mutableStateOf("Meter") }

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("0.0") }

    var iExpand by remember { mutableStateOf(false) }
    var oExpand by remember { mutableStateOf(false) }

    var iFactor by remember { mutableDoubleStateOf(1.0) }
    var oFactor by remember { mutableDoubleStateOf(1.0) }

    fun convert() {
        outputValue = ((inputValue.toDoubleOrNull() ?: 0.0) * iFactor / oFactor).toFloat().toString()
        iExpand = false
        oExpand = false
    }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text("Unit Converter",
            fontSize = 30.sp)

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            label = { Text("Enter length") })

        Spacer(modifier = Modifier.height(25.dp))

        Row {
            Box {
                Button(onClick = { iExpand = true }) {
                    Text(inputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "drop down arrow"
                    )
                }

                DropdownMenu(
                    expanded = iExpand,
                    onDismissRequest = { iExpand = false }
                ) {

                    DropdownMenuItem(
                        text = { Text("Meter")},
                        onClick = {
                            inputUnit = "Meter"
                            iFactor = 1.0
                            convert()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Centimeter")},
                        onClick = {
                            inputUnit = "Centimeter"
                            iFactor = 0.01
                            convert()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Feet")},
                        onClick = {
                            inputUnit = "Feet"
                            iFactor = 0.3048
                            convert()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Millimeter")},
                        onClick = {
                            inputUnit = "Millimeter"
                            iFactor = 0.001
                            convert()
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.width(25.dp))

            Box {
                Button(onClick = { oExpand = true }) {
                    Text(outputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "drop down arrow"
                    )
                }

                DropdownMenu(
                    expanded = oExpand,
                    onDismissRequest = { oExpand = false }
                ) {

                    DropdownMenuItem(
                        text = { Text("Meter")},
                        onClick = {
                            outputUnit = "Meter"
                            oFactor = 1.0
                            convert()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Centimeter")},
                        onClick = {
                            outputUnit = "Centimeter"
                            oFactor = 0.01
                            convert()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Feet")},
                        onClick = {
                            outputUnit = "Feet"
                            oFactor = 0.3048
                            convert()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Millimeter")},
                        onClick = {
                            outputUnit = "Millimeter"
                            oFactor = 0.001
                            convert()
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text("Result: $outputValue $outputUnit",
            fontSize = 30.sp)
    }
}

@Composable
@Preview(showBackground = true)
fun UnitConverterPreview() {
    UnitConverter()
}