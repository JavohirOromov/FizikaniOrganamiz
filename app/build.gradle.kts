
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // safe args
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.fizikaniorganamiz"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.fizikaniorganamiz"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.room.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // ViewBinding Krich Javohir Oromov
    implementation(libs.viewbindingpropertydelegate)

    // ViewModel Javohir Oromov
    implementation (libs.androidx.fragment.ktx)
    implementation (libs.androidx.lifecycle.extensions)

    // Lottie animation Javohir Oromov
    implementation (libs.lottie)

    // circle ImageView Javohir Oromov
    implementation (libs.circleimageview)

    // Navigation Component Javohir Oromov
    implementation( libs.androidx.navigation.fragment.ktx.v276)
    implementation (libs.androidx.navigation.ui.ktx.v276)

    // dotsIndicator Javohir Oromov
    implementation(libs.dotsindicator)

}