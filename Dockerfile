# Use Maven image for building the application
FROM maven:3.8.5-openjdk-17 AS build

# Set working directory in the build stage
WORKDIR /app

# Copy the source code into the container
COPY . .

# Run Maven to build the application
RUN mvn clean package

# Use a lightweight OpenJDK runtime for the final image
FROM openjdk:17-slim

# Set working directory in the runtime container
WORKDIR /app

# Copy the built application JAR file from the build stage
COPY --from=build /app/target/*.jar /app/exoplanet.jar

# Specify the command to run the application
CMD ["java", "-jar", "/app/exoplanet.jar"]
