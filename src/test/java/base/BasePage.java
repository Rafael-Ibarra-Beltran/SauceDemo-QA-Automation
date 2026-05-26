package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected final WebDriver navegador;
    protected final WebDriverWait espera;

    public BasePage(WebDriver navegador) {
        this.navegador = navegador;
        this.espera = new WebDriverWait(navegador, Duration.ofSeconds(10));
    }

    protected WebElement esperarElementoVisible(By localizador) {
        return espera.until(ExpectedConditions.visibilityOfElementLocated(localizador));
    }

    protected WebElement esperarElementoClickable(By localizador) {
        return espera.until(ExpectedConditions.elementToBeClickable(localizador));
    }

    protected void hacerClick(By localizador) {
        esperarElementoClickable(localizador).click();
    }

    protected void escribirTexto(By localizador, String texto) {
        WebElement elemento = esperarElementoVisible(localizador);
        elemento.clear();
        elemento.sendKeys(texto);
    }

    protected String obtenerTexto(By localizador) {
        return esperarElementoVisible(localizador).getText();
    }

    protected boolean estaVisible(By localizador) {
        try {
            return esperarElementoVisible(localizador).isDisplayed();
        } catch (RuntimeException excepcion) {
            return false;
        }
    }

    protected int obtenerCantidadElementos(By localizador) {
        return navegador.findElements(localizador).size();
    }

    protected void seleccionarPorValor(By localizador, String valor) {
        WebElement elemento = esperarElementoVisible(localizador);
        new Select(elemento).selectByValue(valor);
    }
}
