plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    // safe args
    id("androidx.navigation.safeargs") version "2.8.9" apply false
}