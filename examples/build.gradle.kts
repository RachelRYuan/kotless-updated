import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

group = "io.kotless.examples"
version = "0.3.3"

plugins {
    kotlin("jvm") version "1.9.21" apply true
}

dependencies {
    implementation(files("../lib/io.terraformkt/entities/0.1.5/entities-0.1.5.jar"))
}

subprojects {
    apply {
        plugin("kotlin")
    }

    repositories {
        mavenLocal()
        maven(url = uri("https://packages.jetbrains.team/maven/p/ktls/maven"))
        mavenCentral()
    }

//    dependencies {
//        implementation(files("../lib/io.terraformkt/entities/0.1.5/entities-0.1.5.jar"))
//    }

    tasks.withType<KotlinJvmCompile> {
        kotlinOptions {
            jvmTarget = "21"
            languageVersion = "2.1"
            apiVersion = "2.1"
        }
    }
}
