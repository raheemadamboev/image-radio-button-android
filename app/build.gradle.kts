plugins {
    alias(libs.plugins.android)
    alias(libs.plugins.kotlin)
}

android {
    namespace = "xyz.teamgravity.imageradiobuttondemo"
    compileSdk = libs.versions.sdk.compile.get().toInt()

    defaultConfig {
        applicationId = "xyz.teamgravity.imageradiobuttondemo"
        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.target.get().toInt()
        versionCode = 1
        versionName = "1.0.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = libs.versions.jvm.target.get()
    }

    buildFeatures {
        viewBinding = true
    }

    packaging {
        resources {
            pickFirsts.add("META-INF/atomicfu.kotlin_module")
        }
    }
}

dependencies {

    // image radio button
    implementation(projects.imageRadioButton)

    // core
    implementation(libs.core)

    // appcompat
    implementation(libs.appcompat)

    // material
    implementation(libs.material)

    // constraint layout
    implementation(libs.constraintlayout)
}