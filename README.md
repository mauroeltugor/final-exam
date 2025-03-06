# Final Project - EPS Management System

This is a Spring Boot project for managing an EPS (Healthcare Provider) system. It provides CRUD operations for managing patients, doctors, rooms, areas, and locations.

## Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL (Docker)
- Adminer (for database management)
- Docker

## 🛠️ Setup Instructions

### 1️⃣ Clone the repository:
```sh
git clone https://github.com/mauroeltugor/final-exam.git
cd finalproyect1
```

### 2️⃣ Run MySQL & Adminer with Docker:
```sh
docker-compose up -d
```

### 3️⃣ Configure `application.properties`
Make sure your `src/main/resources/application.properties` has:
```
spring.datasource.url=jdbc:mysql://localhost:5500/eps_db
spring.datasource.username=root
spring.datasource.password=yourpassword
```

### 4️⃣ Run the application:
```sh
mvn spring-boot:run
```

## 📡 API Endpoints

### Patients
- `GET /patients` - Get all patients
- `GET /patients/{id}` - Get a patient by ID
- `POST /patients` - Create a new patient
- `PUT /patients/{id}` - Update a patient
- `DELETE /patients/{id}` - Delete a patient

## 🛑 How to Stop Services
```sh
docker-compose down
