// import java.util.Properties;
// import org.apache.kafka.clients.producer.KafkaProducer;
// import org.apache.kafka.clients.producer.ProducerRecord;

// public class KafkaProducerExample {
//   public static void main(String[] args) {
//     String topicName = "training-topic:1:1";
//     String message = "Hello, Kafka!";

//     Properties props = new Properties();
//     props.put("bootstrap.servers", "kafka:9092");
//     props.put("acks", "all");
//     props.put("retries", 0);
//     props.put("batch.size", 16384);
//     props.put("linger.ms", 1);
//     props.put("buffer.memory", 33554432);
//     props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//     props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

//     KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
//     ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, message);
//     producer.send(record);

//     producer.close();
//   }
// }

package com.example;

import java.util.Properties;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;

public class KafkaProducerExample {
    public static void main(String[] args) throws Exception {
        // Set Kafka producer properties
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "my-producer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        // Create a Kafka producer instance
        Producer<String, String> producer = new KafkaProducer<>(props);

        // Send a test message to the Kafka topic
        ProducerRecord<String, String> record = new ProducerRecord<>("training-topic:1:1", "Hello, Kafka!");
        producer.send(record);

        // Clean up resources
        producer.close();
    }
}
