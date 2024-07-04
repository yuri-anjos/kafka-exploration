# kafka-exploration

### Apache Kafka JAVA 21

Aplicação extremamente simples apenas para entender o funcionamento do kafka, por  isso para validar as mensagerias, LER OS LOGS DAS APLICAÇÕES!

# Como configurar e rodar a aplicação

### Como rodar o projeto inteiro no docker

- Empacotar os serviços com o comando "mvn clean package -DskipTests=true".
- No diretorio do arquivo docker-compose.yaml executar o comando "docker compose up".

### Como rodar o projeto local

- No docker-compose comentar os serviços str-producer/str-consumer/payment-service/json-consumer.
- No diretorio do arquivo docker-compose.yaml executar o comando "docker compose up".
- Rodar as aplicaçoes localmente.

### Interface do kafka - KAFDROP

- http://localhost:19000/

### Postman

Coleção do postman: files/msrabbitmq.postman_collection.json