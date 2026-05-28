package steps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import pages.Carrito;
import pages.DetalleProducto;
import pages.Productos;
import utils.Constantes;

public class PasosProductos {
    private final WebDriver navegador;
    private final Productos productos;

    public PasosProductos(WebDriver navegador) {
        this.navegador = navegador;
        this.productos = new Productos(navegador);
    }

    public DetalleProducto abrirMochila() {
        productos.abrirMochila();
        return new DetalleProducto(navegador);
    }

    public void ordenarPorNombreAZ() {
        productos.ordenarPorValor(Constantes.VALOR_ORDEN_NOMBRE_A_Z);
    }

    public void ordenarPorNombreZA() {
        productos.ordenarPorValor(Constantes.VALOR_ORDEN_NOMBRE_Z_A);
    }

    public void ordenarPorPrecioAsc() {
        productos.ordenarPorValor(Constantes.VALOR_ORDEN_PRECIO_MENOR_MAYOR);
    }

    public void ordenarPorPrecioDesc() {
        productos.ordenarPorValor(Constantes.VALOR_ORDEN_PRECIO_MAYOR_MENOR);
    }

    public void agregarMochilaAlCarrito() {
        productos.agregarMochilaAlCarrito();
    }

    public void eliminarMochilaDelCarrito() {
        productos.eliminarMochilaDelCarrito();
    }

    public Carrito abrirCarrito() {
        productos.abrirCarrito();
        return new Carrito(navegador);
    }

    public String obtenerCantidadCarrito() {
        return productos.obtenerCantidadCarrito();
    }

    public boolean contadorCarritoVisible() {
        return productos.contadorCarritoVisible();
    }

    public boolean contadorCarritoOculto() {
        return productos.contadorCarritoOculto();
    }

    public void cerrarSesion() {
        productos.abrirMenu();
        productos.cerrarSesion();
    }

    public boolean elementosProductosVisibles() {
        return productos.tituloProductosVisible()
                && productos.carritoVisible()
                && productos.listaVisible();
    }

    public boolean nombresOrdenadosAZ() {
        List<String> nombresActuales = productos.obtenerNombresProductos();
        List<String> nombresEsperados = new ArrayList<>(nombresActuales);
        nombresEsperados.sort(String::compareTo);
        return nombresActuales.equals(nombresEsperados);
    }

    public boolean nombresOrdenadosZA() {
        List<String> nombresActuales = productos.obtenerNombresProductos();
        List<String> nombresEsperados = new ArrayList<>(nombresActuales);
        nombresEsperados.sort(Comparator.reverseOrder());
        return nombresActuales.equals(nombresEsperados);
    }

    public boolean preciosOrdenadosAsc() {
        List<Double> preciosActuales = productos.obtenerPreciosProductos();
        List<Double> preciosEsperados = new ArrayList<>(preciosActuales);
        preciosEsperados.sort(Comparator.naturalOrder());
        return preciosActuales.equals(preciosEsperados);
    }

    public boolean preciosOrdenadosDesc() {
        List<Double> preciosActuales = productos.obtenerPreciosProductos();
        List<Double> preciosEsperados = new ArrayList<>(preciosActuales);
        preciosEsperados.sort(Comparator.reverseOrder());
        return preciosActuales.equals(preciosEsperados);
    }
}
