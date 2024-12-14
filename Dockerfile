# Step 1: Use an official Maven image to build the project
FROM maven:3.8-openjdk-17-slim as builder

# Set the working directory inside the container
WORKDIR /app

# Step 2: Clone the repository and copy it into the Docker image
RUN git clone https://github.com/vm84039/Exoplanet.git .

# Step 3: Build the project with Maven
RUN mvn clean install

# Step 4: Set up the environment to run the application (Java 17 runtime)
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/*.jar /app/exoplanet.jar

# Expose any necessary ports (e.g., for a web service)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "/app/exoplanet.jar"]
