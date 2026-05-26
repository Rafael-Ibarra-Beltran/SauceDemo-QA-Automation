package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DetalleProducto;
import pages.Productos;
import steps.PasosSesion;
import steps.PasosProductos;
import utils.Constantes;

public class PruebasProductos extends BaseTest {
    @Test(description = "TC-07 - Validar visualización de la lista de productos")
    public void listaProductosVisible() {
        Productos productos = new PasosSesion(navegador).sesionEstandar();

        Assert.assertTrue(productos.listaVisible());
        Assert.assertTrue(productos.cantidadProductos() > 0);
    }

    @Test(description = "TC-08 - Validar acceso al detalle de un producto")
    public void detalleProducto() {
        new PasosSesion(navegador).sesionEstandar();
        PasosProductos pasosProductos = new PasosProductos(navegador);

        DetalleProducto detalleProducto = pasosProductos.abrirMochila();

        Assert.assertTrue(detalleProducto.detalleVisible());
        Assert.assertEquals(detalleProducto.obtenerNombre(), Constantes.PRODUCTO_MOCHILA);
    }

    @Test(description = "TC-09 - Validar ordenamiento de productos por nombre A-Z")
    public void ordenNombreAZ() {
        new PasosSesion(navegador).sesionEstandar();
        PasosProductos pasosProductos = new PasosProductos(navegador);

        pasosProductos.ordenarPorNombreAZ();

        Assert.assertTrue(pasosProductos.nombresOrdenadosAZ());
    }

    @Test(description = "TC-10 - Validar ordenamiento de productos por precio menor a mayor")
    public void ordenPrecioMenorMayor() {
        new PasosSesion(navegador).sesionEstandar();
        PasosProductos pasosProductos = new PasosProductos(navegador);

        pasosProductos.ordenarPorPrecioAsc();

        Assert.assertTrue(pasosProductos.preciosOrdenadosAsc());
    }

    @Test(description = "TC-20 - Validar elementos principales de la página de productos")
    public void elementosProductosVisibles() {
        new PasosSesion(navegador).sesionEstandar();
        PasosProductos pasosProductos = new PasosProductos(navegador);

        Assert.assertTrue(pasosProductos.elementosProductosVisibles());
    }
}
