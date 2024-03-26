# Spring Boot Project with AOP, JPA, Hibernate, and REST

## Description
This project is a Spring Boot application that demonstrates the use of Aspect-Oriented Programming (AOP), Java Persistence API (JPA), Hibernate, and RESTful services.

## Features
- Implements controllers for managing customers and accounts.
- Uses AOP for cross-cutting concerns such as logging, security, etc.
- Utilizes JPA and Hibernate for database operations.
- Provides RESTful endpoints for creating, retrieving, updating, and deleting resources.

## Installation
1. Clone the repository.
2. Build the project using Maven or your preferred build tool.
3. Configure the database connection settings in `application.properties`.
4. Run the application.

## Usage
- Use the provided RESTful endpoints to interact with the application.
- See controller classes (`CustomerController` and `AccountController`) for available endpoints and their mappings.

## Controllers
### CustomerController
- Manages operations related to customers.
  - `POST /customer`: Create a new customer.
  - `GET /customer/{id}`: Retrieve customer details by ID.
  - `PUT /customer/{id}`: Update customer details.

### AccountController
- Manages operations related to accounts.
  - `POST /account`: Create a new account.
  - `GET /account/{accountNumber}`: Retrieve account details by account number.
  - `PUT /account/{accountNumber}/deposit`: Deposit funds into an account.
  - `PUT /account/{accountNumber}/withdraw`: Withdraw funds from an account.



### AccountController
- Manages operations related to accounts.
  - `PUT /account/{accountNumber}/inactivate`: Inactivate an account.

## Dependencies
- Spring Boot
- Spring Data JPA
- Hibernate
- Spring Web
- Spring AOP


## Configuration
- Modify `application.properties` to configure your database connection settings.




