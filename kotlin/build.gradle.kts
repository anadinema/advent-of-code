import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
    id("org.openapi.generator") version "7.2.0"
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.spring") version "1.9.21"
}

group = "dev.anadinema.projects"
version = "1.0.0-SNAPSHOT"

java {
    targetCompatibility = JavaVersion.VERSION_21
    sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

var swaggerCoreVersion = "2.2.20"
var jakartaValidApiVersion = "3.1.0-M1"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.swagger.core.v3:swagger-models:$swaggerCoreVersion")
    implementation("io.swagger.core.v3:swagger-annotations:$swaggerCoreVersion")
    implementation("jakarta.validation:jakarta.validation-api:$jakartaValidApiVersion")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    runtimeOnly("io.micrometer:micrometer-registry-prometheus")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

openApiGenerate {
    generatorName.set("kotlin-spring")
    inputSpec.set("$projectDir/api/specs.yaml")
    outputDir.set("$projectDir/build/generated/api")
    apiPackage.set("dev.anadinema.projects.advent.code.api")
    modelPackage.set("dev.anadinema.projects.advent.code.model")
    generateApiTests.set(false)
    generateModelTests.set(false)
    configOptions.set(mapOf(
        "useTags" to "true",
        "useSpringBoot3" to "true",
        "interfaceOnly" to "true",
        "skipDefaultInterface" to "true",
        "basePackage" to "dev.anadinema.projects.advent.code",
        "useSwaggerUI" to "false",
        "exceptionHandler" to "false"
    ))
}

sourceSets {
    val main by getting
    main.kotlin.srcDirs("src/main/kotlin","build/generated/api/src/main/kotlin")
}

tasks.withType<KotlinCompile>().all {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
