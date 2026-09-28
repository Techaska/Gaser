# 🚗 Gaser — Vehicle Service Center Management System

> Status: 🚧 In Development | Author: Akash | Tech Stack: Java, Spring Boot, PostgreSQL

Gaser is a robust, layered backend application built to streamline and automate vehicle service center workflows—ranging from customer and vehicle registration to tracking service jobs, mechanics, and generating service records.

---

## 🏗️ System Workflow

The core operational pipeline managed by Gaser flows seamlessly from intake to notification:

Customer ──> Vehicle ──> Service Center ──> Service Job ──> Mechanic ──> Service Record ──> Notification

---

## 🏛️ Architecture & Tech Stack

Gaser follows a strict **layered Spring Boot architecture**, ensuring clean separation of concerns and maintainability:

[ Client / Postman ] 
        ↓
[ REST Controller ] 
        ↓
[ Service Layer ] 
        ↓
[ Repository Layer ] 
        ↓
[ Spring Data JPA / Hibernate ] 
        ↓
[ PostgreSQL Database ]

Core Technologies

Technology         Purpose
Java               Backend programming
Spring Boot        Application framework
Spring Web         REST API development
Spring Data JPA    Database interaction
Hibernate          ORM
PostgreSQL         Relational database
Maven              Build and dependency management
Jakarta Validation Request validation
Lombok             Reducing Java boilerplate
Postman            API testing
Git                Version control
GitHub             Source-code management

---

📦 Implemented Modules & Endpoints

The project currently features fully structured domain entities, repositories, services, and REST controllers across the following endpoints:

* 📂/customer — Customer profile and information management
* 🚙/vehicle — Vehicle metadata (number, brand, model, type, year, kilometers driven)
* 🏢/service-center — Center details, contact info, and associated mechanics
* 🔧/mechanic — Mechanic profiles tied to service operations
* 📋/service-job — Comprehensive service visits (tracking reference, timestamps, status, and assignments)
* 📝/service-record — Detailed logs of work performed during service jobs
* 🔔/notificatio — Structured scaffolding for customer alerts

---

## 🚀 Project Structure

Gaser
├── src
│   ├── main
│   │   └── java
│   │       └── com.P1.Gaser
│   │           ├── Controllers  # REST endpoints & request routing
│   │           ├── Entity       # Domain models mapped to PostgreSQL
│   │           ├── Exception    # Global exception handling & custom errors
│   │           ├── Repositories # Spring Data JPA interfaces
│   │           └── Services     # Business logic coordination
│   │
│   └── test                     # Automated test suites
├── .gitignore
├── pom.xml
└── mvnw / mvnw.cmd

---

## 🎯 Current Focus & Roadmap

 🔄 In Progress

* Completing end-to-end service job workflows
* Enhancing business validations and global error handling
* Expanding service-record tracking capabilities

 🔮 Planned Features

* [ ] Customer & service-center authentication and role-based access control (RBAC)
* [ ] Automated customer notifications via Email & SMS integration
* [ ] PDF Invoice generation for completed jobs
* [ ] Advanced search capabilities (e.g., lookup by vehicle registration number)
* [ ] Full-stack frontend integration and cloud deployment

---

Gaser serves as a practical, production-oriented project showcasing modern Java & Spring Boot backend engineering best practices.
