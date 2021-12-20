package ru.zapashnii.rickandmorty.utils

import android.content.Context
import ru.zapashnii.rickandmorty.di.ApplicationComponent
import ru.zapashnii.rickandmorty.di.MainApp

/**
 * Специальное расширение для получения AppComponent в любом месте, где у вас есть доступ к Context.
 * Позволяет избегать статического хранения ссылки на [Application] класс
 */
val Context.appComponent: ApplicationComponent
    get() = when (this) {
        is MainApp -> applicationComponent
        else -> applicationContext.appComponent
    }