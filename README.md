# 🏗 TaskFlow – Task & Project Management API

**TaskFlow** is a Java Spring Boot–powered backend application designed for efficient task and project management. It features secure authentication, role-based access control, email notifications, and clean RESTful API design.

📄 **API Documentation**: [SwaggerHub – TaskFlow API](https://app.swaggerhub.com/apis/ujaval/TaskFlow-APi/1.0.0#/)

---

## 📌 Project Feature Highlights

### 1️⃣ Spring Boot Framework
- ✅ Rapid backend development using Spring Boot with modular, maintainable architecture.
- ✅ Built-in support for RESTful APIs and easy integration with databases.

### 2️⃣ Spring Security Integration
- ✅ Robust security layer applied to all endpoints.
- ✅ Seamless integration of JWT (JSON Web Token) for stateless, scalable authentication.
- ✅ Secure access to protected resources without relying on server-side sessions.

### 3️⃣ JWT Token-Based Authentication
- ✅ Clients authenticate using signed JWT tokens after login.
- ✅ Each request carries the token for validation, ensuring stateless API communication.
- ✅ Tokens carry embedded claims like user roles and permissions.

### 4️⃣ Role-Based Authorization
- ✅ Fine-grained access control based on user roles (e.g., `MANAGER`, `USER`).
- ✅ Only managers can create, update, or delete projects and tasks.
- ✅ Regular users have restricted access, ensuring data and action security.

### 5️⃣ Email Notification Service
- ✅ Integrated email service using **JavaMailSender** or services like **SendGrid** for:
  - Task assignment notifications  
  - Password reset emails  
  - Important project updates  
- ✅ Asynchronous email dispatch to avoid blocking API performance.

### 6️⃣ Clean Code & Best Practices
- ✅ Clear package structuring: separation of controllers, services, repositories, and models.
- ✅ Exception handling using `@ControllerAdvice` and custom exceptions.
- ✅ DTO usage for data transfer, keeping entities isolated from API layers.

### 7️⃣ Lombok for Boilerplate Reduction
- ✅ Use of Lombok annotations (`@Getter`, `@Setter`, `@Builder`, `@AllArgsConstructor`, etc.)
- ✅ Reduces repetitive code, making the codebase cleaner.

### 8️⃣ Password Encoding & Security
- ✅ User passwords stored securely using Spring Security’s `PasswordEncoder` (e.g., `BCryptPasswordEncoder`).
- ✅ Prevents storing or transmitting raw passwords.

### 9️⃣ Manager-Restricted Resource Creation
- ✅ Strong backend checks ensuring only users with `MANAGER` role can add:
  - New projects  
  - New tasks  
- ✅ This is enforced at the security layer, not just at the frontend.

---

## 🚀 Tech Stack

- Java 17  
- Spring Boot  
- Spring Data JPA  
- MySQL  
- Spring Security (JWT)  
- Lombok  
- Railway Cloud  
- Stream API / Lambda  
- Maven  
- Hibernate  
- Swagger / OpenAPI  
- Postman / JUnit  

---

## 🔒 Authentication & Authorization

- Uses **JWT (JSON Web Tokens)** for secure, stateless authentication.
- Only `/register` and `/login` endpoints are publicly accessible.
- All other endpoints are protected and require valid authentication tokens.
- Role-based access:
  - **Manager**: Can add and retrieve projects.
  - **Users**: Can retrieve assigned tasks only.

---

## ✉ Email Notifications

- Automatic email notifications for:
  - Task or project assignment  
  - Password reset  
- Email sending is asynchronous and non-blocking.

---

## 📚 Core Features

- ✅ Register and log in securely  
- ✅ Create, retrieve, update, delete tasks  
- ✅ Manager-specific: Add and manage projects  
- ✅ Role-based API access control  
- ✅ Email notifications for assignments  
- ✅ API documentation via Swagger UI  
 ---
 
## ⚙ Setup Instructions

### 1️⃣ Clone the repository
```bash
git clone https://github.com/your-username/taskflow.git
cd taskflow
```

### 2️⃣ Configure the database
Update `application.properties` with your MySQL database details.

### 3️⃣ Run the application
```bash
./mvnw spring-boot:run
```

### 4️⃣ Access Swagger UI
Navigate to: 
```
http://localhost:8080/swagger-ui.html
```

### 5️⃣ Test APIs in Postman
Import the Swagger/OpenAPI JSON or use the documented endpoints.

---

## 🛡 Security Notes

- All sensitive endpoints are fully protected.
- Only authenticated users with appropriate roles can access task or project data.
- JWT tokens are required in the Authorization header for protected requests.

---

## ✨ Future Improvements (optional)
- Add user dashboards
- Implement project/task deadlines and reminders
- Add admin-level reporting or analytics
- Improve email templates and notifications

