# Remedial Session Homework: Secure Spring Boot API with Business Logic

## Objective

Build a RESTful API using **Spring Boot**, **Spring Security**, and **JPA**. The API must implement a real-world scenario with complex business logic, strict validation, and secure access. You are **not allowed to use AI to generate code or complete the homework**—only for debugging or fixing errors.

## Scenario

Create an API for a **Conference Management System**. The system allows users to register, submit talks, manage schedules, and interact with other participants.

## Requirements

1. **Entities & Relationships**
    - **User**: Can be a `SPEAKER` or `ATTENDEE`.
    - **Talk**: Submitted by a `SPEAKER`, includes title, abstract, duration, and tags.
    - **Schedule**: Associates talks with time slots and rooms.
    - **Room**: Has a name and capacity.
    - **Feedback**: `ATTENDEE` can leave feedback for a talk.

2. **Features**
    - **User Registration & Login** (`/auth/register`, `/auth/login`) with JWT.
    - **Role-based Access**: Only `SPEAKER` can submit talks; only `ADMIN` can manage schedules and rooms.
    - **CRUD Operations** for all entities.
    - **Business Logic**:
        - Prevent scheduling two talks in the same room at the same time.
        - Enforce room capacity for scheduled talks.
        - Validate talk duration (15-90 minutes).
        - Prevent duplicate talk titles per conference.
    - **Feedback**: Only one feedback per attendee per talk.

3. **Validation & Error Handling**
    - Use annotations for validation.
    - Return meaningful error messages and HTTP status codes.

4. **Security**
    - JWT authentication.
    - Role-based authorization.

5. **Documentation**
    - Document all endpoints with Swagger.
    - Include postman collection with example requests and responses.

6. **Testing**
    - Write unit tests for at least two business rules.

7. **Submission**
    - Push your code to a **GitHub repository** with a `README.md` (project description, setup instructions).
    - Include screenshots of Swagger UI online and test results.
    - Send to the email address provided.

## Rules

- **No AI-generated code**. You may use AI only to fix bugs or explain errors.
- All code must be original.
- Deadline: **August 01, 2025**.