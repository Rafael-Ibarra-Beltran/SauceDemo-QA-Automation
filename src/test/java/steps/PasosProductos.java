package steps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.WebDriver;
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

    public void ordenarPorPrecioAsc() {
        productos.ordenarPorValor(Constantes.VALOR_ORDEN_PRECIO_MENOR_MAYOR);
    }

    public boolean nombresOrdenadosAZ() {
        List<String> nombresActuales = productos.obtenerNombresProductos();
        List<String> nombresEsperados = new ArrayList<>(nombresActuales);
        nombresEsperados.sort(String::compareTo);
        return nombresActuales.equals(nombresEsperados);
    }

    public boolean preciosOrdenadosAsc() {
        List<Double> preciosActuales = productos.obtenerPreciosProductos();
        List<Double> preciosEsperados = new ArrayList<>(preciosActuales);
        preciosEsperados.sort(Comparator.naturalOrder());
        return preciosActuales.equals(preciosEsperados);
    }
}
