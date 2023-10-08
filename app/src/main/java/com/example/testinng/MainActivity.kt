package com.example.testinng

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testinng.ui.theme.TestinngTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestinngTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                   GreetingPreview()
                }
            }
        }
    }
}

@Preview(showBackground = true ,
    showSystemUi = true ,
    name = "My preview" ,
    backgroundColor = 0x121328)
@Composable
fun GreetingPreview(modifier : Modifier = Modifier) {
    TestinngTheme {
        Column (verticalArrangement = Arrangement.Center , modifier = Modifier.fillMaxSize().background(color = Color.Black)) {
            AndroidImage(fullName = "Kevin Julio", role = "Android Developer")
            ContactInfo(info1 = "0813-9999-8888", info2 = "@kevinjuliow", info3 = "kevjuliow@gmail.com")
        }
    }
}

@Composable
fun AndroidImage (fullName : String , role : String , modifier : Modifier = Modifier){
    val image = painterResource(R.drawable.android_logo)
    Column (modifier = modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Image(
            modifier = Modifier
                .size(200.dp, 200.dp)
                .offset(y = 24.dp)
                .fillMaxWidth(),
            painter = image,
            contentDescription = null,
            alpha = 0.8F //Opacity Image
        )
        ProfileText(fullName = fullName, role = role)
    }
}

@Composable
fun ProfileText(fullName: String , role: String ,  modifier: Modifier = Modifier) {
    Column ( horizontalAlignment = Alignment.CenterHorizontally , modifier = Modifier.fillMaxWidth() ){
        Text(text = fullName,
            fontSize = 24.sp , color = Color.White )

        Text(text = role ,
            color =  Color.Gray ,
            modifier = Modifier
                .padding(start = 16.dp,
                    end = 16.dp
                ))
            }

}

@Composable
fun ContactInfo (info1 : String , info2:String , info3:String , modifier : Modifier = Modifier){
    val image1 = painterResource(R.drawable.baseline_call_white_24dp)
    val image2 = painterResource(R.drawable.baseline_share_white_24dp)
    val image3 = painterResource(R.drawable.baseline_mail_outline_white_24dp)
    Column (horizontalAlignment = Alignment.CenterHorizontally  ,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 140.dp)){
        Row {
            Image(
                painter = image1,
                contentDescription = null,
                Modifier.size(18.dp , 18.dp)
            )
            Text(text = info1 , color = Color.LightGray)
        }
        Row {
            Image(
                painter = image2,
                contentDescription = null,
                Modifier.size(18.dp , 18.dp)
            )
            Text(text = info2 , color = Color.LightGray)
        }
        Row {
            Image(
                painter = image3,
                contentDescription = null,
                Modifier.size(18.dp , 18.dp)
            )
            Text(text = info3 , color = Color.LightGray)
        }
    }
}
