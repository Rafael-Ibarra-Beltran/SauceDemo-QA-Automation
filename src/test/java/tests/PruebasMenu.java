package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.PasosProductos;
import steps.PasosSesion;

public class PruebasMenu extends BaseTest {
    @Test(description = "TC-19 - Validar cierre de sesión del usuario")
    public void cerrarSesionUsuario() {
        new PasosSesion(navegador).sesionEstandar();
        PasosProductos pasosProductos = new PasosProductos(navegador);

        pasosProductos.cerrarSesion();

        Assert.assertTrue(new PasosSesion(navegador).elementosVisibles());
    }
}
