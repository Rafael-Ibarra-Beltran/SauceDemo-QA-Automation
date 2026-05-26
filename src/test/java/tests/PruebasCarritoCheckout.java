package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Carrito;
import pages.Checkout;
import steps.PasosCheckout;
import steps.PasosProductos;
import steps.PasosSesion;
import utils.Constantes;

public class PruebasCarritoCheckout extends BaseTest {
    @Test(description = "TC-11 - Validar que un producto pueda agregarse al carrito")
    public void agregarProductoAlCarrito() {
        new PasosSesion(navegador).sesionEstandar();
        PasosProductos pasosProductos = new PasosProductos(navegador);

        pasosProductos.agregarMochilaAlCarrito();

        Assert.assertEquals(pasosProductos.obtenerCantidadCarrito(), "1");
    }

    @Test(description = "TC-12 - Validar que un producto pueda eliminarse desde la página de productos")
    public void eliminarProductoDesdeProductos() {
        new PasosSesion(navegador).sesionEstandar();
        PasosProductos pasosProductos = new PasosProductos(navegador);

        pasosProductos.agregarMochilaAlCarrito();
        pasosProductos.eliminarMochilaDelCarrito();

        Assert.assertFalse(pasosProductos.contadorCarritoVisible());
    }

    @Test(description = "TC-13 - Validar visualización de producto dentro del carrito")
    public void productoVisibleEnCarrito() {
        new PasosSesion(navegador).sesionEstandar();
        PasosProductos pasosProductos = new PasosProductos(navegador);

        pasosProductos.agregarMochilaAlCarrito();
        Carrito carrito = pasosProductos.abrirCarrito();

        Assert.assertTrue(carrito.productoVisible());
        Assert.assertEquals(carrito.obtenerNombreProducto(), Constantes.PRODUCTO_MOCHILA);
    }

    @Test(description = "TC-14 - Validar inicio del proceso de checkout")
    public void iniciarProcesoCheckout() {
        new PasosSesion(navegador).sesionEstandar();

        Checkout checkout = new PasosCheckout(navegador).abrirCheckoutConProducto();

        Assert.assertEquals(checkout.obtenerTitulo(), Constantes.TEXTO_TITULO_CHECKOUT);
        Assert.assertTrue(checkout.formularioVisible());
    }

    @Test(description = "TC-15 - Validar error al continuar checkout sin nombre")
    public void errorCheckoutSinNombre() {
        new PasosSesion(navegador).sesionEstandar();
        PasosCheckout pasosCheckout = new PasosCheckout(navegador);

        pasosCheckout.abrirCheckoutConProducto();
        pasosCheckout.continuarSinNombre();

        Assert.assertEquals(pasosCheckout.obtenerMensajeError(), Constantes.ERROR_NOMBRE_REQUERIDO);
    }

    @Test(description = "TC-16 - Validar error al continuar checkout sin apellido")
    public void errorCheckoutSinApellido() {
        new PasosSesion(navegador).sesionEstandar();
        PasosCheckout pasosCheckout = new PasosCheckout(navegador);

        pasosCheckout.abrirCheckoutConProducto();
        pasosCheckout.continuarSinApellido();

        Assert.assertEquals(pasosCheckout.obtenerMensajeError(), Constantes.ERROR_APELLIDO_REQUERIDO);
    }

    @Test(description = "TC-17 - Validar error al continuar checkout sin código postal")
    public void errorCheckoutSinCodigoPostal() {
        new PasosSesion(navegador).sesionEstandar();
        PasosCheckout pasosCheckout = new PasosCheckout(navegador);

        pasosCheckout.abrirCheckoutConProducto();
        pasosCheckout.continuarSinCodigoPostal();

        Assert.assertEquals(pasosCheckout.obtenerMensajeError(), Constantes.ERROR_CODIGO_POSTAL_REQUERIDO);
    }

    @Test(description = "TC-18 - Validar finalización correcta de compra")
    public void finalizarCompraCorrectamente() {
        new PasosSesion(navegador).sesionEstandar();
        PasosCheckout pasosCheckout = new PasosCheckout(navegador);

        Checkout checkout = pasosCheckout.abrirCheckoutConProducto();
        pasosCheckout.completarDatosValidos();
        Assert.assertEquals(checkout.obtenerTitulo(), Constantes.TEXTO_TITULO_RESUMEN);
        pasosCheckout.finalizarCompra();

        Assert.assertEquals(pasosCheckout.obtenerMensajeCompraCompletada(), Constantes.TEXTO_COMPRA_COMPLETADA);
    }
}
