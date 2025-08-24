
## ⚙️ Tecnologías Usadas

- **Java 17**
- **Spring Boot 3.x**
    - Spring Web (API REST)
    - Spring Data JPA (persistencia)
    - Spring Validation (validaciones DTOs)
    - Spring Security (PasswordEncoder para hashing de contraseñas)
- **Base de Datos**: MySQL 8
- **Herramientas**:
    - Gradle (gestor de dependencias)
    - Lombok (reducción de boilerplate code)

---

## 📍 Endpoints

### 👤 Empleados
- **GET** `/api/empleados` → Listar empleados
- **GET** `/api/empleados/{id}` → Obtener empleado por ID
- **POST** `/api/empleados` → Crear empleado
- **PUT** `/api/empleados/{id}` → Actualizar empleado
- **DELETE** `/api/empleados/{id}` → Eliminar empleado

---

### 📦 Productos
- **GET** `/api/productos` → Listar productos
- **GET** `/api/productos/{id}` → Obtener producto por ID
- **POST** `/api/productos` → Crear producto
- **PUT** `/api/productos/{id}` → Actualizar producto
- **DELETE** `/api/productos/{id}` → Eliminar producto

---

### 🏷️ Categorías
- **GET** `/api/categorias` → Listar categorías
- **GET** `/api/categorias/{id}` → Obtener categoría por ID
- **POST** `/api/categorias` → Crear categoría
- **PUT** `/api/categorias/{id}` → Actualizar categoría
- **DELETE** `/api/categorias/{id}` → Eliminar categoría

---

### 🏢 Proveedores
- **GET** `/api/proveedores` → Listar proveedores
- **GET** `/api/proveedores/{id}` → Obtener proveedor por ID
- **POST** `/api/proveedores` → Crear proveedor
- **PUT** `/api/proveedores/{id}` → Actualizar proveedor
- **DELETE** `/api/proveedores/{id}` → Eliminar proveedor

---
