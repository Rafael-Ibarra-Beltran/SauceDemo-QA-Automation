# Archivo feature utilizado como evidencia documental y trazabilidad de los casos de prueba.
# La automatización ejecutable del proyecto está implementada con TestNG, no con Cucumber.

Feature: Evidencia documental de pruebas funcionales en SauceDemo
  Como equipo de QA Automation
  Quiero documentar los escenarios automatizados de SauceDemo en formato Gherkin
  Para mantener trazabilidad entre los casos de prueba TC-01 a TC-30 y la evidencia del proyecto

  Background:
    Given que el usuario abre la aplicacion SauceDemo
    And la automatizacion ejecutable se mantiene implementada con TestNG

  @TC-01 @login
  Scenario: Inicio de sesion exitoso con usuario estandar
    When el usuario ingresa credenciales validas de standard_user
    And hace clic en Login
    Then el sistema muestra la pagina de productos

  @TC-02 @login @negativo
  Scenario: Usuario bloqueado no puede iniciar sesion
    When el usuario ingresa credenciales del usuario locked_out_user
    And hace clic en Login
    Then el sistema muestra un mensaje indicando que el usuario esta bloqueado

  @TC-03 @login @negativo
  Scenario: Validar error sin usuario
    When el usuario deja vacio el campo usuario
    And ingresa una contrasena valida
    And hace clic en Login
    Then el sistema muestra un mensaje indicando que el usuario es requerido

  @TC-04 @login @negativo
  Scenario: Validar error sin contrasena
    When el usuario ingresa un usuario valido
    And deja vacio el campo contrasena
    And hace clic en Login
    Then el sistema muestra un mensaje indicando que la contrasena es requerida

  @TC-05 @login @negativo
  Scenario: Validar credenciales invalidas
    When el usuario ingresa credenciales invalidas
    And hace clic en Login
    Then el sistema muestra un mensaje de credenciales invalidas

  @TC-06 @login @ui
  Scenario: Validar elementos visibles del login
    When el usuario visualiza la pagina inicial
    Then el campo de usuario es visible
    And el campo de contrasena es visible
    And el boton Login es visible

  @TC-07 @productos
  Scenario: Visualizar lista de productos
    Given que el usuario inicia sesion con credenciales validas
    When accede a la pagina principal de productos
    Then el sistema muestra la lista de productos disponibles

  @TC-08 @productos @detalle
  Scenario: Acceder al detalle de producto
    Given que el usuario inicia sesion con credenciales validas
    When selecciona el producto Sauce Labs Backpack
    Then el sistema muestra el detalle del producto seleccionado

  @TC-09 @productos
  Scenario: Ordenar productos por nombre A-Z
    Given que el usuario inicia sesion con credenciales validas
    When selecciona el ordenamiento Name A to Z
    Then los productos se muestran ordenados alfabeticamente de A a Z

  @TC-10 @productos
  Scenario: Ordenar productos por precio menor a mayor
    Given que el usuario inicia sesion con credenciales validas
    When selecciona el ordenamiento Price Low to High
    Then los productos se muestran ordenados por precio de menor a mayor

  @TC-11 @carrito @productos
  Scenario: Agregar producto al carrito
    Given que el usuario inicia sesion con credenciales validas
    When agrega el producto Sauce Labs Backpack al carrito
    Then el contador del carrito muestra un producto agregado

  @TC-12 @carrito @productos
  Scenario: Eliminar producto desde productos
    Given que el usuario inicia sesion con credenciales validas
    And agrega el producto Sauce Labs Backpack al carrito
    When elimina el producto desde la pagina de productos
    Then el producto deja de estar agregado al carrito

  @TC-13 @carrito
  Scenario: Visualizar producto dentro del carrito
    Given que el usuario inicia sesion con credenciales validas
    And agrega el producto Sauce Labs Backpack al carrito
    When abre el carrito de compras
    Then el carrito muestra el producto agregado

  @TC-14 @checkout @carrito
  Scenario: Iniciar proceso de checkout
    Given que el usuario inicia sesion con credenciales validas
    And agrega un producto al carrito
    And abre el carrito de compras
    When hace clic en Checkout
    Then el sistema muestra el formulario de informacion del comprador

  @TC-15 @checkout @negativo
  Scenario: Validar error checkout sin nombre
    Given que el usuario se encuentra en el formulario de checkout
    When deja vacio el campo First Name
    And completa Last Name y Postal Code
    And hace clic en Continue
    Then el sistema muestra un mensaje indicando que el nombre es requerido

  @TC-16 @checkout @negativo
  Scenario: Validar error checkout sin apellido
    Given que el usuario se encuentra en el formulario de checkout
    When completa First Name
    And deja vacio el campo Last Name
    And completa Postal Code
    And hace clic en Continue
    Then el sistema muestra un mensaje indicando que el apellido es requerido

  @TC-17 @checkout @negativo
  Scenario: Validar error checkout sin codigo postal
    Given que el usuario se encuentra en el formulario de checkout
    When completa First Name y Last Name
    And deja vacio el campo Postal Code
    And hace clic en Continue
    Then el sistema muestra un mensaje indicando que el codigo postal es requerido

  @TC-18 @checkout
  Scenario: Finalizar compra correctamente
    Given que el usuario inicia sesion con credenciales validas
    And agrega un producto al carrito
    And completa el formulario de checkout con datos validos
    When finaliza la compra
    Then el sistema muestra el mensaje de compra completada

  @TC-19 @menu @login
  Scenario: Cerrar sesion
    Given que el usuario inicia sesion con credenciales validas
    When abre el menu lateral
    And hace clic en Logout
    Then el sistema cierra la sesion y regresa a la pagina de login

  @TC-20 @productos @ui
  Scenario: Validar elementos principales de productos
    Given que el usuario inicia sesion con credenciales validas
    When visualiza la pagina de productos
    Then el titulo Products es visible
    And el carrito es visible
    And la lista de productos es visible

  @TC-21 @productos
  Scenario: Ordenar productos por nombre Z-A
    Given que el usuario inicia sesion con credenciales validas
    When selecciona el ordenamiento Name Z to A
    Then los productos se muestran ordenados alfabeticamente de Z a A

  @TC-22 @productos
  Scenario: Ordenar productos por precio mayor a menor
    Given que el usuario inicia sesion con credenciales validas
    When selecciona el ordenamiento Price High to Low
    Then los productos se muestran ordenados por precio de mayor a menor

  @TC-23 @carrito
  Scenario: Eliminar producto desde carrito
    Given que el usuario inicia sesion con credenciales validas
    And agrega el producto Sauce Labs Backpack al carrito
    And abre el carrito de compras
    When elimina el producto desde el carrito
    Then el producto deja de mostrarse en la lista del carrito

  @TC-24 @carrito @productos
  Scenario: Regresar desde carrito a productos
    Given que el usuario inicia sesion con credenciales validas
    And abre el carrito de compras
    When hace clic en Continue Shopping
    Then el sistema regresa a la pagina de productos

  @TC-25 @checkout @carrito
  Scenario: Cancelar checkout y regresar al carrito
    Given que el usuario inicia sesion con credenciales validas
    And agrega un producto al carrito
    And inicia el proceso de checkout
    When hace clic en Cancel
    Then el sistema regresa al carrito conservando el producto agregado

  @TC-26 @carrito
  Scenario: Agregar dos productos al carrito
    Given que el usuario inicia sesion con credenciales validas
    When agrega dos productos al carrito
    Then el contador del carrito muestra dos productos agregados

  @TC-27 @carrito
  Scenario: Visualizar dos productos dentro del carrito
    Given que el usuario inicia sesion con credenciales validas
    And agrega dos productos al carrito
    When abre el carrito de compras
    Then el carrito muestra los dos productos agregados

  @TC-28 @productos @detalle
  Scenario: Regresar desde detalle de producto a productos
    Given que el usuario inicia sesion con credenciales validas
    And accede al detalle del producto Sauce Labs Backpack
    When hace clic en Back to products
    Then el sistema regresa a la pagina de productos

  @TC-29 @checkout
  Scenario: Validar resumen de checkout antes de finalizar
    Given que el usuario inicia sesion con credenciales validas
    And agrega un producto al carrito
    And completa el formulario de checkout con datos validos
    When continua al resumen de checkout
    Then el sistema muestra el producto en el resumen
    And el total de la compra es visible

  @TC-30 @checkout @productos
  Scenario: Regresar a productos despues de completar compra
    Given que el usuario inicia sesion con credenciales validas
    And completa una compra correctamente
    When hace clic en Back Home
    Then el sistema regresa a la pagina de productos
