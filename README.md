# Spring Security RBAC REST API

A secure Java and Spring Boot REST API project focused on authentication, authorization, role-based access control, and relational data modeling.

This project demonstrates how backend services can protect endpoints using Spring Security, user roles, Basic Authentication, JDBC-based authentication concepts, and OAuth2 integration.

## Overview

This project demonstrates secure backend API structure with Spring Security, role-based access control, protected endpoints, and database-backed authentication logic.

The main goal is to show how authentication, authorization, user-role relationships, and endpoint-level access rules can be implemented in a layered Spring Boot REST API.

The application includes account-related CRUD operations and authentication-related flows while applying role-based access rules for different types of users.

## Tech Stack

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* Maven
* REST API
* JDBC Authentication concepts
* Basic Authentication
* OAuth2 / GitHub authentication concept
* Relational database modeling
* Lombok
* Layered backend architecture

## Core Concepts

* Role-Based Access Control (RBAC)
* Authentication and authorization
* User and role entity modeling
* Many-to-many relationships between users and roles
* Protected REST endpoints
* Controller-Service-Repository structure
* Dependency Injection
* Database-backed user management
* Secure endpoint access by user role
* Spring Security configuration

## Features

* Member registration flow
* User and role relationship modeling
* Account CRUD operations
* Basic authentication for protected endpoints
* Role-based access restrictions
* Admin-only operations for create, update, and delete requests
* User-level access for read operations
* JDBC authentication flow
* OAuth2 / GitHub authentication concept
* Layered backend structure using controller, service, repository, entity, and config layers

## Authorization Rules

The project applies role-based access control logic such as:

| Role    | Access                                           |
| ------- | ------------------------------------------------ |
| `user`  | Can access read/list endpoints                   |
| `admin` | Can access create, update, and delete operations |

This structure helps separate normal user permissions from administrative actions.

## Main API Endpoints

### Authentication

| Method | Endpoint                    | Description           |
| ------ | --------------------------- | --------------------- |
| POST   | `/workintech/auth/register` | Register a new member |

### Account Operations

| Method | Endpoint                    | Description          |
| ------ | --------------------------- | -------------------- |
| GET    | `/workintech/accounts`      | Get all accounts     |
| GET    | `/workintech/accounts/{id}` | Get account by ID    |
| POST   | `/workintech/accounts`      | Create a new account |
| PUT    | `/workintech/accounts/{id}` | Update an account    |
| DELETE | `/workintech/accounts/{id}` | Delete an account    |

## Backend Architecture

The project follows a layered backend architecture:

```text
Controller Layer
↓
Service Layer
↓
Repository / DAO Layer
↓
Entity / Database Layer
↓
Security Configuration
```

This structure keeps request handling, business logic, database access, and security configuration separated.

## Entity Relationships

The project includes authentication-related entities such as:

* `Member`
* `Role`
* `Account`

A many-to-many relationship is used between `Member` and `Role` to support role-based authorization.

```text
Member
  ↕
Many-to-Many
  ↕
Role
```

## Project Structure

```text
src/
 └── main/
     ├── java/
     │   └── ...
     │       ├── controller/
     │       ├── config/
     │       ├── entity/
     │       ├── dao/
     │       ├── service/
     │       └── dto/
     └── resources/
         └── application.properties
```

## What This Project Demonstrates

* Creating secure REST APIs with Spring Boot
* Configuring Spring Security
* Implementing role-based authorization rules
* Modeling user-role relationships with JPA
* Creating CRUD endpoints with protected access
* Separating backend layers for maintainability
* Using dependency injection across service and controller layers
* Handling authentication flows with Basic Auth and JDBC authentication concepts
* Understanding how OAuth2 login can be integrated into a Spring application

## Getting Started

### Prerequisites

Make sure you have the following installed:

* Java 17+
* Maven
* A relational database
* IntelliJ IDEA or another Java IDE

### Installation

Clone the repository:

```bash
git clone https://github.com/emreyildirim-33/spring-security-rbac-api.git
cd spring-security-rbac-api
```

Configure your database connection in `application.properties`.

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

Run the project:

```bash
./mvnw spring-boot:run
```

The application runs on:

```text
http://localhost:9000
```

## API Testing

You can test the endpoints using:

* Postman
* IntelliJ HTTP Client
* Browser for simple GET requests

For protected endpoints, use the appropriate authentication method and user role.

## Notes

This project focuses on Spring Security, RBAC, authentication, authorization, user-role relationships, and protected REST API design.

The main purpose is to demonstrate secure backend architecture and role-based endpoint protection rather than building a complete production banking product.

## Repository

GitHub: https://github.com/emreyildirim-33/spring-security-rbac-api
