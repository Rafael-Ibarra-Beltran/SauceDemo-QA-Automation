package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Constantes;

public class BaseTest {
    protected WebDriver navegador;

    @BeforeMethod
    public void configurarPrueba() {
        ChromeOptions opciones = new ChromeOptions();
        navegador = new ChromeDriver(opciones);
        navegador.manage().window().maximize();
        navegador.get(Constantes.URL_SAUCE_DEMO);
    }

    @AfterMethod(alwaysRun = true)
    public void cerrarPrueba() {
        if (navegador != null) {
            navegador.quit();
        }
    }
}
