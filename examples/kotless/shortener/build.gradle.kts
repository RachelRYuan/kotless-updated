import io.kotless.plugin.gradle.dsl.kotless

group = rootProject.group
version = rootProject.version

plugins {
    id("io.kotless") version "0.3.3" apply true
}

buildscript {
    dependencies {
        classpath(files("../../../lib/io.terraformkt/entities/0.1.5/entities-0.1.5.jar"))
    }
}

dependencies {
    implementation("io.kotless", "kotless-lang-aws", "0.3.3")
    implementation("io.kotless", "kotless-lang", "0.3.3")

    implementation("commons-validator", "commons-validator", "1.6")
    implementation("com.amazonaws", "aws-java-sdk-dynamodb", "1.12.618")

//    implementation("io.ktor", "ktor-html-builder", "1.5.0")
    implementation("io.ktor", "ktor-html-builder", "1.6.8")
//    implementation("org.jetbrains.kotlinx", "kotlinx-html-jvm", "0.7.2")
    implementation(files("../../../lib/io.terraformkt/entities/0.1.5/entities-0.1.5.jar"))
}


kotless {
    config {


        aws {
            prefix = "short"

            storage {
                bucket = "eu.short.s3.ktls.aws.intellij.net"
            }

            profile = "kotless-jetbrains"
            region = "eu-west-1"
        }
    }

    webapp {
        dns("short", "kotless.io")
    }

    extensions {
        local {
            useAWSEmulation = true
        }

        terraform {
            files {
                add(file("src/main/tf/extensions.tf"))
            }
        }
    }
}
