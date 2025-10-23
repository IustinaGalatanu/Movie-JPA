#  MovieJPA — README

**MovieJPA** is a Spring Boot REST API built with **Java 21** for managing movies, directors, actors, and genres.  
It demonstrates real-world backend development using **Spring Data JPA**, **Hibernate**, and **JavaMailSender**, with DTO mapping, relationship handling, and transactional logic.

---

##  Overview

The API allows users to:
- Add, update, delete, and retrieve movies  
- Automatically link movies to genres, directors, and actors (creating them if missing)  
- Retrieve watched movies or movies with ratings above a given value  
- Add movies to a personal watchlist and receive an email notification  
- Manage full entity relationships (OneToOne, ManyToOne, ManyToMany)

---

##  Technologies

| Layer | Technology |
|--------|-------------|
| Language | Java 21 |
| Framework | Spring Boot 3.x |
| ORM | Spring Data JPA + Hibernate |
| Database | H2 (for testing) / PostgreSQL |
| Email | Spring Boot Starter Mail |
| Build Tool | Maven |
| Testing | JUnit 5, Mockito |
| Extras | Lombok, DTO mapping |

---

##  Core Features

- **Movies**
  - `POST /api/movies` → create a new movie from DTO  
  - `GET /api/movies` → list all movies  
  - `GET /api/movies/{id}` → get movie by ID  
  - `DELETE /api/movies/{id}` → delete a movie  
  - `GET /api/movies/watched` → all watched movies  
  - `GET /api/movies/rating/{rating}` → movies above given rating  

- **Watchlist**
  - `PUT /api/movies/watchList/{id}?email=your@email.com`  
    Adds a movie to a user’s watchlist and sends an email notification.  

- **Entities**
  - `Movie` ↔ `MovieDetails` → OneToOne  
  - `Movie` ↔ `Director`, `Genre` → ManyToOne  
  - `Movie` ↔ `Actor` → ManyToMany  

---

##  Email Integration

The service uses `JavaMailSender` to send a confirmation email whenever a user adds a movie to their watchlist.  
If the email cannot be sent, the system throws a `ServiceException` but the movie is still updated.


---

##  Run Locally

### Requirements
- Java 21+
- Maven 3.5.6

  Accesss API: `http://localhost:8080`

  ### Exemples API request
  
  #### Create a new movie

`POST /api/movies`
Body JSON:
```json
{
  "title": "Inception",
  "releaseYear": 2010,
  "rating": 8.8,
  "watched": true,
  "genreName": "Sci-Fi",
  "directorName": "Christopher Nolan",
  "actorNames": ["Leonardo DiCaprio", "Joseph Gordon-Levitt"],
  "duration": 148,
  "language": "English",
  "synopsis": "A skilled thief who enters dreams to steal secrets."
}
  ```
  #### Get watched movies
`GET /api/movies/watched` 
  #### Get movies above rating 8
`GET /api/movies/rating/8` 
  #### Add movie to watchlist and send email
`PUT /api/movies/watchList/1?email=john@example.com` 

### Steps
```bash
git clone https://github.com/<username>/MovieJPA.git
cd MovieJPA
mvn spring-boot:run

