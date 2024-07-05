# Use the official OpenJDK image with Alpine Linux
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the built jar file and the log4j2 configuration file
COPY build/libs/*.jar /app/Book.jar
COPY build/resources/main/log4j2.yml /config/log4j2.yml

# Set the Spring configuration location
ENV SPRING_CONFIG_LOCATION=/config/application.yml

# Expose the port the application runs on
EXPOSE 8080

# Set the entry point to run the application
CMD ["java", "-jar", "Book.jar"]
