
package ec.edu.espe.proyectosupermercado.modelo;

// Interfaz para Producto

import ec.edu.espe.proyectosupermercado.modelo.ICategoria;

public interface IProducto {
    String getNombre();
    double getPrecio();
    ICategoria getCategoria();
}