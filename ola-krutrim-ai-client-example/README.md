# ola-krutrim-ai-client-example

## Technology Stack
- Java-21
- Spring Boot - 3.2.x
- Spring AI - 0.8.1
- Ola Krutrim Cloud Setup

## Installation
Pls install Java-21 on your machine along with Apache Maven.

[Add new api-key here](https://cloud.olakrutrim.com/console/inference-service?section=api-keys)

Copy that api-key and paste it in application.properties for `application.ai.ola-krutim.api-key`

## Build
```shell
mvn clean install
```

## Run
```shell
mvn spring-boot:run
```

## Test
Invoke below api:
```shell
curl --location 'http://localhost:8080/ai/ola-krutrim/generateStream' \
--header 'Content-Type: application/json' \
--data '{
    "message": "what is java?"
}'
```
