# ClothesProject

Aplicación web para la gestión de productos y proveedores de ropa deportiva.  
Desarrollada con Spring Boot y Thymeleaf, incluye autenticación, CRUD de productos, internacionalización, servicios REST y despliegue con Docker.

---

## 🧩 Funcionalidades principales

- Gestión de productos (camisas, camisetas, sudaderas, etc.)
- CRUD de proveedores
- Registro e inicio de sesión de usuarios
- Vistas dinámicas con Thymeleaf
- Internacionalización (inglés y español)
- Pruebas unitarias básicas
- Servicios REST JSON
- Consumo de APIs externas
- Inversión de dependencias
- Despliegue con Docker y Docker Compose

---

## ▶️ Ejecución local

### Requisitos:

- Java 17
- Maven
- Docker y Docker Compose

### Instrucciones:

1. **Clona el repositorio**
```bash
git clone <URL_DEL_REPO>
cd ClothesProject

mvn clean package -DskipTests

docker-compose up --build

http://localhost:8080


