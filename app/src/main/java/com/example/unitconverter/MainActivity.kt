package com.example.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
fun UnitConverter(){
    Column {
            // in a Column, all the UI elements will be stacked below each other.
        Text("Unit Converter ")
        OutlinedTextField(value = "", onValueChange ={
            val myText = it
            // Event handler code when value of the text is changed.
        } )
        Row {
            val context = LocalContext.current
            // in a Row, all the UI elements will be stacked next to each other.
           Button(onClick = {

                Toast.makeText(context,
                    "I was clicked",
                    Toast.LENGTH_SHORT).show()

           }) {
               Text(text = "MyButton")
           }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()

}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    UnitConverterTheme {
//        UnitConverter()
//    }
//}