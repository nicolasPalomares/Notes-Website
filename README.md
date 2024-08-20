PRECONDITION: If the user wants to execute the program, it is necessary to configure the database first. For this, I exported an SQL file
with all the tables and data originally created from my PostgreSQL software. That file is located inside "psql_database_backup" folder inside the project directory.
Load it inside any SQL database software, and then complete the "application.properties" file with your database credentials.
 
In this web application, after login in with the corresponding credentials (USER: testUser, PASSWORD: username5678), the user is able to introduce contacts with name, phone number
and e-mail (optional), and notes or reminders with date and time (optional), a title and a desctiption.
If there is no user logged in, the index page will only show the contacts and notes from the database. After logging in, the user can add new contacts and notes/reminders, edit or
delete existing ones.
 
Key Features:
- User/Admin authentication and authorization ensure secure access to the system.
- Spring Security provides robust authentication and authorization mechanisms.
- Hibernate ORM simplifies database interactions, ensuring data integrity.
- Thymeleaf templates facilitate dynamic web page rendering.
- RESTful APIs are utilized for seamless integration with front-end applications.
- Enhanced UI components with Bootstrap and CSS.
- Predefined styling classes for forms, buttons, and other UI components.
- Responsive design.

Architecture:
This application follows the Model-View-Controller (MVC) architecture pattern, with Spring Boot providing the framework for rapid development and deployment.
- Controller handles incoming HTTP requests, routes them to the appropiate services, and returns responses to clients.
- Services and DAO classes encapsulate business logic and interact with repositories for database operations.
- Entities represent database elements and are mapped to Java objects.
- HTML pages represent the View layer for every logic operation.

External Dependencies:
- PostgreSQL database for persistence storage of student (including address and contact), course, assignment, user and role (USER, ADMIN) data.
- Spring Boot Starter Web for building web applications (using Spring Tools 4 plugin).
- Spring Data JPA for simplifying database access.
- Spring Security for implementing authentication and authorization.
- Spring Boot Starter Validation for validating data in the application.

Screenshots:

Index page:
![indexBefore](https://github.com/nicolasPalomares/Notes-Website/assets/106792719/e5fd3505-8f60-496c-8561-a0d5d5b9836b)

Login page:
![login](https://github.com/nicolasPalomares/Notes-Website/assets/106792719/804824cf-5c24-427f-9f3b-3944ff187f4d)

Index page after logging in:
![indexAfter](https://github.com/nicolasPalomares/Notes-Website/assets/106792719/e54803be-c980-4f20-9f80-52a27ced4d38)

New entries can be added through a modal window:
![add](https://github.com/nicolasPalomares/Notes-Website/assets/106792719/7c7a16e6-1158-4bfd-91ca-dda941ec4538)

Edit page:
![edit](https://github.com/nicolasPalomares/Notes-Website/assets/106792719/0a8061b0-b5ba-4703-be39-2eb67d7f036b)


- JDK 21
