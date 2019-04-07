# BaseAndroidProject
As you all may know, starting an android project is really a pain, you need to setup ```dagger```,```flavors```, ```dependencies```, configure several ```libraries``` sacrifice a goat and two kittens as the meme says. 

This repository aims to help developers start a new android project and for that its packed with the new and lastest ```android architecture components``` aka JetPack using the following libraries

    -> Room database
    -> LiveData
    -> Paging Library (Loading partial data on demand reduces usage of network bandwidth and system resources)
    -> Kotlin
    -> RxKotlin
    -> Dagger2 for dependency injection
    -> OkHttp3
    -> Retrofit2
    -> ViewModels
    -> MVVM (Model-View-ViewModel)
    ...


This project also offers you: ```Google standard package namings and placements```and a ```Core Project full of real world professional utilities methods.```

Using dagger may be confusing to some android beginners so this base project puts all the Dagger configuration at place and also offers 

    -> A simple view model injection example ( A viewModel is injected in an Activity and in a Fragment)
    -> A simple Injection on retrofit providers
    -> A simple Injection on Repositories providers
    -> A simple Injection on Database providers

```How to begin?```
Just create your applications,fragments and viewModels and make shure you put them on your DI Modules of the app.
