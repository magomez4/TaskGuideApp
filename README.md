# TaskGuideApp
Application to help seniors use their phones!

To re-build this app:
- App was developed using Android Studio Version 2020.3.1 Patch 3
- Tested on Pixel_3_a emulator running Android 11.0 with API 30. 
- All tests were performed on a Samsung Galaxy Note 10 Plus running Android 11 and OneUI 3.1
- Built_APK folder contains pre-built APK file that can be directly installed in a compatible Android phone
- build.gradle module file contained the following targets at the time of building:
android {
    compileSdk 30

    defaultConfig {
        applicationId "com.example.taskguide"
        minSdk 30
        targetSdk 30
        versionCode 1
        versionName "1.0"
        targetSdkVersion 30
        minSdkVersion 30

    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
    }
}

