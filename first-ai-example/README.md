# first-ai-example

## Technology Stack

- Java-21
- Spring Boot - 3.2.x
- Spring AI - 0.8.1
- Ollama setup

## Installation

Pls install Ollama on your local machine.

<details>
  <summary><b>MacOs</b></summary>

[Download](https://ollama.com/download/Ollama-darwin.zip)
</details>

<details>
  <summary><b>Windows</b></summary>

[Download](https://ollama.com/download/OllamaSetup.exe)
</details>

<details>
  <summary><b>Linux</b></summary>

```shell
curl -fsSL https://ollama.com/install.sh | sh
```
[Manual install instructions](https://github.com/ollama/ollama/blob/main/docs/linux.md)
</details>

<details>
  <summary><b>Docker</b></summary>

The official [Ollama Docker image](https://hub.docker.com/r/ollama/ollama) `ollama/ollama` is available on Docker Hub.
</details>

Pls install Java-21 on your machine along with Apache Maven.

## Build
```shell
mvn clean install
```

## Run
Run ollama first:
```shell
ollama run mistral
```
run the application:
```shell
mvn spring-boot:run
```

## Test
Invoke below api:
```shell
curl -X GET --location 'http://localhost:8080/ai/generate?message=who%20is%20donald%20trump%3F'
```

and
```shell
curl -X GET --location 'http://localhost:8080/ai/generateStream'
```