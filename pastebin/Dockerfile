# Use a Java runtime as a parent image
FROM openjdk:17

# Set the working directory to /app
WORKDIR /app

# Copy the executable JAR file from the target directory into the container at /app/app.jar
COPY target/pastebin-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose port 8080 to the Docker host
EXPOSE 8080

# Run the command to start the Spring Boot application
CMD ["java", "-jar", "app.jar"]
