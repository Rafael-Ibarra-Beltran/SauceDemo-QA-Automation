package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Productos;
import steps.PasosSesion;
import utils.Constantes;

public class PruebasInicioSesion extends BaseTest {
    @Test(description = "TC-01 - Validar inicio de sesión exitoso con usuario estándar")
    public void inicioSesionExitoso() {
        PasosSesion pasosSesion = new PasosSesion(navegador);

        Productos productos = pasosSesion.sesionEstandar();

        Assert.assertEquals(productos.obtenerTitulo(), Constantes.TEXTO_TITULO_PRODUCTOS);
    }

    @Test(description = "TC-02 - Validar que un usuario bloqueado no pueda iniciar sesión")
    public void usuarioBloqueado() {
        PasosSesion pasosSesion = new PasosSesion(navegador);

        pasosSesion.iniciarSesion(Constantes.USUARIO_BLOQUEADO, Constantes.CONTRASENA_VALIDA);

        Assert.assertEquals(pasosSesion.obtenerMensajeError(), Constantes.ERROR_USUARIO_BLOQUEADO);
    }

    @Test(description = "TC-03 - Validar error al intentar iniciar sesión sin usuario")
    public void errorSinUsuario() {
        PasosSesion pasosSesion = new PasosSesion(navegador);

        pasosSesion.iniciarSesion("", Constantes.CONTRASENA_VALIDA);

        Assert.assertEquals(pasosSesion.obtenerMensajeError(), Constantes.ERROR_USUARIO_REQUERIDO);
    }

    @Test(description = "TC-04 - Validar error al intentar iniciar sesión sin contraseña")
    public void errorSinContrasena() {
        PasosSesion pasosSesion = new PasosSesion(navegador);

        pasosSesion.iniciarSesion(Constantes.USUARIO_ESTANDAR, "");

        Assert.assertEquals(pasosSesion.obtenerMensajeError(), Constantes.ERROR_CONTRASENA_REQUERIDA);
    }

    @Test(description = "TC-05 - Validar error al ingresar credenciales incorrectas")
    public void credencialesInvalidas() {
        PasosSesion pasosSesion = new PasosSesion(navegador);

        pasosSesion.iniciarSesion(Constantes.USUARIO_INCORRECTO, Constantes.CONTRASENA_INCORRECTA);

        Assert.assertEquals(pasosSesion.obtenerMensajeError(), Constantes.ERROR_CREDENCIALES_INVALIDAS);
    }

    @Test(description = "TC-06 - Validar que los elementos principales del login sean visibles")
    public void elementosInicioVisibles() {
        PasosSesion pasosSesion = new PasosSesion(navegador);

        Assert.assertTrue(pasosSesion.elementosVisibles());
    }
}
