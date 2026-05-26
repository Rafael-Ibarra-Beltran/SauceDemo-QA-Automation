package steps;

import org.openqa.selenium.WebDriver;
import pages.InicioSesion;
import pages.Productos;
import utils.Constantes;

public class PasosSesion {
    private final WebDriver navegador;
    private final InicioSesion inicioSesion;

    public PasosSesion(WebDriver navegador) {
        this.navegador = navegador;
        this.inicioSesion = new InicioSesion(navegador);
    }

    public Productos sesionEstandar() {
        inicioSesion.iniciarSesion(Constantes.USUARIO_ESTANDAR, Constantes.CONTRASENA_VALIDA);
        return new Productos(navegador);
    }

    public void iniciarSesion(String usuario, String contrasena) {
        inicioSesion.iniciarSesion(usuario, contrasena);
    }

    public String obtenerMensajeError() {
        return inicioSesion.obtenerMensajeError();
    }

    public boolean elementosVisibles() {
        return inicioSesion.campoUsuarioVisible()
                && inicioSesion.campoContrasenaVisible()
                && inicioSesion.botonVisible();
    }
}
