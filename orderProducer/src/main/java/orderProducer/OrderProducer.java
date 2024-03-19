package orderProducer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class OrderProducer{

	public static void main(String[] args) {
		//a new instance of the Properties class is created. 
		//The Properties class is part of the Java standard library and is used to represent a persistent set of properties. 
		//In this case, it will be used to configure the Kafka producer.
		Properties properties = new Properties();
		
		//sets a property named "bootstrap.servers" in the Properties object. 
		//The "bootstrap.servers" property specifies the list of Kafka brokers that the producer will connect to. 
		//In this case, it is set to "localhost:9092", indicating that the Kafka broker is running on the local machine on port 9092.
		properties.setProperty("bootstrap.servers","localhost:9092" );
		
		//ctrl+shirt+t to select the key and values class open the class and copy the package 
		//These lines set two additional properties, "key.serializer" and "value.serializer," 
		//which specify the serializers to be used for the keys and values, respectively. 
		//The provided serializers are for a string key ("org.apache.kafka.common.serialization.StringSerializer") and an integer value ("org.apache.kafka.common.serialization.IntegerSerializer").
		properties.setProperty("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
		properties.setProperty("value.serializer","org.apache.kafka.common.serialization.IntegerSerializer");
		
		//a new instance of the KafkaProducer class is created, specifying the types for the key and value as generic parameters (String and Integer, respectively). 
		//The constructor takes the Properties object containing the configuration for the Kafka producer.
		KafkaProducer<String, Integer> kafkaProducer = new KafkaProducer<String, Integer>(properties);
		
		//This line creates a ProducerRecord object, which represents a record to be sent to a Kafka topic. It takes three parameters: the topic name ("orderTopic"), the key ("HP spectrate"), and the value (10).
		ProducerRecord<String, Integer> record = new ProducerRecord<String, Integer>("orderTopic", "HP spectrate",10);
		
		//This block of code sends the ProducerRecord to the Kafka topic using the send method of the KafkaProducer instance. 
		//If the send operation is successful, it prints "data sent successfully."
		try {
			kafkaProducer.send(record);
			System.out.println("data sent successfully");
		} 
		//If an exception occurs during the process, it catches the exception, prints the stack trace, 
		catch (Exception e) {
			e.printStackTrace();
		}
		//and finally closes the Kafka producer using the close method.
		finally {
			kafkaProducer.close() ;
		}
	}
	

}
