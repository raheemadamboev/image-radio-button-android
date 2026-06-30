plugins {
    alias(libs.plugins.library)
    id("maven-publish")
}

android {
    namespace = "xyz.teamgravity.imageradiobutton"

    compileSdk {
        version = release(libs.versions.sdk.compile.get().toInt()) {
            minorApiLevel = 0
        }
    }

    defaultConfig {
        minSdk = libs.versions.sdk.min.get().toInt()
    }

    lint {
        targetSdk = libs.versions.sdk.target.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    // core
    implementation(libs.core)

    // appcompat
    implementation(libs.appcompat)

    // material
    implementation(libs.material)
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.raheemadamboev"
            artifactId = "image-radio-button-android"
            version = "1.0.13"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}