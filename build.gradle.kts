plugins {
    kotlin("jvm") version "2.0.21"
    id("com.autonomousapps.dependency-analysis") version "2.5.0"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.2"
}

group = "michaelsgroi.adventofcode2024"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.3")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
        vendor.set(JvmVendorSpec.ADOPTIUM)
    }
}

tasks.test {
    useJUnitPlatform()
    dependsOn("ktlintCheck")
}

kotlin {
    jvmToolchain(21)
}

ktlint {
    version.set("1.4.1")
    outputToConsole.set(true)
    ignoreFailures.set(false)
}

dependencyAnalysis {
    issues {
        all {
            onUnusedDependencies {
                severity("fail")
                exclude("org.jetbrains.kotlin:kotlin-test")
            }
            onUsedTransitiveDependencies { severity("fail") }
            onIncorrectConfiguration { severity("fail") }
        }
    }
}
