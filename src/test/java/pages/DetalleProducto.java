package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetalleProducto extends BasePage {
    private final By nombreProducto = By.cssSelector("[data-test='inventory-item-name']");
    private final By descripcionProducto = By.cssSelector("[data-test='inventory-item-desc']");
    private final By precioProducto = By.cssSelector("[data-test='inventory-item-price']");
    private final By botonRegresarProductos = By.id("back-to-products");

    public DetalleProducto(WebDriver navegador) {
        super(navegador);
    }

    public String obtenerNombre() {
        return obtenerTexto(nombreProducto);
    }

    public boolean detalleVisible() {
        return estaVisible(nombreProducto) && estaVisible(descripcionProducto) && estaVisible(precioProducto);
    }

    public Productos regresarAProductos() {
        hacerClick(botonRegresarProductos);
        return new Productos(navegador);
    }
}
