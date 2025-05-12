# 🏗 **TaskFlow – Task & Project Management API**

TaskFlow is a **Java Spring Boot**–powered backend application designed for efficient task and project management. It features secure authentication, role-based access control, email notifications, and clean RESTful API design.

## 🔑 Key Features & Technologies

### ✅ **Spring Boot**  
Developed a modular and scalable backend using **Spring Boot**, providing a solid foundation for building RESTful APIs.

### ✅ **JWT Authentication**  
Implemented **JWT (JSON Web Token)** authentication for secure, stateless user sessions, ensuring only authorized users can access protected endpoints.

### ✅ **Spring Security**  
Utilized **Spring Security** to enforce **role-based access control (RBAC)**, securing sensitive operations with defined roles like `MANAGER` and `ADMIN`.

### ✅ **JPA & Hibernate**  
Leveraged **Java Persistence API (JPA)** and **Hibernate ORM** to efficiently interact with the database, managing entity mappings and data relationships seamlessly.

### ✅ **Project Lombok & Maven**  
Reduced boilerplate code using **Project Lombok** annotations, enhancing code maintainability. Managed project dependencies and build configuration with **Maven**.

### ✅ **Postman, JUnit & Swagger**  
Tested and validated API endpoints using **Postman**, ensuring functionality and reliability. **JUnit** was used for unit testing, and **Swagger** provided a developer-friendly interface to explore and document the APIs.

### ✅ **Stream API & Lambda Expressions**  
Applied modern Java features like **Stream API** and **Lambda Expressions** for clean, efficient data processing and filtering logic.

### ✅ **Railway Cloud Deployment**  
Deployed the application on **Railway Cloud**, ensuring reliable and scalable cloud hosting with minimal configuration for seamless operation.

---

## 🚀 **Tech Stack**
- **Java 17**  
- **Spring Boot**  
- **Spring Data JPA**  
- **MySQL**  
- **Spring Security** (with JWT)  
- **Lombok**  
- **Railway Cloud**  
- **Maven**  
- **Hibernate**  
- **Swagger / OpenAPI**  
- **Postman/Junit** (for API testing)

---

## 🔒 **Authentication & Authorization**
- Uses **JWT** (JSON Web Tokens) for secure, stateless authentication.  
- Only **/register** and **/login** endpoints are publicly accessible.  
- All other endpoints are protected and require valid authentication tokens.  
- Role-based access:  
  - **Manager**: can add and retrieve projects.  
  - **Other users**: can retrieve assigned tasks.

---

## ✉ **Email Notifications**
- When a **task** or **project** is assigned, the system automatically sends an email notification to the assignee.

---

## 📚 **Core Features**
✅ Register and log in securely  
✅ Create, retrieve, update, delete tasks  
✅ Manager-specific: add and manage projects  
✅ Role-based API access control  
✅ Email notifications for assignments  
✅ API documentation via Swagger UI

---

## ⚙ **Setup Instructions**

1️⃣ **Clone the repository**
bash
git clone https://github.com/your-username/taskflow.git
cd taskflow


2️⃣ **Configure the database**
- Update application.properties with your MySQL database details.

3️⃣ **Run the application**
bash
./mvnw spring-boot:run


4️⃣ **Access Swagger UI**
- Navigate to: http://localhost:8080/swagger-ui.html

5️⃣ **Test APIs in Postman**
- Import the Swagger/OpenAPI JSON or use the documented endpoints.

---

## 🛡 **Security Notes**
- All sensitive endpoints are fully protected.  
- Only authenticated users with appropriate roles can access task or project data.  
- JWT tokens are required in the Authorization header for protected requests.

---

## ✨ **Future Improvements (optional)**
- Add user dashboards  
- Implement project/task deadlines and reminders  
- Add admin-level reporting or analytics  
- Improve email templates and notifications

---
