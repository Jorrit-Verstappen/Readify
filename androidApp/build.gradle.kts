import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    sourceSets {
        
        androidMain.dependencies {
            implementation(libs.androidx.compose.ui.tooling)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            implementation(projects.shared)
        }
    }
}

android {
    namespace = "dev.jorritv.readify"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/main/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "dev.jorritv.readify"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            versionNameSuffix = "-DEBUG"
        }
        release {
            isMinifyEnabled = false
        }
    }
    val stageDimension = "stage"
    flavorDimensions += listOf(stageDimension)
    productFlavors {
        create("dev") {
            dimension = stageDimension
        }
        create("prod") {
            dimension = stageDimension
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    dependencies {
        // Compose
        val composeBom = platform(libs.androidx.compose.bom)
        implementation(composeBom)
        androidTestImplementation(composeBom)
        implementation(libs.androidx.compose.foundation.layout)
        implementation(libs.androidx.compose.foundation.layout)
        implementation(libs.androidx.compose.material.icons)
        implementation(libs.androidx.compose.material3)
        implementation(libs.androidx.compose.runtime)
        implementation(libs.androidx.compose.ui.googlefonts)
        debugImplementation(libs.androidx.compose.ui.tooling)
        implementation(libs.androidx.compose.ui.tooling.preview)
        implementation(libs.androidx.activity.compose)

        // Lifecyle
        implementation(libs.androidx.lifecycle.viewModelCompose)

        // AndroidX
        implementation(libs.androidx.appcompat)
        implementation(libs.androidx.core.ktx)

        // Kotlin
        implementation(libs.kotlin.stdlib)
        implementation(libs.kotlin.reflect)
        implementation(libs.kotlinx.coroutines.android)
        implementation(libs.kotlinx.serialization)

        // Coil
        implementation(libs.coil)
        implementation(libs.coil.compose)

        // Rest of the dependencies
        coreLibraryDesugaring(libs.desugar.jdk.libs)
    }
}
