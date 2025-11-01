🧭 Currency Conversion Microservices Project
💡 Overview

A fully functional Spring Boot Microservices Project built with a distributed architecture — demonstrating service discovery, API gateway routing, inter-service communication (Feign Client), centralized configuration, Redis caching, distributed tracing (Zipkin), and Spring Boot Admin monitoring.


🚀 Tech Stack

| Component                      | Technology                     |
| ------------------------------ | ------------------------------ |
| ☕ Backend Framework           | Spring Boot 3+                 |
| 🔗 Inter-Service Communication | OpenFeign                      |
| ⚙️ Service Discovery           | Netflix Eureka                 |
| 🌉 API Gateway                 | Spring Cloud Gateway (WebFlux) |
| 🧠 Caching                     | Redis                          |
| 📡 Distributed Tracing         | Zipkin + Micrometer            |
| 🧾 Centralized Monitoring      | Spring Boot Admin              |
| 🗃️ Database                    | MySQL (for Conversion records) |
| 🧰 Build Tool                  | Maven                          |
| 🐳 Runtime                     | Java 17+                       |


🧩 Architecture Overview

+------------------------+
|  API Gateway (8080)    |
|  - Routes all traffic  |
+-----------+------------+
            |
            v
+------------------------+       +------------------------+
| Currency Service (8005)| <---> | Conversion Service (8006) |
| Provides exchange rates|       | Converts currency using Feign |
+-----------+------------+       +------------------------+
            |
            v
+------------------------+
| Eureka Server (8761)   |
| Service Discovery       |
+------------------------+
            |
            v
+------------------------+       +------------------------+
| Admin Server (9000)    |       | Zipkin Server (9411)    |
| Monitoring Dashboard   |       | Distributed Tracing      |
+------------------------+       +------------------------+


📁 Folder Structure
currency-microservices/
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
├── redis-cache-service/              # (standalone Redis setup or Docker config)
│   └── Dockerfile or redis.conf
│
├── admin-server/                     # Spring Boot Admin dashboard for monitoring
│   ├── src/main/java/com/sathya/admin/
│   └── src/main/resources/application.properties
│
├── zipkin-server/                    # Distributed tracing collector (Zipkin)
│   └── docker-compose.yml
│
└── screenshots/                     



🧩 Microservice Architecture

| Service                            | Port | Responsibility                              |
| ---------------------------------- | ---- | ------------------------------------------- |
| 🗺️ **Eureka Server**               | 8761 | Service Discovery & Registration            |
| 🌉 **API Gateway**                 | 8080 | Routes requests to downstream services      |
| 💱 **Currency Exchange Service**   | 8005 | Provides currency exchange rates            |
| 🔄 **Currency Conversion Service** | 8006 | Converts currency using Feign + Redis Cache |
| 🧰 **Redis Cache Server**          | 6379 | Stores cached conversion results            |
| 📈 **Zipkin Server**               | 9411 | Distributed tracing for all microservices   |
| 🖥️ **Spring Boot Admin Server**    | 9000 | Monitors and manages all microservices      |


⚙️ Project Flow
1. A request comes to API Gateway (8080) → /api/v1/conversion
2. Gateway routes to Currency Conversion Service (8006).
3. Conversion Service calls Currency Exchange Service (8005) via Feign Client.
4. Exchange rate retrieved and conversion is calculated.
5. Result is cached in Redis using @Cacheable.
6. Subsequent identical requests return instantly from Redis (no DB call).
7. All services send tracing data to Zipkin (9411) and health data to Admin Server (9000).

🧮 Caching Behavior

✅ First request: Fetches data from ExchangeService → Saves in DB → Stores in Redis
✅ Subsequent requests: Fetched directly from Redis cache
✅ TTL (Time-to-Live): 10 minutes (configurable)


🚦 How to Run the Project
1️⃣ Start Supporting Servers
cd eureka-server
mvn spring-boot:run

cd admin-server
mvn spring-boot:run

cd zipkin-server
java -jar zipkin-server.jar

2️⃣ Start Core Microservices
cd currency-exchange-service
mvn spring-boot:run

cd currency-conversion-service
mvn spring-boot:run

3️⃣ Start Gateway
cd api-gateway
mvn spring-boot:run

4️⃣ Access the Services
Service	URL
Eureka Dashboard	http://localhost:8761
Admin Dashboard	http://localhost:9000
Zipkin Tracing	http://localhost:9411
Currency API (via Gateway)	http://localhost:8080/currency-conversion/from/USD/to/INR/quantity/10

🧠 Features

✅ Eureka-based service registration and discovery
✅ API Gateway routing
✅ Feign client inter-service communication
✅ Centralized monitoring via Spring Boot Admin
✅ Distributed tracing using Zipkin
✅ Full observability with Micrometer + Actuator
✅ Tested with Postman



🖼️ Screenshots
🧩 Eureka Server
🧩 Admin Server
🧩 Conversion Service (Postman Test)
🧩 Zipkin Server (Tracing View)

### 🧩 Eureka Server
![Eureka Server](Screenshots/eureka-server.png)

### 🧩 Admin Server
![Admin Server](Screenshots/admin-server.png)

### 🧩 Admin Wallboard
![Admin Wallboard](Screenshots/admin-wallboard.png)

### 🧩 Conversion Service (Postman Test)
![Conversion Postman](Screenshots/conversion-postman.png)

### 🧩 Zipkin Server
![Zipkin Server](Screenshots/zipkin.png)
