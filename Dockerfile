# Step 1: Use an official Maven image to build the project
FROM eclipse-temurin:17 as builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project file (pom.xml) to the container
COPY pom.xml .

# Download the dependencies (without building the project yet)
RUN apt-get update && apt-get install -y maven
RUN mvn dependency:go-offline

# Copy the rest of the application code
COPY src /app/src

# Step 2: Build the project
RUN mvn clean package

# Step 3: Use a smaller image to run the application
FROM eclipse-temurin:17-slim

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/exoplanet-app.jar /app/exoplanet-app.jar

# Expose the port the application will run on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/exoplanet-app.jar"]