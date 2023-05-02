# Spring with Apache Kafka

## Swagger
http://localhost:8081/swagger-ui/index.html#/

## Crear topic
Los mensajes se procesan en topics, para crear uno deberás ejecutar el siguiente comando:
````
bin/kafka-topics.sh 
--bootstrap-server localhost:9092
--create --topic message-topic
--partitions 5 --replication-factor 1
````

- bootstrap-server, servidor de Kafka
- topic, nombre del topic a crear
- partitions, número de particiones
- replication-factor, número de réplicas por broker


## Listar topics
````
bin/kafka-topics.sh --list
--bootstrap-server localhost:9092
````

## Ver definición de un topic
````
bin/kafka-topics.sh --describe
--topic message-topic
--bootstrap-server localhost:9092
````

## Crear un producer
````
bin/kafka-console-producer.sh 
--topic message-topic
--bootstrap-server localhost:9092
````

## Crear un consumer
````
bin/kafka-console-consumer.sh 
--topic message-topic
--from-beginning
--bootstrap-server localhost:9092
````

- from-beginning, permite especificar si queremos recibir sólo los mensajes nuevos o queremos leer todos desde el inicio.

## Consumer properties

- BOOTSTRAP_SERVERS_CONFIG, lista de brokers de Kafka en el cluster.
- GROUP_ID_CONFIG, consumer group que consumirá los mensajes.
- ENABLE_AUTO_COMMIT_CONFIG, determina si se hará commit al offset de forma periódica.
- AUTO_COMMIT_INTERVAL_MS_CONFIG, determina la frecuencia en milisegundos en la que se hará commit a los offsets, solo es necesaria si ENABLE_AUTO_COMMIT_CONFIG=true.
- SESSION_TIMEOUT_MS_CONFIG, timeout utilizado para determinar errores en los clientes.
- KEY_DESERIALIZER_CLASS_CONFIG, clase a utilizar para deserializar la key.
- VALUE_DESERIALIZER_CLASS_CONFIG, clase a utilizar para deserializar el mensaje.

## Producer properties

- BOOTSTRAP_SERVERS_CONFIG, lista de brokers de Kafka en el cluster.
- RETRIES_CONFIG, define los reintentos que se realizarán en caso de error.
- BATCH_SIZE_CONFIG, El producer agrupará los registros en batches, mejorando el performance (está definido en bytes).
- LINGER_MS_CONFIG, los batches se agruparán de acuerdo a un periodo de tiempo, está definido en milisegundos.
- BUFFER_MEMORY_CONFIG, define el espacio de memoria que se asignará para colocar los mensajes que están pendientes de enviar.
- KEY_SERIALIZER_CLASS_CONFIGG, clase a utilizar para serializar la key.
- VALUE_SERIALIZER_CLASS_CONFIG, clase a utilizar para serializar el mensaje.

## Kafka con docker

1. mvn clean install
2. docker-compose up -d

Podemos crear los topics accediendo a Kafka-ui mediante http://localhost:8080/