
# Stage 1: Build Spring Boot application
FROM maven:3.9.11-eclipse-temurin-25 AS build

WORKDIR /app

# Copy Maven configuration
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .

RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline -B

# Copy application source code
COPY src ./src

# Build executable JAR
RUN ./mvnw clean package -DskipTests -B


# Stage 2: Run Spring Boot application
FROM eclipse-temurin:25-jre

WORKDIR /app

# Copy generated JAR
COPY --from=build /app/target/BackendCrudProjectSkill-0.0.1-SNAPSHOT.jar app.jar

# Application port
EXPOSE 2005

# Start application
ENTRYPOINT ["java", "-jar", "app.jar"]
