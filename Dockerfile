# === Build Stage ===
# Use a Maven base image with a specific JDK version (e.g., OpenJDK 21 is for Spring Boot 3.x)
FROM maven:3.9.12-eclipse-temurin-25-noble AS build
WORKDIR /app
COPY . .
# Build the project, creating the JAR file in the target directory
RUN mvn clean package -DskipTests

# === Run Stage ===
# Use a lightweight JRE base image (e.g., OpenJDK 21 slim JRE)
FROM openjdk:26-ea-25-jdk-slim
# Create a dedicated user and group to run the app as non-root for security
RUN groupadd --system spring && useradd --system --gid spring spring
USER spring
WORKDIR /app
# Copy the JAR file from the 'build' stage into the new image
COPY --from=build /app/target/*.jar app.jar
# Expose the default port Spring Boot runs on
EXPOSE 8080
# Define the command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
