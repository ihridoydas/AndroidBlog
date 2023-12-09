import org.jetbrains.dokka.base.DokkaBase
import org.jetbrains.dokka.base.DokkaBaseConfiguration
import org.jetbrains.dokka.gradle.DokkaTask

buildscript {
    dependencies {
        classpath("org.jetbrains.dokka:android-documentation-plugin:1.9.10")
        classpath("com.android.tools.build:gradle:8.2.0")
    }
    repositories {
        mavenCentral()
        google()
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
    id ("com.google.dagger.hilt.android") version "2.48" apply false
    id ("org.jetbrains.dokka") version "1.9.10"
}

task("clean"){
    delete(rootProject.buildDir)
}

tasks.withType<DokkaTask>().configureEach {
    outputDirectory.set(file("$buildDir/dokka/html"))// docsディレクトリにドキュメントを出力する
    pluginConfiguration<DokkaBase, DokkaBaseConfiguration> {
        customAssets = listOf(file("my-image.png"))
        customStyleSheets = listOf(file("my-styles.css"))
        footerMessage = "(c) 2022 MyOrg"
    }
        dokkaSourceSets {
            configureEach {
                includes.from("$rootDir/docs/ModuleDoc.md", "$rootDir/docs/PackageDoc.md")
                named("test") {
                    sourceRoots.from(file("$rootDir/docs"))
                }
            }
        }
}