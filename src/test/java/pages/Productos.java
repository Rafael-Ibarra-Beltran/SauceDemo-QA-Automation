package pages;

import java.util.List;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Productos extends BasePage {
    private final By tituloProductos = By.cssSelector("[data-test='title']");
    private final By listaProductos = By.cssSelector("[data-test='inventory-item']");
    private final By nombresProductos = By.cssSelector("[data-test='inventory-item-name']");
    private final By preciosProductos = By.cssSelector("[data-test='inventory-item-price']");
    private final By selectorOrdenamiento = By.cssSelector("[data-test='product-sort-container']");
    private final By enlaceMochila = By.id("item_4_title_link");

    public Productos(WebDriver navegador) {
        super(navegador);
    }

    public String obtenerTitulo() {
        return obtenerTexto(tituloProductos);
    }

    public boolean tituloProductosVisible() {
        return estaVisible(tituloProductos);
    }

    public int cantidadProductos() {
        esperarElementoVisible(listaProductos);
        return obtenerCantidadElementos(listaProductos);
    }

    public boolean listaVisible() {
        return cantidadProductos() > 0;
    }

    public void abrirMochila() {
        hacerClick(enlaceMochila);
    }

    public void ordenarPorValor(String valor) {
        seleccionarPorValor(selectorOrdenamiento, valor);
    }

    public List<String> obtenerNombresProductos() {
        esperarElementoVisible(nombresProductos);
        return navegador.findElements(nombresProductos).stream()
                .map(WebElement::getText)
                .toList();
    }

    public List<Double> obtenerPreciosProductos() {
        esperarElementoVisible(preciosProductos);
        return navegador.findElements(preciosProductos).stream()
                .map(WebElement::getText)
                .map(precio -> precio.replace("$", ""))
                .map(Double::parseDouble)
                .toList();
    }
}
