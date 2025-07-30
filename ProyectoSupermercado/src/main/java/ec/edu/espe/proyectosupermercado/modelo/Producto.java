
package ec.edu.espe.proyectosupermercado.modelo;

// Clase para representar un producto

import ec.edu.espe.proyectosupermercado.modelo.IProducto;
import ec.edu.espe.proyectosupermercado.modelo.ICategoria;

public class Producto implements IProducto {
    private String nombre;
    private double precio;
    private ICategoria categoria;

    public Producto(String nombre, double precio, ICategoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public ICategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(ICategoria categoria) {
        this.categoria = categoria;
    }
}
