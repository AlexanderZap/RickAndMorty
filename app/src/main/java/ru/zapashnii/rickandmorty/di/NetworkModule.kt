package ru.zapashnii.rickandmorty.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.zapashnii.rickandmorty.BuildConfig
import ru.zapashnii.rickandmorty.network.Api
import ru.zapashnii.rickandmorty.network.MainInterceptor
import javax.inject.Singleton

/** Класс создания сетевых объектов */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun provideMainInterceptor(): MainInterceptor = MainInterceptor()

    @Provides
    @Singleton
    fun provideOkhttpClient(
        mainInterceptor: MainInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(mainInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideWeatherRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

    @Provides
    @Singleton
    fun provideWeatherApi(retrofit: Retrofit): Api =
        retrofit.create(Api::class.java)
}