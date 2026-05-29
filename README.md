# SauceDemo QA Automation

Proyecto de automatizacion de pruebas funcionales para [SauceDemo](https://www.saucedemo.com/) con Java, Selenium WebDriver, TestNG y Maven.

La suite valida los flujos principales de login, catalogo de productos, carrito, checkout y cierre de sesion. El codigo esta organizado con Page Object Model, pasos reutilizables y utilidades compartidas para mantener separadas las responsabilidades de paginas, acciones de negocio y pruebas.

## Alcance

- 30 casos de prueba automatizados, identificados de `TC-01` a `TC-30`.
- Pruebas positivas, negativas y de interfaz para login.
- Validaciones de catalogo, detalle de producto y ordenamiento.
- Validaciones de agregar, remover y visualizar productos en carrito.
- Validaciones de checkout, errores de formulario, resumen y compra completada.
- Validacion de cierre de sesion desde el menu lateral.
- Trazabilidad documental en `docs/test-cases.md` y `docs/features/saucedemo.feature`.

## Tecnologias

- Java 25
- Maven
- Selenium WebDriver 4.27.0
- TestNG 7.10.2
- Maven Surefire Plugin 3.5.2
- WebDriverManager 6.1.0 como dependencia de pruebas
- Google Chrome

## Practicas Aplicadas

- Page Object Model.
- Organizacion por capas: `base`, `pages`, `steps`, `tests` y `utils`.
- Metodos reutilizables para flujos frecuentes.
- Esperas explicitas con `WebDriverWait`.
- Assertions con TestNG.
- Ejecucion secuencial configurada en Surefire.
- Configuracion por propiedades Maven: `headless` y `baseUrl`.
- Sin uso de `Thread.sleep`.
- Descripciones en cada prueba con `@Test(description = "...")`.

## Estructura Del Proyecto

```text
.
|-- docs/
|   |-- test-cases.md
|   `-- features/
|       `-- saucedemo.feature
|-- src/test/java/
|   |-- base/
|   |   |-- BasePage.java
|   |   `-- BaseTest.java
|   |-- pages/
|   |   |-- Carrito.java
|   |   |-- Checkout.java
|   |   |-- DetalleProducto.java
|   |   |-- InicioSesion.java
|   |   `-- Productos.java
|   |-- steps/
|   |   |-- PasosCheckout.java
|   |   |-- PasosProductos.java
|   |   `-- PasosSesion.java
|   |-- tests/
|   |   |-- PruebasCarritoCheckout.java
|   |   |-- PruebasCasosExtendidos.java
|   |   |-- PruebasInicioSesion.java
|   |   |-- PruebasMenu.java
|   |   `-- PruebasProductos.java
|   `-- utils/
|       `-- Constantes.java
|-- pom.xml
|-- README.md
`-- LICENSE
```

## Arquitectura

| Capa | Responsabilidad |
| :--- | :--- |
| `base` | Inicializacion y cierre del navegador, configuracion comun y acciones base sobre elementos. |
| `pages` | Representacion de paginas y componentes de SauceDemo mediante localizadores y acciones puntuales. |
| `steps` | Flujos reutilizables que combinan acciones de varias paginas. |
| `tests` | Casos de prueba TestNG con assertions y trazabilidad por ID. |
| `utils` | Constantes de URLs, usuarios, datos de prueba, textos esperados y valores de ordenamiento. |
| `docs` | Evidencia documental de casos de prueba y escenarios Gherkin. |

## Modulos Automatizados

- Login exitoso con usuario estandar.
- Login negativo con usuario bloqueado, campos obligatorios y credenciales invalidas.
- Validacion de elementos visibles en login.
- Visualizacion de productos.
- Detalle de producto.
- Ordenamiento por nombre A-Z, nombre Z-A, precio ascendente y precio descendente.
- Agregar y eliminar productos desde productos y carrito.
- Visualizacion de uno o dos productos en carrito.
- Navegacion entre productos, detalle, carrito y checkout.
- Checkout con validaciones de campos obligatorios.
- Resumen de compra y finalizacion exitosa.
- Regreso a productos despues de finalizar compra.
- Cierre de sesion.

## Casos De Prueba

| Archivo | Casos |
| :--- | :--- |
| `PruebasInicioSesion.java` | `TC-01` a `TC-06` |
| `PruebasProductos.java` | `TC-07`, `TC-08`, `TC-09`, `TC-10`, `TC-20`, `TC-21`, `TC-22` |
| `PruebasCarritoCheckout.java` | `TC-11` a `TC-18`, `TC-23`, `TC-24`, `TC-25` |
| `PruebasMenu.java` | `TC-19` |
| `PruebasCasosExtendidos.java` | `TC-26` a `TC-30` |

El detalle completo de precondiciones, pasos, datos y resultados esperados se encuentra en `docs/test-cases.md`.

El archivo `docs/features/saucedemo.feature` se mantiene como evidencia documental y trazabilidad en formato Gherkin. La suite ejecutable usa TestNG, no Cucumber.

## Requisitos

- Java 25 instalado.
- Maven instalado y disponible en el `PATH`.
- Google Chrome instalado.
- Conexion a internet para acceder a SauceDemo.

Verificar versiones:

```bash
java -version
mvn -version
```

## Instalacion

Clonar el repositorio:

```bash
git clone <url-del-repositorio>
cd SauceDemo-QA-Automation
```

Compilar las pruebas y descargar dependencias:

```bash
mvn clean test-compile
```

## Ejecucion De Pruebas

Ejecutar toda la suite:

```bash
mvn test
```

Ejecutar en modo headless:

```bash
mvn test -Dheadless=true
```

Ejecutar contra una URL base especifica:

```bash
mvn test -DbaseUrl=https://www.saucedemo.com/
```

Combinar URL base y modo headless:

```bash
mvn test -Dheadless=true -DbaseUrl=https://www.saucedemo.com/
```

Ejecutar una clase especifica:

```bash
mvn test -Dtest=PruebasInicioSesion
```

Maven ejecuta por defecto las clases que cumplen el patron configurado en `pom.xml`:

```text
**/Pruebas*.java
```

La ejecucion esta configurada sin paralelismo para evitar interferencias entre pruebas de navegador.

## Configuracion

La configuracion comun de pruebas esta en `BaseTest.java`:

- Crea una instancia de `ChromeDriver` por metodo de prueba.
- Deshabilita avisos del administrador de contrasenas de Chrome.
- Maximiza la ventana en modo visible.
- Usa `--headless=new` y `--window-size=1920,1080` cuando se define `-Dheadless=true`.
- Lee la URL base desde `-DbaseUrl`; si no se define, usa `https://www.saucedemo.com/`.
- Cierra el navegador con `quit()` despues de cada prueba.

## Datos De Prueba

| Dato | Valor |
| :--- | :--- |
| Usuario estandar | `standard_user` |
| Usuario bloqueado | `locked_out_user` |
| Usuario incorrecto | `usuario_fake` |
| Contrasena valida | `secret_sauce` |
| Contrasena incorrecta | `pass_fake` |
| Producto principal | `Sauce Labs Backpack` |
| Producto secundario | `Sauce Labs Bike Light` |
| Nombre comprador | `Rafael` |
| Apellido comprador | `Ibarra` |
| Codigo postal | `22000` |

Los valores centralizados estan en `src/test/java/utils/Constantes.java`.

## Reportes

Despues de ejecutar la suite, Maven Surefire y TestNG generan resultados en:

```text
target/surefire-reports/
```

Archivos utiles:

- `target/surefire-reports/index.html`
- `target/surefire-reports/emailable-report.html`
- `target/surefire-reports/testng-results.xml`
- `target/surefire-reports/junitreports/TEST-tests.*.xml`

## Autores

- Monica Jatziri Garcia Alatorre
- Rafael Ibarra Beltran

## Licencia

Este proyecto esta bajo la licencia MIT. Consultar el archivo `LICENSE` para mas informacion.
