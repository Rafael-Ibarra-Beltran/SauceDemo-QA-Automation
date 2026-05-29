# SauceDemo QA Automation

Proyecto de automatización de pruebas funcionales para [SauceDemo](https://www.saucedemo.com/) usando Java, Selenium WebDriver, TestNG y Maven.

El proyecto aplica el patrón Page Object Model para separar responsabilidades entre páginas, pasos reutilizables, utilidades y pruebas automatizadas.

## Tecnologías

- Java 25
- Maven
- Selenium WebDriver 4.27.0
- TestNG 7.10.2
- WebDriverManager 6.1.0
- Google Chrome

## Prácticas Aplicadas

- Page Object Model
- Organización por capas
- Métodos reutilizables
- Esperas explícitas con `WebDriverWait`
- Assertions con TestNG
- Sin uso de `Thread.sleep`
- Descripciones en cada prueba con `@Test(description = "...")`

## Estructura Del Proyecto

```text
src/test/java/
  base/
    BasePage.java
    BaseTest.java
  pages/
    InicioSesion.java
    Productos.java
    DetalleProducto.java
    Carrito.java
    Checkout.java
  steps/
    PasosSesion.java
    PasosProductos.java
    PasosCheckout.java
  tests/
    PruebasInicioSesion.java
    PruebasProductos.java
    PruebasCarritoCheckout.java
    PruebasCasosExtendidos.java
    PruebasMenu.java
  utils/
    Constantes.java
```

## Módulos Automatizados

- Inicio de sesión
- Validaciones negativas de login
- Validaciones de interfaz del login
- Visualización de productos
- Detalle de producto
- Ordenamiento de productos
- Carrito de compras
- Checkout
- Cierre de sesión

## Requisitos

- Java 25 instalado
- Maven instalado y disponible en el `PATH`
- Google Chrome instalado
- Conexión a internet para acceder a SauceDemo

Verificar versiones:

```bash
java -version
mvn -version
```

## Instalación

Clonar el repositorio:

```bash
git clone <url-del-repositorio>
cd SauceDemo-QA-Automation
```

Instalar dependencias:

```bash
mvn clean test-compile
```

## Ejecución De Pruebas

Ejecutar toda la suite:

```bash
mvn test
```

Ejecutar en modo headless:

```bash
mvn test -Dheadless=true
```

Ejecutar contra una URL base específica:

```bash
mvn test -DbaseUrl=https://www.saucedemo.com/
```

Maven ejecuta las clases que cumplen el patrón configurado en `pom.xml`:

```text
Pruebas*.java
```

## Reportes

Después de ejecutar las pruebas, TestNG/Surefire genera los resultados en:

```text
target/surefire-reports/
```

## Datos De Prueba

Usuario estándar:

```text
Usuario: standard_user
Contraseña: secret_sauce
```

Usuario bloqueado:

```text
Usuario: locked_out_user
Contraseña: secret_sauce
```

## Autores

- Mónica Jatziri García Alatorre
- Rafael Ibarra Beltrán

## Licencia

Este proyecto está bajo la licencia MIT. Consultar el archivo `LICENSE` para más información.
