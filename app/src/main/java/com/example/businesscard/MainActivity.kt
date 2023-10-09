package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        name = stringResource(R.string.natsucamellia),
                        description = stringResource(R.string.an_android_developer),
                        phone = stringResource(R.string.phone),
                        email = stringResource(R.string.email),
                        website = stringResource(R.string.website)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, description: String, phone: String, email:String, website: String, modifier: Modifier = Modifier) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
        ) {
            About(
                image = painterResource(id = R.drawable.avatar),
                name = name,
                description = description,
                modifier = Modifier
                    .padding(top = 100.dp, bottom = 200.dp)
            )
            Contact(
                phone = phone,
                email = email,
                website = website
            )
        }
    }
}

@Composable
fun About(image: Painter, name: String, description: String, modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
        )
        Text(
            text = name,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 16.dp)
        )
        Text(
            text = description,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun Contact(phone: String, email: String, website: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        ContactItem(
            icon = Icons.Outlined.Call,
            content = phone,
            modifier = Modifier.padding(top = 16.dp)
        )
        ContactItem(
            icon = Icons.Outlined.Email,
            content = email,
            modifier = Modifier.padding(top = 16.dp)
        )
        ContactItem(icon = Icons.Outlined.Home,
            content = website,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Composable
fun ContactItem(icon: ImageVector, content: String, modifier: Modifier = Modifier) {
    Row (modifier = modifier) {
        Icon(
            imageVector = icon,
            contentDescription = null
        )
        Text(
            text = content,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(start = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard(
            name = stringResource(R.string.natsucamellia),
            description = stringResource(R.string.an_android_developer),
            phone = stringResource(R.string.phone),
            email = stringResource(R.string.email),
            website = stringResource(R.string.website)
        )
    }
}