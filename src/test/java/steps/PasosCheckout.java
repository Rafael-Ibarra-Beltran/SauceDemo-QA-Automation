package steps;

import org.openqa.selenium.WebDriver;
import pages.Carrito;
import pages.Checkout;
import utils.Constantes;

public class PasosCheckout {
    private final WebDriver navegador;
    private Checkout checkout;

    public PasosCheckout(WebDriver navegador) {
        this.navegador = navegador;
    }

    public Checkout abrirCheckoutConProducto() {
        PasosProductos pasosProductos = new PasosProductos(navegador);
        pasosProductos.agregarMochilaAlCarrito();
        Carrito carrito = pasosProductos.abrirCarrito();
        carrito.iniciarCheckout();
        checkout = new Checkout(navegador);
        return checkout;
    }

    public void continuarConDatos(String nombre, String apellido, String codigoPostal) {
        if (checkout == null) {
            checkout = new Checkout(navegador);
        }
        checkout.llenarDatos(nombre, apellido, codigoPostal);
        checkout.continuar();
    }

    public void continuarSinNombre() {
        continuarConDatos("", Constantes.APELLIDO_COMPRADOR, Constantes.CODIGO_POSTAL);
    }

    public void continuarSinApellido() {
        continuarConDatos(Constantes.NOMBRE_COMPRADOR, "", Constantes.CODIGO_POSTAL);
    }

    public void continuarSinCodigoPostal() {
        continuarConDatos(Constantes.NOMBRE_COMPRADOR, Constantes.APELLIDO_COMPRADOR, "");
    }

    public void completarDatosValidos() {
        continuarConDatos(Constantes.NOMBRE_COMPRADOR, Constantes.APELLIDO_COMPRADOR, Constantes.CODIGO_POSTAL);
    }

    public void finalizarCompra() {
        if (checkout == null) {
            checkout = new Checkout(navegador);
        }
        checkout.finalizar();
    }

    public Carrito cancelarCheckout() {
        if (checkout == null) {
            checkout = new Checkout(navegador);
        }
        return checkout.cancelar();
    }

    public String obtenerMensajeError() {
        if (checkout == null) {
            checkout = new Checkout(navegador);
        }
        return checkout.obtenerMensajeError();
    }

    public String obtenerMensajeCompraCompletada() {
        if (checkout == null) {
            checkout = new Checkout(navegador);
        }
        return checkout.obtenerMensajeCompraCompletada();
    }
}
