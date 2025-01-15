# 🎨 ForoHub: Construye y Conecta Ideas 📚

![Logo de ForoHub](https://via.placeholder.com/600x200.png?text=F%C3%B3rumHub+Logo)

Bienvenido al repositorio de **ForoHub**, la plataforma de foros donde puedes compartir ideas, colaborar y aprender junto a una comunidad apasionada. Este proyecto fue creado como un desafío para aprender y practicar habilidades avanzadas en desarrollo de aplicaciones con **Spring Boot 3**, bases de datos relacionales y autenticación segura con **JWT**.

---

## 🚀 Características Principales

- **🔐 Autenticación Segura**: Implementación de autenticación con tokens JWT para proteger los recursos de la API.
- **📝 CRUD Completo de Tópicos**: Crear, listar, actualizar y eliminar tópicos fácilmente.
- **🕛 Listados Dinámicos**: Ordena por fecha de creación, filtra por curso o año, y gestiona paginación.
- **⚡ Migraciones Automatizadas**: Uso de Flyway para gestionar la estructura de la base de datos.
- **🔧 Configuración Flexible**: Personaliza el proyecto desde el archivo `application.properties`.
- **✅ Validación de Datos**: Validación robusta con anotaciones de Spring Boot.

---

## 🚚 Configuración del Entorno

### Requisitos

1. **Java JDK 17** o superior
2. **Maven 4** o superior
3. **Spring Boot 3** o superior
4. **MySQL 8** o superior
5. [**IntelliJ IDEA**](https://www.jetbrains.com/idea/) (opcional)

### Instalación Rápida

1. Clona el repositorio:
   ```bash
   git clone https://github.com/githubmoore/challenge-foro-hub.git
   cd challenge-foro-hub
   ```

2. Configura la base de datos:
   - Crea una base de datos MySQL llamada `forumhub`.
   - Configura las credenciales en `src/main/resources/application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
     spring.datasource.username=tu_usuario
     spring.datasource.password=tu_contraseña
     ```

3. Ejecuta el proyecto:
   ```bash
   mvn spring-boot:run
   ```

4. Prueba la API con herramientas como [Postman](https://www.postman.com) o [Insomnia](https://insomnia.rest).

---

## 🔧 Endpoints Disponibles

### 🔓 Autenticación
| Método | Endpoint      | Descripción                          |
|---------|---------------|--------------------------------------|
| POST    | `/login`      | Genera un token JWT.                |

### 🕛 Tópicos
| Método | Endpoint         | Descripción                               |
|---------|------------------|------------------------------------------|
| GET     | `/topicos`       | Lista todos los tópicos.                 |
| GET     | `/topicos/{id}`  | Obtiene los detalles de un tópico.       |
| POST    | `/topicos`       | Crea un nuevo tópico.                   |
| PUT     | `/topicos/{id}`  | Actualiza un tópico existente.          |
| DELETE  | `/topicos/{id}`  | Elimina un tópico por ID.               |

---

## 🎨 Base de Datos

![Diagrama de la Base de Datos](https://via.placeholder.com/800x400.png?text=Diagrama+Base+de+Datos)

La tabla principal es `topicos`, que contiene los campos:

- `id` (PK)
- `titulo`
- `mensaje`
- `fecha_creacion`
- `status`
- `autor`
- `curso`

# Configuración de la Base de Datos de ForoHub

Esta carpeta contiene el script SQL para inicializar una base de datos MySQL limpia para el proyecto ForoHub.

## Instrucciones

1. **Asegúrate de tener MySQL instalado**:
   Si no tienes MySQL instalado, descárgalo e instálalo en tu sistema.

2. **Abre el cliente de MySQL**:
   Puedes usar el cliente de línea de comandos de MySQL o una herramienta gráfica como MySQL Workbench.

3. **Ejecuta el script**:
   Utiliza el siguiente comando en tu terminal para ejecutar el script:
   ```bash
   mysql -u root -p < forohub-init.sql

---

## 💡 Tips y Trucos

- Pausa el servidor antes de realizar cambios en las migraciones.
- Usa `@PageableDefault` para manejar grandes volúmenes de datos con paginación.
- Asegúrate de actualizar siempre el README con nuevas funcionalidades. 

---

## 🙏 Agradecimientos

Un agradecimiento especial a [Alura Latam](https://www.aluracursos.com) por los recursos y contenido que nos ayudaron a construir este proyecto.

---

## 🌟 Contribuciones

¡Todos son bienvenidos a contribuir! Si encuentras errores o tienes ideas para nuevas funcionalidades, no dudes en abrir un [issue](https://github.com/githubmoore/challenge-foro-hub/issues) o un pull request.

---

## 🔧 Herramientas Utilizadas

- **🔧 Spring Boot 3**
- **🔐 MySQL**
- **🔧 IntelliJ IDEA**
- **🌐 Postman**

---

## 🙌 Autor

Desarrollado por (https://github.com/githubmoore).
