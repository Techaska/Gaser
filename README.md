<p align="center">
  <img src="https://raw.githubusercontent.com/Techaska/Gaser/master/assets/gaser-banner.png" alt="Gaser: Vehicle Service Center Management System" width="100%">
</p>

<p align="center">
  A Java Spring Boot backend for managing customers, vehicles, service centers, mechanics, service jobs, and service records.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-Backend-F2B705?style=for-the-badge&logo=openjdk&logoColor=white&labelColor=153A47" alt="Java">
  <img src="https://img.shields.io/badge/Spring_Boot-Framework-F2B705?style=for-the-badge&logo=springboot&logoColor=white&labelColor=153A47" alt="Spring Boot">
  <img src="https://img.shields.io/badge/PostgreSQL-Database-F2B705?style=for-the-badge&logo=postgresql&logoColor=white&labelColor=153A47" alt="PostgreSQL">
  <img src="https://img.shields.io/badge/Status-In_Development-F2B705?style=for-the-badge&labelColor=153A47" alt="Status: In Development">
</p>

<p align="center">
  <a href="#about">About</a> •
  <a href="#architecture">Architecture</a> •
  <a href="#modules">Modules</a> •
  <a href="#api">API</a> •
  <a href="#service-flow">Service Flow</a> •
  <a href="#roadmap">Roadmap</a>
</p>

---

<a id="about"></a>

## 📌 About

Gaser digitizes the workflow between customers and vehicle service centers, from the moment a vehicle is received to the moment it is ready for collection.

It is built as a real-world Java backend using REST APIs, Spring Boot, JPA/Hibernate, request validation, and PostgreSQL.

---

<a id="architecture"></a>

## 🏗️ Architecture

Gaser follows a layered backend architecture. Requests move from the controller to the service layer, then through the repository layer and Hibernate to PostgreSQL.

<p align="center">
  <img src="https://raw.githubusercontent.com/Techaska/Gaser/master/assets/gaser-architecture.png" alt="Gaser architecture diagram" width="100%">
</p>

<details>
<summary><b>Project structure</b></summary>

<pre>
Gaser
└── src
    └── main
        └── java
            └── com.P1.Gaser
                ├── Controllers
                ├── Entity
                ├── Exception
                ├── Repositories
                └── Services

</pre>

</details>

---

## 🛠️ Tech Stack

| Technology | Purpose |
| --- | --- |
| **Java** | Backend development |
| **Spring Boot** | Application framework |
| **Spring Web** | REST APIs |
| **Spring Data JPA** | Database interaction |
| **Hibernate** | ORM |
| **PostgreSQL** | Relational database |
| **Jakarta Validation** | Request validation |
| **Lombok** | Reduces boilerplate code |
| **Maven** | Build and dependency management |
| **Postman** | API testing |
| **Git & GitHub** | Version control |

---

<a id="modules"></a>

## 📦 Modules

| Module | What it does |
| --- | --- |
| 👤 **Customer** | Manages customer information |
| 🚗 **Vehicle** | Stores vehicle details |
| 🏢 **Service Center** | Stores service center information and its mechanics |
| 🔧 **Mechanic** | Manages mechanics assigned to service operations |
| 📋 **Service Job** | Tracks each service visit from receipt to completion |
| 📝 **Service Record** | Stores the work performed during a service job |

<details>
<summary><b>Vehicle fields</b></summary>

- Registration number
- Brand
- Model
- Vehicle type
- Manufacturing year
- Kilometers driven

</details>

<details>
<summary><b>Service Job fields</b></summary>

- Service reference
- Customer
- Vehicle
- Service center
- Mechanic
- Received date/time
- Service start time
- Completion time
- Service status

</details>

---

<a id="api"></a>

## 🔌 API Endpoints

| Endpoint | Module |
| --- | --- |
| `/customers` | Customers |
| `/vehicles` | Vehicles |
| `/service-centers` | Service centers |
| `/mechanics` | Mechanics |
| `/service-jobs` | Service jobs |
| `/service-records` | Service records |
| `/notifications` | Notifications |

APIs are currently tested with Postman.

---

<a id="service-flow"></a>

## 🔄 Service Flow

| Step | What happens |
| :---: | --- |
| 1 | Customer information is registered |
| 2 | Vehicle is registered |
| 3 | Service center receives the vehicle |
| 4 | Service job is created |
| 5 | Mechanic is assigned |
| 6 | Service begins |
| 7 | Service status is updated |
| 8 | Service record is created |
| 9 | Customer is notified |
| 10 | Vehicle is ready for collection |

---

## 🚧 Current Development

- [ ] End-to-end service job workflow
- [ ] Request validation
- [ ] Global exception handling
- [ ] Service record management
- [ ] API testing
- [ ] Backend workflow improvements

---

<a id="roadmap"></a>

## 🔮 Roadmap

- [ ] 🔐 Spring Security authentication and authorization
  - Customer authentication
  - Service center authentication
  - Protected REST endpoints
- [ ] 👥 Role-based access control
- [ ] 📧 Email notifications
- [ ] 📱 SMS notifications
- [ ] 🧾 PDF invoice generation
- [ ] 🔎 Vehicle registration number search
- [ ] 🖥️ Frontend integration
- [ ] ☁️ Cloud deployment

---

## 🎯 Project Objective

Gaser shows how a real-world service center workflow can be turned into a structured software system. It is also a hands-on learning project for:

`Java backend development` · `Spring Boot` · `REST API design` · `Database design` · `JPA/Hibernate` · `Validation` · `Exception handling` · `Software architecture`

---

## 👨‍💻 Author

**Akash**, Java Backend Developer | Spring Boot | PostgreSQL | REST APIs

[

![GitHub](https://img.shields.io/badge/GitHub-Techaska-F2B705?style=flat-square&logo=github&logoColor=white&labelColor=153A47)

](https://github.com/Techaska)

---

<p align="center">
  ⭐ If you find the project useful, feel free to explore the code and follow the development.
</p>
