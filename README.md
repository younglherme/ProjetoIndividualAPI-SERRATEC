# 🎵 Serratec Music API

API RESTful para gerenciamento de usuários, artistas, músicas e playlists desenvolvida com Spring Boot.

## 📋 Requisitos

- Java 17+
- Maven 3.8+
- PostgreSQL 12+

## 🚀 Como Executar

### 1. Configurar o Banco de Dados

Crie um banco de dados PostgreSQL:

```sql
CREATE DATABASE serratecmusic;
```

### 2. Configurar Credenciais

Edite o arquivo `application.properties` e ajuste as credenciais do banco:

```properties
spring.datasource.username=postgres
spring.datasource.password=12345
```

### 3. Executar a Aplicação

```bash
mvn spring-boot:run
```

A aplicação estará disponível em:
```
 http://localhost:8080
```

## 📚 Documentação Swagger

Acesse a documentação interativa em:
```
http://localhost:8080/swagger-ui.html
```

## 📦 Dependências Principais

- Spring Boot DevTools
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- PostgreSQL Driver
- Validation
- Springdoc OpenAPI (Swagger)


