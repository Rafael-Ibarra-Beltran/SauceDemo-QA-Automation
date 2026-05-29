package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Carrito;
import pages.Checkout;
import pages.DetalleProducto;
import pages.Productos;
import steps.PasosCheckout;
import steps.PasosProductos;
import steps.PasosSesion;
import utils.Constantes;

public class PruebasCasosExtendidos extends BaseTest {
    @Test(description = "TC-26 - Validar que se puedan agregar dos productos al carrito")
    public void agregarDosProductosAlCarrito() {
        new PasosSesion(navegador).sesionEstandar();
        PasosProductos pasosProductos = new PasosProductos(navegador);

        pasosProductos.agregarDosProductosAlCarrito();

        Assert.assertEquals(pasosProductos.obtenerCantidadCarrito(), "2");
    }

    @Test(description = "TC-27 - Validar visualización de dos productos dentro del carrito")
    public void dosProductosVisiblesEnCarrito() {
        new PasosSesion(navegador).sesionEstandar();
        PasosProductos pasosProductos = new PasosProductos(navegador);

        pasosProductos.agregarDosProductosAlCarrito();
        Carrito carrito = pasosProductos.abrirCarrito();

        Assert.assertEquals(carrito.cantidadProductos(), 2);
        Assert.assertTrue(carrito.productoVisible());
        Assert.assertTrue(carrito.luzBicicletaVisible());
    }

    @Test(description = "TC-28 - Validar regreso desde detalle de producto a página de productos")
    public void regresarDesdeDetalleAProductos() {
        new PasosSesion(navegador).sesionEstandar();
        PasosProductos pasosProductos = new PasosProductos(navegador);

        DetalleProducto detalleProducto = pasosProductos.abrirMochila();
        Productos productos = detalleProducto.regresarAProductos();

        Assert.assertEquals(productos.obtenerTitulo(), Constantes.TEXTO_TITULO_PRODUCTOS);
        Assert.assertTrue(productos.listaVisible());
    }

    @Test(description = "TC-29 - Validar resumen de checkout antes de finalizar compra")
    public void resumenCheckoutAntesDeFinalizar() {
        new PasosSesion(navegador).sesionEstandar();
        PasosCheckout pasosCheckout = new PasosCheckout(navegador);

        Checkout checkout = pasosCheckout.abrirResumenCheckoutConProducto();

        Assert.assertEquals(checkout.obtenerTitulo(), Constantes.TEXTO_TITULO_RESUMEN);
        Assert.assertEquals(checkout.obtenerProductoResumen(), Constantes.PRODUCTO_MOCHILA);
        Assert.assertTrue(checkout.totalResumenVisible());
    }

    @Test(description = "TC-30 - Validar regreso a productos después de completar la compra")
    public void regresarAProductosDespuesDeCompra() {
        new PasosSesion(navegador).sesionEstandar();
        PasosCheckout pasosCheckout = new PasosCheckout(navegador);

        pasosCheckout.abrirResumenCheckoutConProducto();
        pasosCheckout.finalizarCompra();
        Productos productos = new Checkout(navegador).volverAProductos();

        Assert.assertEquals(productos.obtenerTitulo(), Constantes.TEXTO_TITULO_PRODUCTOS);
        Assert.assertTrue(productos.listaVisible());
    }
}
