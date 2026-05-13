# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Stack

- Java 17, Spring Boot 3.2, Gradle (Kotlin-style Groovy DSL)
- Lombok for boilerplate reduction (`@Data`, `@Builder`, etc.)
- JUnit 5 via `spring-boot-starter-test`

## Commands

```bash
# Build
./gradlew build

# Run the application
./gradlew bootRun

# Run all tests
./gradlew test

# Run a single test class
./gradlew test --tests "com.example.warigari.WarigariApplicationTests"

# Run a single test method
./gradlew test --tests "com.example.warigari.WarigariApplicationTests.contextLoads"

# Clean build outputs
./gradlew clean
```

## Project structure

Base package: `com.example.warigari`

This project is in early scaffolding state — only the `@SpringBootApplication` entry point and a context-load smoke test exist. New features should follow standard Spring Boot layering: `controller` → `service` → `repository`, each in their own sub-package under `com.example.warigari`.