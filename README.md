# 🎓 API Control Escolar

A RESTful API for school management built with **Java + Spring Boot**. Supports full CRUD operations for students, teachers, subjects, and grades, with token-based authentication and role-based access control (admin / user).

## Tech Stack

- **Java** + **Spring Boot**
- **Spring Security** — API Token authentication
- **H2** — In-memory database
- **REST API** — JSON responses

## Features

- Full CRUD for: Students, Teachers, Subjects and Grades
- API Token authentication
- Role-based permissions: `ADMIN` and `USER`
- In-memory H2 database (no setup required)

## Getting Started

### Prerequisites
- Java 17+
- Maven

### Run locally

```bash
git clone https://github.com/zzned/api-control-escolar.git
cd api-control-escolar
./mvnw spring-boot:run
```

API will be available at `http://localhost:8080`

## Authentication

Include your API token in every request header:

Authorization: Bearer YOUR_TOKEN_HERE

## Main Endpoints

| Method | Endpoint | Description | Role |
|--------|----------|-------------|------|
| GET | `/alumnos` | List all students | USER |
| POST | `/alumnos` | Create student | ADMIN |
| PUT | `/alumnos/{id}` | Update student | ADMIN |
| DELETE | `/alumnos/{id}` | Delete student | ADMIN |
| GET | `/maestros` | List all teachers | USER |
| GET | `/materias` | List all subjects | USER |
| GET | `/calificaciones` | List all grades | USER |

## 👤 Author

**Marco Andrade** — [LinkedIn](https://www.linkedin.com/in/marco-andrade-tirado-78121a3b1/)
