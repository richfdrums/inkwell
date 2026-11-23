plugins {
    java
    id("org.springframework.boot") version "4.1.1"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.richfdrums"
version = "0.0.1-SNAPSHOT"
description = "Inkwell: a small headless content API built while learning Spring Boot"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Module 1-2: web layer, validation, ops endpoints
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Module 3: persistence (Postgres + JPA + Flyway migrations)
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-flyway")
    implementation("org.flywaydb:flyway-database-postgresql")
    runtimeOnly("org.postgresql:postgresql")

    // Local dev: auto-start Postgres from compose.yaml, hot restart
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // Module 5 (add later): Spring Security
    // implementation("org.springframework.boot:spring-boot-starter-security")
    // implementation("org.springframework.boot:spring-boot-starter-security-oauth2-resource-server")
    // testImplementation("org.springframework.boot:spring-boot-starter-security-test")

    // Module 7 (add later): Spring for GraphQL
    // implementation("org.springframework.boot:spring-boot-starter-graphql")

    // Module 4: testing (each Boot 4 test starter pulls in JUnit 5, AssertJ, Mockito)
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testImplementation("org.springframework.boot:spring-boot-starter-data-jpa-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
