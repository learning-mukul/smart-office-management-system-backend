# Use a valid JDK base image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy the built jar into the container
COPY target/smart-office-management-system-backend-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java","-jar","app.jar"]
