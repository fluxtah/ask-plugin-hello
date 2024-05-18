pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
    }
}

fun includeBuildIfPresent(path: String) {
    val projectDir = file(path)
    if (projectDir.exists()) {
        includeBuild(projectDir)
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "hello"
includeBuildIfPresent("../ask-plugin-sdk")

