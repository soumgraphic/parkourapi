# Homework: Build Your Own API with Spring boot, JPA, Mistral AI, Swagger, and Deployment

## Objective

Your task is to design and build an API similar to the **Parkour API** we studied in class, but with your own unique concept. The goal is to apply the knowledge you have gained about API development, including the integration of Mistral AI, Swagger documentation, and deployment to a platform like **Railway or Heroku** or an alternative.

## Requirements

1. **Concept**:
    - Choose a unique concept for your API. You may take inspiration from the **Parkour API**, but you must not replicate it. Examples of concepts could include:
        - A library management system.
        - A fitness tracking app.
        - A recipe sharing platform.
        - A travel itinerary planner.
        - A gaming leaderboard system.

2. **Features**:
    - Your API must have at least **6 resources** (e.g., users, items, categories, etc.) with CRUD (GET, POST, PUT, DELETE) services minimum.
    - There must be **relationships** between these resources (e.g., a user can have multiple items, a category can have multiple recipes, etc.).
    - Implement **authentication and authorization** using JWT.
    - Define roles such as `USER` and `ADMIN`, etc.
    - Secure endpoints with role-based access control.
    - Include **AI-powered features** using **Mistral AI** (e.g., suggestions, chat, or other creative uses).
    - Provide **error handling** with meaningful error messages and appropriate HTTP status codes.
    - Validate inputs using annotations (e.g., `@NotNull`, `@Size`, etc.).
    - Implement **pagination** for endpoints that return lists of data.

3. **Documentation**:
    - Use **Swagger** to document your API.
    - Annotate your controllers and methods with Swagger annotations.

4. **Deployment**:
    - Deploy your API to **Railway** or an alternative platform (e.g., Render, Heroku, etc.).
    - Ensure the deployed API is accessible via a public URL.

5. **Postman Export**:
    - Create a **Postman collection** for your API.
    - Include sample data and example requests for all endpoints.
    - Export the collection and include it in your project repository.

6. **GitHub Repository**:
    - Share your project in a **GitHub repository**.
    - Include a `README.md` file with:
        - A description of your API.
        - Instructions for running the project locally.
        - The public URL of your deployed API.
        - A link to the Postman collection.
    - Send the link to your repository to the specified email address.

7. **Rules**:
    - You may use AI to **fix issues** in your code, but you must not use AI to complete the homework.
    - Your work must be original and not copied from others.
   
8. **Submission and Deadline**:
   - The deadline for submission is **June 27, 2025**.
   - Submit your GitHub repository link to the specified email address.

---

## Example: Parkour API Specification (Studied in Class)

### Presentation of Parkour

Parkour is a training discipline using movement that developed from military obstacle course training. Practitioners aim to get from one point to another in a complex environment, without assistive equipment and in the fastest and most efficient way possible. Parkour includes running, climbing, swinging, vaulting, jumping, plyometrics, rolling, and other movements as deemed most suitable for the situation.

### Needs of the Parkour API

The Parkour API aims to provide a platform for parkour enthusiasts to connect, share experiences, and learn new techniques. The API will allow users to:
- Invite friends to parkour locations.
- Share parkour examples and experiences through videos and pictures.
- Invite newcomers to start practicing parkour.
- Get AI-generated suggestions for parkour exercises.
- Securely manage user authentication and authorization.
- Handle errors, validate inputs, and provide paginated responses.
- Document the API using Swagger.

### API Specification

#### Authentication and Authorization
- **POST /auth/register**: Register a new user
    - Request Body: `{ "username": "string", "password": "string", "email": "string" }`
    - Response: `{ "message": "User registered successfully" }`
- **POST /auth/login**: Login and get a JWT token
    - Request Body: `{ "username": "string", "password": "string" }`
    - Response: `{ "token": "jwt_token" }`

#### Users
- **GET /users**: Get a list of users (Admin only)
    - Query Parameters: `page`, `size`
    - Response: `[{ "id": "number", "username": "string", "email": "string" }]`
- **GET /users/{id}**: Get user details by ID
    - Path Parameters: `id`
    - Response: `{ "id": "number", "username": "string", "email": "string" }`

#### Friends
- **POST /friends/invite**: Invite a friend to a location
    - Request Body: `{ "friendId": "number", "location": "string", "date": "string" }`
    - Response: `{ "message": "Invitation sent" }`
- **GET /friends/invitations**: Get a list of invitations
    - Query Parameters: `page`, `size`
    - Response: `[{ "id": "number", "friendId": "number", "location": "string", "date": "string" }]`

#### Parkour Examples
- **POST /examples**: Add a new parkour example (Admin only)
    - Request Body: `{ "title": "string", "description": "string", "videoUrl": "string" }`
    - Response: `{ "message": "Example added" }`
- **GET /examples**: Get a list of parkour examples
    - Query Parameters: `page`, `size`
    - Response: `[{ "id": "number", "title": "string", "description": "string", "videoUrl": "string" }]`

#### Experiences
- **POST /experiences**: Share an experience
    - Request Body: `{ "title": "string", "description": "string", "mediaUrl": "string" }`
    - Response: `{ "message": "Experience shared" }`
- **GET /experiences**: Get a list of shared experiences
    - Query Parameters: `page`, `size`
    - Response: `[{ "id": "number", "title": "string", "description": "string", "mediaUrl": "string" }]`

#### Newcomers
- **POST /newcomers/invite**: Invite a newcomer to start parkour
    - Request Body: `{ "newcomerId": "number", "message": "string" }`
    - Response: `{ "message": "Invitation sent" }`
- **GET /newcomers/invitations**: Get a list of newcomer invitations
    - Query Parameters: `page`, `size`
    - Response: `[{ "id": "number", "newcomerId": "number", "message": "string" }]`

#### AI Suggestions
- **GET /ai/suggestions**: Get parkour exercise suggestions
    - Query Parameters: `groupId`
    - Response: `[{ "id": "number", "exercise": "string", "description": "string" }]`

#### Security
- Use JWT for authentication.
- Define roles such as `USER` and `ADMIN`.
- Secure endpoints with role-based access control.

#### Error Handling
- Return appropriate HTTP status codes (e.g., 400 for bad requests, 401 for unauthorized, 404 for not found).
- Provide meaningful error messages in the response body.

#### Input Validations
- Validate request bodies and parameters using annotations (e.g., `@NotNull`, `@Size`, `@Email`).

#### Pagination
- Use query parameters `page` and `size` for paginated endpoints.

#### Documentation
- Use Swagger for API documentation.
- Annotate controllers and methods with Swagger annotations.

This specification provides a comprehensive overview of the API routes and parameters needed for your Parkour API.

### Ressources
- Documenting a spring rest API using OpenAPI and Swagger 3: 
  - https://www.baeldung.com/spring-rest-openapi-documentation