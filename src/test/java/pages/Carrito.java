package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Carrito extends BasePage {
    private final By tituloCarrito = By.cssSelector("[data-test='title']");
    private final By productoMochila = By.cssSelector("[data-test='inventory-item-name']");
    private final By botonEliminarProducto = By.id("remove-sauce-labs-backpack");
    private final By botonContinuarComprando = By.id("continue-shopping");
    private final By botonCheckout = By.id("checkout");

    public Carrito(WebDriver navegador) {
        super(navegador);
    }

    public String obtenerTitulo() {
        return obtenerTexto(tituloCarrito);
    }

    public String obtenerNombreProducto() {
        return obtenerTexto(productoMochila);
    }

    public boolean productoVisible() {
        return estaVisible(productoMochila);
    }

    public void eliminarProducto() {
        hacerClick(botonEliminarProducto);
    }

    public Productos continuarComprando() {
        hacerClick(botonContinuarComprando);
        return new Productos(navegador);
    }

    public void iniciarCheckout() {
        hacerClick(botonCheckout);
    }
}
