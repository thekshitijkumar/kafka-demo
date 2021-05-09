## Kafka
First start zookepper then start kafka server by giving properties file also

Create topic .Also can create replication  factor also
List topic
eg /home/kk/kafka_2.12-2.7.0/bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
Created producer  on specific topic 
/home/kk/kafka_2.12-2.7.0/bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic test-topic
Created consumer on specific topic also can create consumer group also --from-beginning
 /home/kk/kafka_2.12-2.7.0/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test-topic
can create consumer group similar to  threads so that message in a gropu can be consumed by one of the consumer in that group
--consumer-group name