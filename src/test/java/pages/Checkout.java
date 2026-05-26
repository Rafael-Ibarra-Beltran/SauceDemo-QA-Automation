package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout extends BasePage {
    private final By tituloCheckout = By.cssSelector("[data-test='title']");
    private final By campoNombre = By.id("first-name");
    private final By campoApellido = By.id("last-name");
    private final By campoCodigoPostal = By.id("postal-code");
    private final By botonContinuar = By.id("continue");
    private final By botonFinalizar = By.id("finish");
    private final By mensajeError = By.cssSelector("[data-test='error']");
    private final By mensajeCompraCompletada = By.cssSelector("[data-test='complete-header']");

    public Checkout(WebDriver navegador) {
        super(navegador);
    }

    public String obtenerTitulo() {
        return obtenerTexto(tituloCheckout);
    }

    public void llenarDatos(String nombre, String apellido, String codigoPostal) {
        establecerValorJavaScript(campoNombre, nombre);
        establecerValorJavaScript(campoApellido, apellido);
        establecerValorJavaScript(campoCodigoPostal, codigoPostal);
        esperarValoresIngresados(nombre, apellido, codigoPostal);
    }

    private void esperarValoresIngresados(String nombre, String apellido, String codigoPostal) {
        if (!nombre.isEmpty()) {
            esperarValorElemento(campoNombre, nombre);
        }
        if (!apellido.isEmpty()) {
            esperarValorElemento(campoApellido, apellido);
        }
        if (!codigoPostal.isEmpty()) {
            esperarValorElemento(campoCodigoPostal, codigoPostal);
        }
    }

    public void continuar() {
        hacerClickJavaScript(botonContinuar);
    }

    public void finalizar() {
        hacerClickJavaScript(botonFinalizar);
    }

    public String obtenerMensajeError() {
        return obtenerTexto(mensajeError);
    }

    public String obtenerMensajeCompraCompletada() {
        return obtenerTexto(mensajeCompraCompletada);
    }

    public boolean formularioVisible() {
        return estaVisible(campoNombre) && estaVisible(campoApellido) && estaVisible(campoCodigoPostal);
    }
}
