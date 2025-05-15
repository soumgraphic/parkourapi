# Parkour API

## Overview

The **Parkour API** is a project developed collaboratively with students from Brest and Angers, France, as part of our classes at **Global Open Campus**. This API is designed to provide a platform for parkour enthusiasts to connect, share experiences, and learn new techniques. It includes modern features such as **Mistral AI integration**, **JWT-based authentication and authorization**, **role-based access control**, **error handling**, and more.

This project demonstrates the practical application of API development concepts, including database management, AI-powered features, and secure API design.

---

## Features

- **User Management**: CRUD operations for users with role-based access control (`USER`, `ADMIN`).
- **Authentication and Authorization**: Secure endpoints using **JWT tokens**.
- **AI-Powered Suggestions**: Integration with **Mistral AI** for generating parkour exercise suggestions.
- **Error Handling**: Meaningful error messages and appropriate HTTP status codes.
- **H2 In-Memory Database**: For development and testing purposes.
- **Pagination**: Implemented for endpoints returning lists of data.
- **Swagger Documentation**: API documentation available via Swagger UI.
- **Postman Collection**: Exported collection for testing API endpoints.

---

## Prerequisites

Before running the project, ensure you have the following installed:

- **Java 17** or higher
- **Gradle** (for dependency management)
- **Postman** (optional, for testing API endpoints)

---

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/soumgraphic/parkourapi.git
cd parkourapi
```

### 2. Configure the Mistral AI API Key and JWT Secret

Replace the placeholder `api-key` and `jwt.secret` in the `src/main/resources/application.yaml` file with your **Mistral AI API key** and a secure **JWT secret**:

```yaml
ai:
  mistralai:
    api-key: YOUR_MISTRAL_API_KEY

jwt:
  secret: YOUR_SECURE_JWT_SECRET
```

### 3. Build and Run the Application

Use Gradle to build and run the application:

```bash
./gradlew bootRun
```
The application will start on http://localhost:8080.

### 4. Access the H2 Database Console

The H2 database console is available at `http://localhost:8080/h2-console`. Use the following credentials:

- **JDBC URL**: `jdbc:h2:mem:parkourapidb`
- **Username**: `sa`
- **Password**: (leave blank)

### 5. Access Swagger Documentation

Swagger UI is available at `http://localhost:8080/swagger-ui.html`. It provides detailed documentation of all API endpoints.

### 6. Test the API with Postman
You can import the provided Postman collection to test the API endpoints. The collection includes sample requests and responses for all available endpoints.

### 7. Deploy the API
The API can be deployed to platforms like **Railway**, **Heroku**, or **Vercel**. Follow the respective platform's documentation for deployment instructions.

---

## Contributing

Contributions are welcome! If you'd like to contribute, please fork the repository and submit a pull request.

---

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---

## Acknowledgments

Special thanks to the students from Brest and Angers, France, for their collaboration and dedication to this project. This API was built as part of our classes at **Global Open Campus**.
