plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlin)
    id("maven-publish")
}

android {
    namespace = "xyz.teamgravity.imageradiobutton"
    compileSdk = libs.versions.sdk.compile.get().toInt()

    defaultConfig {
        minSdk = libs.versions.sdk.min.get().toInt()
    }

    lint {
        targetSdk = libs.versions.sdk.target.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = libs.versions.jvm.target.get()
    }

    packaging {
        resources {
            pickFirsts.add("META-INF/atomicfu.kotlin_module")
        }
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
            version = "1.0.9"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}