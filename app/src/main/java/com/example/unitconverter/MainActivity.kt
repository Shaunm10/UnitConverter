package com.example.unitconverter


import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {

    // state
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("") }
    var outputUnit by remember { mutableStateOf("") }
    var isInputExpanded by remember { mutableStateOf(false) }
    var isOutputExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(0.01) }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // in a Column, all the UI elements will be stacked below each other.
        Spacer(modifier = Modifier.height(16.dp))
        Text("Unit Converter ")

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                // Event handler code when value of the text is changed.
                inputValue = it
            },
            label = {Text("Enter Value")}
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            // we need a box because the drop down needs a parent
            Box {
                Button(onClick = {
                /*TODO*/
                    isInputExpanded = true
                }) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                    //Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow down")
                }
                DropdownMenu(
                    expanded = isInputExpanded,
                    onDismissRequest = {
                        isInputExpanded = false
                    }
                    ) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeter") },
                        onClick = {
                        isInputExpanded = false
                        inputUnit = "Centimeter"
                        conversionFactor.value = 0.01
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meters") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Milimeters") },
                        onClick = { /*TODO*/ }
                    )
                }
            }
            // we need a box because the drop down needs a parent
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                Button(onClick = {
                        isOutputExpanded = true
                    }) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")

                }
                DropdownMenu(expanded = isOutputExpanded, onDismissRequest = {
                    isOutputExpanded = false

                }) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeter") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meters") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Milimeters") },
                        onClick = { /*TODO*/ }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Result:")
    }
}


@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()

}
