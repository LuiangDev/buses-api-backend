# CIVA | Backend API de Gestión de Buses 🚍

API REST desarrollada en **Java + Spring Boot** como parte del sistema de gestión de buses para la empresa **CIVA**. Permite registrar, listar y consultar buses, así como asociarlos a marcas existentes o nuevas.

## 🔧 Funcionalidades Clave

- Registro de buses con vinculación a marcas existentes o creación de nuevas.
- Listado paginado de buses.
- Filtro de buses desde el frontend por número, placa o marca.
- Consulta individual de buses por ID.
- Relación bidireccional entre entidades `Bus` y `Marca` correctamente gestionada.
- Control de errores y validaciones esenciales en endpoints.

---

## 🔖 Endpoints

### 🚌 Buses `/bus`

| Método | Ruta           | Descripción                        |
|--------|----------------|------------------------------------|
| GET    | `/bus`         | Listar todos los buses (paginado) |
| GET    | `/bus/{id}`    | Obtener bus por ID                 |
| POST   | `/bus`         | Crear un nuevo bus (con o sin marca nueva) |

### 🏷️ Marcas `/marca`

| Método | Ruta           | Descripción                      |
|--------|----------------|----------------------------------|
| GET    | `/marca`       | Obtener todas las marcas         |
| POST   | `/marca`       | Crear una nueva marca            |

---

## 🛠️ Tecnologías Utilizadas

| Tecnología | Uso |
|-----------|-----|
| ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) | Lenguaje principal |
| ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white) | Framework Backend |
| ![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white) | Base de datos relacional |
| ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white) | Gestión de dependencias |

---

## 📁 Estructura del Proyecto

```
/src
├── controller/            # Controladores REST (BusController, MarcaController)
├── model/                 # Entidades JPA: Bus y Marca
├── repository/            # Interfaces JpaRepository
├── BusesApiApplication.java # Clase principal de arranque
└── resources/
    ├── application.properties # Configuración del servidor y base de datos
```


---

## ⚙️ Configuración (application.properties)

```properties
spring.application.name=buses-api
spring.datasource.url=jdbc:mysql://localhost:3306/buses_db
spring.datasource.username=buses_user
spring.datasource.password=Buses_User2025!
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 📝 Consideraciones Técnicas

- Uso de `@ManyToOne` en la entidad `Bus` y `@OneToMany` en `Marca` para definir la relación entre buses y marcas.
- Uso de `@JsonIgnore` en `Marca` para evitar ciclos infinitos en la serialización bidireccional.
- Paginación implementada mediante `Pageable` y `PageRequest` para consultas eficientes desde el frontend.
- Manejo de errores controlado con `ResponseEntity` y validación de existencia de la marca en `BusController`.
- El campo `fechaCreacion` se asigna automáticamente usando `@PrePersist`.
- No se permite el registro de un bus sin una marca válida (se verifica antes de guardar).


## 🛂 Instalación Local

1. **Clona el repositorio:**
```bash
git clone https://github.com/LuiangDev/buses-api-backend.git
```

2. **Importa el proyecto** como un *Maven Project* en tu IDE preferido (por ejemplo: **IntelliJ IDEA**, **Eclipse**, etc.).

3. **Configura tu base de datos MySQL**:
   - Nombre: `buses_db`
   - Usuario: `buses_user`
   - Contraseña: `Buses_User2025!`

4. **Verifica el archivo** `application.properties` y asegúrate de que los datos de conexión estén correctos.

5. **Ejecuta la clase** `BusesApiApplication.java`, que es el punto de entrada del backend.

6. El servidor Spring Boot se iniciará en:  
   👉 `http://localhost:8080`

## 💬 Autor

**Luis Angel Quispe Navarro**  
Desarrollador Front-End | Ingeniero de Sistemas Computacionales  
✉️ angel.quispe.navarro@outlook.com  
[![GitHub](https://img.shields.io/badge/GitHub-LuiangDev-181717?style=for-the-badge&logo=github)](https://github.com/LuiangDev)  
📍 Lima, Perú

