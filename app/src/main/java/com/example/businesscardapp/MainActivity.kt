package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinesscardappTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinesscardappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    BusinessCard(
        androidLogo = painterResource(id = R.drawable.android_logo),
        fullName = stringResource(id = R.string.full_name),
        userRole = stringResource(id = R.string.user_role),
        userPhone = stringResource(id = R.string.user_phone) ,
        userSocialMediaHandle = stringResource(id = R.string.social_media_handle) ,
        userEmail = stringResource(id = R.string.user_email)
    )

}

@Composable
fun BusinessCard(
    androidLogo: Painter,
    fullName: String,
    userRole: String,
    userPhone: String,
    userSocialMediaHandle: String,
    userEmail: String,
    modifier: Modifier = Modifier

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.android_color)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .size(150.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .background(Color.Black),
                    painter = painterResource(id = R.drawable.android_logo),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.height(15.dp))
            Text(text = fullName, fontSize = 25.sp)
            Text(text = userRole, fontStyle = FontStyle.Italic, fontSize = 15.sp)
            
        }


        Column(modifier = Modifier) {
            Row(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
            ) {
                Icon(Icons.Rounded.Call, contentDescription = "Localized description")
                Text(text = userPhone, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 5.dp))
                
            }


            Row(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
            ) {
                Icon(Icons.Filled.Share, contentDescription = "Localized description")
                Text(text = userSocialMediaHandle, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 5.dp))

            }


            Row(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
            ) {
                Icon(Icons.Filled.Email, contentDescription = "Localized description")
                Text(text = userEmail, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 5.dp))

            }

        }


        
    }

}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinesscardappTheme {
        BusinessCardApp()

    }
}