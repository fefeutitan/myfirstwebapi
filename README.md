# My First Web API

A hands-on Java REST API learning project focused on CRUD operations, input validation, persistence and HTTP response handling.

> **Scope:** Educational project for practicing and revisiting Spring Boot concepts; not presented as a production system.

## Stack

- Java 8, Spring Boot 2.7.3 and Maven
- Spring Web, Spring Data JPA and Bean Validation
- H2 in-memory database
- Springfox Swagger 2 / Swagger UI 2.9.2
- Spring Boot DevTools and Spring Boot Test

## Architecture

The source uses a straightforward controller–repository approach:

```text
HTTP request
    |
    v
UserController (/users)
    |-- UserForm / UpdateUserForm (input + validation)
    |-- UserDto (response representation)
    v
UserRepository (Spring Data JPA)
    v
User entity -> H2 database
```

The `UserController` accesses `UserRepository` directly; a separate service layer is **not** claimed here. Validation errors are handled through a dedicated controller advice class. The repository also includes a welcome controller.

## API endpoints

Verified against `UserController.java`:

| Method | Path | Purpose |
| --- | --- | --- |
| GET | `/users` | List users |
| GET | `/users/{id}` | Get one user (404 if absent) |
| POST | `/users` | Create a user from a validated request body |
| PUT | `/users/{id}` | Update an existing user |
| DELETE | `/users/{id}` | Delete an existing user |

The POST handler returns HTTP 201 and a DTO. **Known detail:** its `Location` header is built using `/user/{id}` (singular), while the controller is mapped to `/users` (plural). This README documents the current behavior rather than changing it.

Request field names and validation rules should be checked in `UserForm` and `UpdateUserForm` before constructing POST/PUT payloads.

## Run locally

Prerequisites: JDK 8 and Maven.

```bash
git clone https://github.com/fefeutitan/myfirstwebapi.git
cd myfirstwebapi
mvn clean package
mvn spring-boot:run
```

The default H2 configuration is `jdbc:h2:mem:alura-forum`, user `sa`, blank password. The H2 console is configured at `/h2-console`.

Try the read endpoint after startup:

```bash
curl http://localhost:8080/users
```

The default port is 8080 unless overridden. Startup and HTTP responses have not been independently executed for this README update.

## Tests and build

```bash
mvn test
mvn clean package
```

These are the Maven commands supported by the project configuration; test coverage and successful execution have not been verified.

## Notes for maintainers

- Springfox 2.9.2 is an older integration; Swagger UI compatibility may require investigation.
- The project uses `spring.jpa.hibernate.ddl-auto=update` with an in-memory H2 database.
- This README intentionally does not claim an MIT license because licensing should be verified against an actual `LICENSE` file.

## Author

[Fernando Ellery](https://github.com/fefeutitan) · [LinkedIn](https://www.linkedin.com/in/fernando-ellery-133a209/)
