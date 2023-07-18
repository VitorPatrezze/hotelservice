FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the compiled Kotlin project files to the container
COPY build/libs/*.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]