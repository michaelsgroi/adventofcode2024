/*
 * Fixes the following warning ...
 *
 * Using a toolchain installed via auto-provisioning, but having no toolchain repositories configured. This behavior is
 * deprecated. Consider defining toolchain download repositories, otherwise the build might fail in clean environments;
 * see https://docs.gradle.org/8.10.2/userguide/toolchains.html#sub:download_repositories
 */
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "adventofcode2024"
