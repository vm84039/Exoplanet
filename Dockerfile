# Use Maven image for building the application
FROM maven:3.8.5-openjdk-17 AS build

# Set working directory in the build stage
WORKDIR /app

# Copy the source code into the container
COPY . .

# Run Maven to build the application
RUN mvn clean package -DskipTests

# Use a lightweight OpenJDK runtime for the final image
FROM openjdk:17-slim

# Install Maven in the final image
RUN apt-get update && apt-get install -y maven

# Set working directory in the runtime container
WORKDIR /app

# Copy the pom.xml and src folder from the build stage
COPY --from=build /app/pom.xml /app/pom.xml
COPY --from=build /app/src /app/src

# Copy the built application JAR file from the build stage
COPY --from=build /app/target/exoplanet-1.jar /app/exoplanet.jar

# Specify the command to run the application
CMD ["java", "-jar", "/app/exoplanet.jar"]
