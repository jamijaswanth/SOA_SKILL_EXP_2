# SOA_SKILL_EXP_2
# Experiment 2 – API Gateway for E-Commerce Routing

## 📌 Experiment Overview

This experiment demonstrates how an **API Gateway** can act as a single entry point for multiple microservices in an e-commerce system.

The system consists of:

- Product Service
- Cart Service
- API Gateway
- Eureka Server for service discovery
- Multiple instances of Product Service for load balancing

The API Gateway routes client requests to the appropriate backend service and distributes requests between multiple Product Service instances.

---

## 🎯 Objectives

- Develop independent Product and Cart microservices.
- Configure an API Gateway as a single entry point.
- Implement request routing using Spring Cloud Gateway.
- Register services with Eureka Server.
- Run multiple instances of Product Service.
- Verify API Gateway routing.
- Demonstrate load balancing between Product Service instances.

---

## 🏗️ System Architecture

```text
                         Client
                           |
                           v
                  +------------------+
                  |   API Gateway    |
                  |     :8080        |
                  +------------------+
                    /              \
                   /                \
                  v                  v
        +----------------+    +----------------+
        | Product        |    | Cart Service   |
        | Service        |    |     :8085      |
        |    :8083       |    +----------------+
        +----------------+
                 ^
                 |
        +----------------+
        | Product        |
        | Service        |
        |    :8084       |
        +----------------+

                  ^
                  |
          +---------------+
          | Eureka Server |
          |     :8761     |
          +---------------+
