package base;

import java.util.Map;

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
        opciones.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false,
                "profile.password_manager_leak_detection", false));
        opciones.addArguments("--disable-features=PasswordLeakDetection");
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
