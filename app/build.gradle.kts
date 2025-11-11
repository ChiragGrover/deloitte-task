plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.deloitte.deloittetask"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.deloitte.deloittetask"
        minSdk = 29
        targetSdk = 36
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
    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            excludes += setOf(
                "META-INF/LICENSE.md",
                "META-INF/LICENSE.txt",
                "META-INF/LICENSE-notice.md",
                "META-INF/NOTICE.txt",
                "META-INF/NOTICE.md",
                "META-INF/LICENSE",
                "META-INF/NOTICE",
                "META-INF/DEPENDENCIES"
            )
        }
    }

}

dependencies {

    // ---- Core ----
    implementation(libs.androidx.core.ktx)

    // ---- Compose ----
    implementation(libs.activity.compose)
    implementation(libs.compose.ui)
    implementation(libs.compose.material3)
    implementation(libs.compose.ui.tooling.preview)
    debugImplementation(libs.compose.ui.tooling)

    // ---- Navigation ----
    implementation(libs.navigation.compose)

    // ---- Lifecycle ----
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.viewmodel.compose)

    // ---- Coroutines ----
    implementation(libs.coroutines.android)

    // ---- Hilt ----
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    // ---- Networking ----
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttp.logging.interceptor)

    // ---- Image loading ----
    implementation(libs.coil.compose)

    // ---- UI Support ----
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)

    // ---- Unit tests (src/test) ----
    testImplementation(libs.junit)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.mockito.inline)       // enables mocking Kotlin finals
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.turbine)          // for Flow/StateFlow testing

    // ---- Instrumentation tests (src/androidTest) ----
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.ui.test.manifest)
    androidTestImplementation(libs.mockito.kotlin)


    // MockK is safest for Kotlin ViewModels (works on device)
    androidTestImplementation(libs.mockk.android)
    androidTestImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.core.ktx)
    androidTestImplementation(libs.rules)
}
