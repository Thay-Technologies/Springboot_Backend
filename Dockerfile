# Use a smaller Alpine-based image for Java 17
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file from your local machine to the container
COPY target/springbootbackend-0.0.1-SNAPSHOT.jar /app/springbootbackend.jar

# Expose the port that your Spring Boot application will run on
EXPOSE 8080

# Command to run your Spring Boot application
CMD ["java", "-jar", "springbootbackend.jar"]
