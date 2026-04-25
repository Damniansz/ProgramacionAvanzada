# Task1U1  🚀

This project demonstrates the implementation of core concepts in **Spring Boot**, focusing on clean architecture and best practices.

---

## 📌 Concepts Implemented

### 🔹 Dependency Injection (IoC)

* Decoupled architecture using interfaces
* Multiple implementations (PayPal, Stripe)
* Constructor-based injection with `@Qualifier`

### 🔹 Exception Handling

* Global exception handling with `@ControllerAdvice`
* Custom exception (`RecursoNoEncontradoException`)
* Structured JSON error responses

### 🔹 HTTP Interceptors

* Request interception using `HandlerInterceptor`
* Logging of requests
* Performance timing (response time measurement)

---

## 🏗️ Project Structure

```
task1u1
├── config
│   └── ConfiguracionWeb
├── controller
│   └── ControladorPago
├── exception
│   ├── ManejadorGlobalExcepciones
│   ├── RecursoNoEncontradoException
│   └── RespuestaError
├── interceptor
│   └── InterceptorRegistro
├── service
│   ├── ServicioPago
│   └── impl
│       ├── ServicioPaypal
│       └── ServicioStripe
```

---

## ⚙️ Technologies Used

* Java 21
* Spring Boot
* Maven
* IntelliJ IDEA

---

## ▶️ How to Run the Project

1. Open the project in IntelliJ
2. Run `Task1u1Application`
3. The application will start at:

```
http://localhost:8080
```

---

## 🔗 Available Endpoints

### ✅ Payment

```
GET /pago?tipo=paypal  
GET /pago?tipo=stripe  
```

---

### ⚠️ Error Handling

```
GET /pago/error     → 404 error  
GET /pago/error500  → 500 error  
```

---

## 🧪 Example Responses

### ✔ Successful Response

```
Pago realizado con PayPal
```

---

### ❌ Error Response

```json
{
  "fecha": "2026-04-25T00:00:00",
  "estado": 404,
  "mensaje": "Recurso no encontrado"
}
```

---

## 📊 Interceptor Output (Console)

```
Antes del controlador: /pago
Despues del controlador
Peticion completada
Tiempo de respuesta: XX ms
```

---



## 👨‍💻 Author

**Aldo Saula**
ESPE University - Information Technology Engineering

---


