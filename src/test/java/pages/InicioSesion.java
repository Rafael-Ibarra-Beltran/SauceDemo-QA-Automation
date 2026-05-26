package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InicioSesion extends BasePage {
    private final By campoUsuario = By.id("user-name");
    private final By campoContrasena = By.id("password");
    private final By botonIniciarSesion = By.id("login-button");
    private final By mensajeError = By.cssSelector("[data-test='error']");

    public InicioSesion(WebDriver navegador) {
        super(navegador);
    }

    public void ingresarUsuario(String usuario) {
        escribirTexto(campoUsuario, usuario);
    }

    public void ingresarContrasena(String contrasena) {
        escribirTexto(campoContrasena, contrasena);
    }

    public void clickIniciar() {
        hacerClick(botonIniciarSesion);
    }

    public void iniciarSesion(String usuario, String contrasena) {
        ingresarUsuario(usuario);
        ingresarContrasena(contrasena);
        clickIniciar();
    }

    public String obtenerMensajeError() {
        return obtenerTexto(mensajeError);
    }

    public boolean campoUsuarioVisible() {
        return estaVisible(campoUsuario);
    }

    public boolean campoContrasenaVisible() {
        return estaVisible(campoContrasena);
    }

    public boolean botonVisible() {
        return estaVisible(botonIniciarSesion);
    }
}
