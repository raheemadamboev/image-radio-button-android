plugins {
    alias(libs.plugins.android)
}

android {
    namespace = "xyz.teamgravity.imageradiobuttondemo"

    compileSdk {
        version = release(libs.versions.sdk.compile.get().toInt()) {
            minorApiLevel = 0
        }
    }

    defaultConfig {
        applicationId = "xyz.teamgravity.imageradiobuttondemo"
        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.target.get().toInt()
        versionCode = 1
        versionName = "1.0.0"
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

dependencies {

    // image radio button
    implementation(projects.imageRadioButton)
//    implementation("com.github.raheemadamboev:image-radio-button-android:1.0.12")

    // core
    implementation(libs.core)

    // appcompat
    implementation(libs.appcompat)

    // material
    implementation(libs.material)

    // constraint layout
    implementation(libs.constraintlayout)
}