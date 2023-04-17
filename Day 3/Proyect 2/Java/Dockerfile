# Use an official Java runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory to /app
WORKDIR /app

# Copy the JAR file into the container at /app
COPY ./KafkaProducerExample/target/kafka-producer-example-1.jar /app

# Download Kafka client library
RUN apt-get update && \
    apt-get install -y wget && \
    wget https://repo1.maven.org/maven2/org/apache/kafka/kafka-clients/2.8.0/kafka-clients-2.8.0.jar
    
# Set the classpath and run the JAR file when the container launches
CMD ["java", "-cp", "/app:/app/kafka-clients-2.8.0.jar", "org.example.KafkaProducerExample"]
