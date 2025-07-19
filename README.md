 Faculty & Course Management API

A simple Spring Boot REST API for managing university faculty and courses. This project demonstrates a clean Controller–Repository structure.

---

 Features

- Manage faculty records (name, department, email, office hours, etc.)
- Manage course records (title, credits, department, prerequisites, etc.)
- RESTful endpoints for CRUD operations
- JPA/Hibernate for database integration
- Ready for PostgreSQL, H2, or any JDBC-compatible DB

---
Tech Stack

- Java 17
- Spring Boot 3
- Spring Data JPA
- Maven
-Mysql
-Lombok

---

Getting Started
Prerequisites
- Java 17+
- Maven 3.8+
- An IDE (IntelliJ, Eclipse, or VS Code)
 Setup Instructions
Prerequisites
- Java 17+
- Maven 3.8+
- Spring Boot 3.x
- (Optional) Postman or Swagger for testing

Run the Project
1. Clone the repository:
   git clone https://github.com/your-username/faculty-course-api.git

2. Navigate to the project directory:
   cd faculty-course-api

3. Run the Spring Boot application:
   ./mvnw spring-boot:run

4. The application will be available at:
   http://localhost:8080/
🔗 API Endpoints
👨‍🏫 Faculty Endpoints
Method	Endpoint	Description
GET	/faculties	Get all faculty members
GET	/faculties/{id}	Get a faculty by ID
POST	/faculties	Create new faculty
PUT	/faculties/{id}	Update faculty info
DELETE	/faculties/{id}	Delete a faculty

📘 Course Endpoints
Method	Endpoint	Description
GET	/courses	Get all courses
GET	/courses/{id}	Get a course by ID
POST	/courses	Create new course
PUT	/courses/{id}	Update course details
DELETE	/courses/{id}	Delete a course

Data Models
-Faculty
json
{
  "id": 1,
  "firstName": "Alice",
  "lastName": "Smith",
  "email": "alice.smith@university.edu",
  "department": "Physics",
  "specialization": "Astrophysics",
  "officeLocation": "Room 101",
  "officeHours": "Mon-Fri 10AM–12PM"
}
-Course
json
{
  "id": 101,
  "name": "Quantum Mechanics",
  "code": "PHY301",
  "description": "Introduction to quantum theory",
  "credits": 4,
  "department": "Physics",
  "prerequisites": "PHY201",
  "facultyId": 1
}
