# **🧭 Currency Conversion Microservices Project**

---

## 💡 **Overview**
A distributed Spring Boot microservices project demonstrating service discovery, API gateway routing, Feign-based inter-service communication, Redis caching, Zipkin tracing, and centralized monitoring.

---

## 🚀 **Tech Stack**
| **Component**                   | **Technology**                 |
| ------------------------------ | ------------------------------ |
| ☕ **Backend Framework**        | Spring Boot 3+                 |
| 🔗 **Inter-Service Communication** | OpenFeign                  |
| ⚙️ **Service Discovery**        | Netflix Eureka                 |
| 🌉 **API Gateway**              | Spring Cloud Gateway (WebFlux) |
| 🧠 **Caching**                  | Redis                          |
| 📡 **Distributed Tracing**      | Zipkin + Micrometer            |
| 🧾 **Monitoring**               | Spring Boot Admin              |
| 🗃️ **Database**                 | MySQL                          |
| 🧰 **Build Tool**               | Maven                          |
| 🐳 **Runtime**                  | Java 17+                       |

---

## 📁 **Folder Structure**

Currency-microservices/
│
├── eureka-server/                    # Service Discovery (Eureka)
│   ├── src/main/java/com/sathya/eureka/
│   └── src/main/resources/application.properties
│
├── api-gateway/                      # Gateway Routing Layer (Spring Cloud Gateway + WebFlux)
│   ├── src/main/java/com/sathya/gateway/
│   └── src/main/resources/application.properties
│
├── currency-exchange-service/        # Provides exchange rate data
│   ├── src/main/java/com/sathya/exchange/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   └── model/
│   └── src/main/resources/application.properties
│
├── currency-conversion-service/      # Uses Feign to call Exchange + Redis cache for results
│   ├── src/main/java/com/sathya/conversion/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── dto/
│   │   └── config/                   # CacheConfig.java
│   └── src/main/resources/application.properties
│
├── redis-cache-service/              # (optional standalone Redis setup or Docker config)
│   └── Dockerfile or redis.conf
│
├── admin-server/                     # Spring Boot Admin dashboard for monitoring
│   ├── src/main/java/com/sathya/admin/
│   └── src/main/resources/application.properties
│
├── zipkin-server/                    # Distributed tracing collector (Zipkin)
│   └── docker-compose.yml
│
├── pom.xml                           # Parent POM (if using multi-module)
├── README.md                         # Project Documentation
└── screenshots/                      # Optional: add images of Zipkin & Admin dashboards


## 🧩**Microservice Architecture**
| Service                            | Port | Responsibility                              |
| ---------------------------------- | ---- | ------------------------------------------- |
| 🗺️ **Eureka Server**              | 8761 | Service Discovery & Registration            |
| 🌉 **API Gateway**                 | 8080 | Routes requests to downstream services      |
| 💱 **Currency Exchange Service**   | 8005 | Provides currency exchange rates            |
| 🔄 **Currency Conversion Service** | 8006 | Converts currency using Feign + Redis Cache |
| 🧰 **Redis Cache Server**          | 6379 | Stores cached conversion results            |
| 📈 **Zipkin Server**               | 9411 | Distributed tracing for all microservices   |
| 🖥️ **Spring Boot Admin Server**   | 9000 | Monitors and manages all microservices      |




---

## ⚙️ **Project Flow**
1. Request hits API Gateway → `/api/v1/conversion`
2. Routed to Currency Conversion Service
3. Feign Client calls Currency Exchange Service
4. Result calculated and cached in Redis
5. Tracing sent to Zipkin, health to Admin Server

---

## 🧮 **Caching Behavior**
- First request: DB + Redis store
- Subsequent requests: Redis cache
- TTL: 10 minutes (configurable)

---

## 🖼️ **Screenshots**
### 🧩 Eureka Server
![Eureka Server](Screenshots/eureka-server.png)

### 🧩 Admin Server
![Admin Server](Screenshots/admin-server.png)

### 🧩 Conversion Service (Postman Test)
![Conversion Postman](Screenshots/conversion-postman.png)

### 🧩 Zipkin Server
![Zipkin Server](Screenshots/zipkin-server.png)




