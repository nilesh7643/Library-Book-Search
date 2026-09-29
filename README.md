# Library-Book-Search
Library Book Search System is a full-stack web application developed to demonstrate the practical use of Data Structures and Algorithms (DSA) in a real-world library search system. The project provides a simple and user-friendly interface for searching books by title, author, and category.

The frontend is developed using HTML, CSS, and JavaScript, providing an interactive interface where users can select the required search method, enter a search value, and view book details. The frontend communicates with the backend through HTTP REST API requests.

The backend is developed using Java and Spring Boot. It provides REST APIs for retrieving all books and searching books based on different criteria. The project stores book information in an in-memory Java List, so no external database is required.

The main focus of the project is the implementation of two DSA techniques:

Binary Search: Used for searching books by title. Books are maintained in sorted order by title, allowing the search space to be reduced by half during each iteration. This provides a time complexity of O(log n).
HashMap: Used for searching books by author and category. Author and category values are used as keys, with corresponding books stored as values. HashMap provides approximately O(1) average-time lookup.

The project follows a simple architecture:

User → Frontend → REST API → Spring Boot Backend → Search Algorithm → Book Result → Frontend

The application also demonstrates the separation between the presentation layer and business/search logic, making the project easy to understand and extend.

Technologies Used
Frontend: HTML, CSS, JavaScript
Backend: Java, Spring Boot
DSA: Binary Search, HashMap
API: REST API
Build Tool: Maven
Data Storage: In-memory Java List
IDE: IntelliJ IDEA

This project demonstrates how fundamental DSA concepts can be integrated with modern web development to create an efficient and practical application.
