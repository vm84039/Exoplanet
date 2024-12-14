# Use Maven with OpenJDK 17 as the base image
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Clone the repository
RUN git clone https://github.com/vm84039/Exoplanet.git .

# Build the app using Maven
RUN mvn clean install

# Use a minimal OpenJDK 17 image for the runtime environment
FROM openjdk:17-slim

# Set the working directory in the runtime container
WORKDIR /app

# Copy the built application from the build container
COPY --from=build /app/target/exoplanet.jar /app/exoplanet.jar

# Set the default command to run the application
CMD ["java", "-jar", "/app/exoplanet.jar"]
