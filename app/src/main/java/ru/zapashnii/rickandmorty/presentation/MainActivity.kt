package ru.zapashnii.rickandmorty.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import ru.zapashnii.rickandmorty.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}