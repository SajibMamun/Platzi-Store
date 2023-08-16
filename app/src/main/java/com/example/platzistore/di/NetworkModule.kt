package com.example.platzistore.di

import com.example.platzistore.network.AuthService
import com.example.platzistore.utils.AuthInterceptor
import com.example.platzistore.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    //httpclient obejct return then go to retrofit builder
fun provideHttpClient(interceptor: AuthInterceptor):OkHttpClient{
    val client= OkHttpClient.Builder().addInterceptor(interceptor).build()
    return client
}


    @Provides
    @Singleton
    fun provideRetrofit():Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

    }

    @Provides
    @Singleton
    fun ProvideAuthService(retrofit: Retrofit.Builder):AuthService {
        return retrofit.build().create(AuthService::class.java)

    }

        @Provides
        @Singleton
        fun provideUserService(retrofit: Retrofit.Builder,client: OkHttpClient):AuthService{
            return retrofit.client(client).build().create(AuthService::class.java)


    }
}