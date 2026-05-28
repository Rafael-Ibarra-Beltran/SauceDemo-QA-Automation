package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
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

    protected void hacerClickJavaScript(By localizador) {
        WebElement elemento = esperarElementoClickable(localizador);
        ((JavascriptExecutor) navegador).executeScript("arguments[0].click();", elemento);
    }

    protected void escribirTexto(By localizador, String texto) {
        WebElement elemento = esperarElementoVisible(localizador);
        elemento.clear();
        elemento.sendKeys(texto);
    }

    protected void esperarValorElemento(By localizador, String valor) {
        espera.until(ExpectedConditions.attributeToBe(localizador, "value", valor));
    }

    protected void establecerValorJavaScript(By localizador, String valor) {
        WebElement elemento = esperarElementoVisible(localizador);
        ((JavascriptExecutor) navegador).executeScript(
                "const elemento = arguments[0];"
                        + "const valor = arguments[1];"
                        + "const valorAnterior = elemento.value;"
                        + "elemento.value = valor;"
                        + "const tracker = elemento._valueTracker;"
                        + "if (tracker) { tracker.setValue(valorAnterior); }"
                        + "elemento.dispatchEvent(new Event('input', { bubbles: true }));",
                elemento,
                valor);
    }

    protected String obtenerTexto(By localizador) {
        return esperarElementoVisible(localizador).getText();
    }

    protected boolean estaVisible(By localizador) {
        try {
            return esperarElementoVisible(localizador).isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException excepcion) {
            return false;
        }
    }

    protected boolean estaInvisible(By localizador) {
        try {
            return espera.until(ExpectedConditions.invisibilityOfElementLocated(localizador));
        } catch (TimeoutException excepcion) {
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
