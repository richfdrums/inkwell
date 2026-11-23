# Inkwell

A small headless content API (articles, authors, tags) with REST and GraphQL endpoints, built with **Spring Boot 4.1** and **Java 21**.

Status: starter skeleton. Built module by module, following the course in "Spring Boot for Rich: From Zero to Resume-Ready".

## Prerequisites (macOS)

1. **JDK 21+** — e.g. `brew install --cask temurin@21`, or SDKMAN: `sdk install java 21-tem`. Check with `java -version`.
2. **Docker Desktop**, running. Spring Boot starts the Postgres container from `compose.yaml` for you.
3. **IntelliJ IDEA** (Community is fine): *File → Open* this `inkwell` folder and let it import the Gradle project.

## Run it

```bash
cd inkwell
./gradlew bootRun
```

The first run downloads Gradle 8.14.3 and all dependencies, so it takes a few minutes. Then:

```bash
curl localhost:8080/actuator/health     # → {"status":"UP"}
```

If `./gradlew` says permission denied: `chmod +x gradlew`.

## What's already here vs. what you'll build

Already set up:

- `build.gradle.kts`: Spring Boot 4.1.1 with the Boot 4 starter names (`spring-boot-starter-webmvc`, `-data-jpa`, `-flyway`, `-validation`, `-actuator`), plus Docker Compose support and DevTools. The Security and GraphQL starters are commented out until Modules 5 and 7.
- `InkwellApplication.java`: the entry point.
- `application.yml`: profiles (default `dev`), `open-in-view: false`, Actuator exposure, and the `inkwell.*` settings.
- `compose.yaml`: Postgres 17. Boot detects it and configures the datasource automatically.
- `src/main/resources/db/migration/`: empty for now. Flyway migrations go here in Module 3.

Your Module 1 work:

1. Run with `./gradlew bootRun --args='--debug'` and read the **CONDITIONS EVALUATION REPORT**. Find why `DataSourceAutoConfiguration` matched.
2. Create an `InkwellProperties` record bound to `inkwell.*` with `@ConfigurationProperties`, and inject it into a service.
3. Add `application-dev.yml` and `application-prod.yml` with different log levels. Run with `--spring.profiles.active=prod`.

## Put it on GitHub

```bash
cd inkwell
git init -b main
git add .
git commit -m "Initial Spring Boot 4 skeleton"
gh repo create inkwell --public --source=. --push   # or create the repo on github.com and push
```

Commit after each module. The history shows the work.

## Design notes

*(Fill this in as you go: compare Spring's approach with what you built at Brightspot, e.g. ETag handling, events vs. the Content Edit Topic framework, Hibernate vs. Dari, schema-first GraphQL vs. GCA.)*
