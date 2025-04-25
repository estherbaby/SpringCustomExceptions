# SpringCustomExceptions

A simple Spring Boot project to explore **custom exception handling**.

This project includes:
- Custom exceptions to handle validation and mapping errors
- Global exception handling using `@ControllerAdvice`
- Utility class injection and centralized error response structures

---

## 🛠️ Install Dependencies

```bash
mvn clean install

🚀 Run the Application
mvn spring-boot:run



📮 API Endpoints
1. Create User

    Endpoint: POST /users

    Request Body:

{
  "firstName": "Esther",
  "lastName": "Bbaby",
  "email": "test@email.com",
  "password": "12345"
}

    Response:

{
  "userId": "172c7af6-d5fd-4424-9bb8-7cacb73ee77c",
  "firstName": "Esther",
  "lastName": "Bbaby",
  "email": "test@email.com"
}

2. Get User

    Endpoint: GET /users/{userId}

    Response:

{
  "userId": "172c7af6-d5fd-4424-9bb8-7cacb73ee77c",
  "firstName": "Esther",
  "lastName": "Bbaby",
  "email": "test@email.com"
}
3. Delete User

    Endpoint: DELETE /users/{userId}
    (Tip: Previously marked as GET — but should be DELETE for REST consistency)

4. Update User

    Endpoint: PUT /users/{userId}

    Request Body:

{
  "firstName": "Esther",
  "lastName": "Bbaby"
}

    Response:

{
  "userId": "172c7af6-d5fd-4424-9bb8-7cacb73ee77c",
  "firstName": "Esther",
  "lastName": "Bbaby",
  "email": "test@email.com"
}
👩‍💻 Author

Esther Baby
GitHub: @estherbaby
