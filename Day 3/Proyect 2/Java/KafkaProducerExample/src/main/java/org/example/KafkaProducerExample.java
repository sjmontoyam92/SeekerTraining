package org.example;

import java.util.Properties;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;

public class KafkaProducerExample {
    public void run() {
        // Set Kafka producer properties
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "my-producer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        // Create a Kafka producer instance
        Producer<String, String> producer = new KafkaProducer<>(props);

        // Send a test message to the Kafka topic
        ProducerRecord<String, String> record = new ProducerRecord<>("test2", "IT TEST 5");
        producer.send(record);

        // Clean up resources
        producer.close();
    }
}
