package com.example.evo.di

import com.example.evo.core.utils.Constants.BASE_URL
import com.example.evo.data.network.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor{
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .callTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)

        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun providesNetworkService(okHttpClient: OkHttpClient): NetworkService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(NetworkService::class.java)
    }

    @Singleton
    @Provides
    fun provideTheMovieApi(): NetworkService =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(provideJson().asConverterFactory("application/json".toMediaType()))
            .build()
            .create(NetworkService::class.java)

    @Singleton
    @Provides
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true // Highly recommended
        isLenient = true         // Can be helpful with slightly malformed JSON
        prettyPrint = false      // Good for production (smaller output); true for debugging
        coerceInputValues = true // If an API might send null for a non-nullable field with a default
    }
}