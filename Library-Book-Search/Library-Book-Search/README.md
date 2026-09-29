# Library Book Search

A minor project using:
- Frontend: HTML, CSS, JavaScript
- Backend: Java Spring Boot
- Title search: Binary Search
- Author/category search: HashMap
- Storage: In-memory Java List (no database)

## Requirements
- JDK 17+
- Maven 3.9+
- VS Code or IntelliJ IDEA

## Run backend

Open a terminal:

```bash
cd backend
mvn spring-boot:run
```

Backend runs at:
http://localhost:8080

Test:
http://localhost:8080/api/books

## Run frontend

Open `frontend/index.html` in a browser.

If your browser blocks local files, use VS Code Live Server:
1. Install the Live Server extension.
2. Right-click `frontend/index.html`.
3. Select "Open with Live Server".

The frontend calls:
http://localhost:8080/api/books

## Search
- Title -> Binary Search
- Author -> HashMap
- Category -> HashMap

Title search is exact-match and case-insensitive.
Author/category search is exact-match and case-insensitive.
