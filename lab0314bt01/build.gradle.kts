// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("androidx.navigation.safeargs") version "2.8.0" apply false

    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {

        classpath(libs.androidx.navigation.safe.args.gradle.plugin.v280)
    }
}

