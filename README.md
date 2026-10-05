#SOA_SKILL_EXP_2

# 🚀API Gateway for E-Commerce Routing

## 📌 Overview

This experiment demonstrates an **API Gateway-based microservices architecture** for an e-commerce system.

The system consists of:

- 🛍️ Product Service
- 🛒 Cart Service
- 🌐 API Gateway
- 🔎 Eureka Server
- ⚖️ Multiple Product Service instances for load balancing

## 🏗️ Architecture

```text
                👤 Client
                    |
                    v
            🌐 API Gateway :8080
               /           \
              /             \
             v               v
     🛍️ Product Service   🛒 Cart Service
        :8083/:8084           :8085
             \               /
              \             /
               🔎 Eureka :8761
```

## 🔧 Services

| Service | Port | Purpose |
|---|---:|---|
| 🔎 Eureka Server | 8761 | Service Discovery |
| 🌐 API Gateway | 8080 | Routing & Load Balancing |
| 🛍️ Product Service | 8083 | Product API |
| 🛍️ Product Service | 8084 | Second Instance |
| 🛒 Cart Service | 8085 | Cart API |

## 🔗 API Endpoints

### 🛍️ Product Service

`GET /products`

Direct access:

- `http://localhost:8083/products`
- `http://localhost:8084/products`

### 🛒 Cart Service

`GET /cart`

Direct access:

- `http://localhost:8085/cart`

### 🌐 API Gateway

- `http://localhost:8080/products`
- `http://localhost:8080/cart`

Gateway routes:

- `/products/**` → `PRODUCT-SERVICE`
- `/cart/**` → `CART-SERVICE`

## ⚖️ Load Balancing

Two Product Service instances are registered with Eureka:

```text
🛍️ PRODUCT-SERVICE
├── 🟢 8083
└── 🟢 8084
```

The API Gateway uses:

```text
lb://PRODUCT-SERVICE
```

to distribute requests between the available Product Service instances.

Load balancing was verified by sending multiple requests through:

`http://localhost:8080/products`

and observing responses from both Product Service instances:

- 🟢 Product Service – Port 8083
- 🟢 Product Service – Port 8084

## 🛠️ Technologies

- ☕ Java 21
- 🌱 Spring Boot 3.5.16
- ☁️ Spring Cloud 2025.0.3
- 🌐 Spring Cloud Gateway
- 🔎 Netflix Eureka
- 🔗 REST APIs
- 📦 Maven
- 🧰 Spring Tool Suite (STS)

## ✅ Result

Successfully implemented and tested:

- 🛍️ Product and Cart microservices
- 🔎 Eureka service registration
- 🌐 API Gateway routing
- 🔄 Multiple Product Service instances
- ⚖️ Load balancing through the API Gateway
