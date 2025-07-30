
package ec.edu.espe.proyectosupermercado.servicio;

import ec.edu.espe.proyectosupermercado.modelo.Categoria;
import ec.edu.espe.proyectosupermercado.modelo.ICategoria;
import ec.edu.espe.proyectosupermercado.modelo.IProducto;
import ec.edu.espe.proyectosupermercado.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private ArrayList<Categoria> categorias;
    private ArrayList<Producto> productos;

    public Supermercado() {
        categorias = new ArrayList<>();
        productos = new ArrayList<>();
        inicializarCategorias();
    }

    private void inicializarCategorias() {
        categorias.add(new Categoria("Carnicería"));
        categorias.add(new Categoria("Pescadería"));
        categorias.add(new Categoria("Frutas y Verduras"));
        categorias.add(new Categoria("Panadería"));
        categorias.add(new Categoria("Lácteos y Derivados"));
        categorias.add(new Categoria("Bebidas"));
        categorias.add(new Categoria("Despensa/No Perecederos"));
        categorias.add(new Categoria("Especias y Condimentos"));
        categorias.add(new Categoria("Limpieza y Hogar"));
        categorias.add(new Categoria("Higiene Personal"));
        categorias.add(new Categoria("Mascotas"));
        categorias.add(new Categoria("Snacks y Dulces"));
    }

    public void agregarProducto(String nombre, double precio, ICategoria categoria) {
        productos.add(new Producto(nombre, precio, categoria));
    }

    public void eliminarProducto(int index) {
        if (index >= 0 && index < productos.size()) {
            productos.remove(index);
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Índice no válido. No se eliminó ningún producto.");
        }
    }

    public void actualizarProducto(int index, String nuevoNombre, double nuevoPrecio, ICategoria nuevaCategoria) {
        if (index >= 0 && index < productos.size()) {
            IProducto producto = productos.get(index);
            if (producto instanceof Producto p) {
                p.setNombre(nuevoNombre);
                p.setPrecio(nuevoPrecio);
                p.setCategoria(nuevaCategoria);
                System.out.println("Producto actualizado exitosamente.");
            } else {
                System.out.println("No se pudo actualizar el producto.");
            }
        } else {
            System.out.println("Índice no válido. No se actualizó ningún producto.");
        }
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No se han ingresado productos.");
            return;
        }
        for (int i = 0; i < productos.size(); i++) {
            IProducto p = productos.get(i);
            System.out.println(i + ". Nombre: " + p.getNombre() + ", Precio: $" + p.getPrecio() + ", Categoría: " + p.getCategoria().getNombre());
        }
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public IProducto getProducto(int index) {
        if (index >= 0 && index < productos.size()) {
            return productos.get(index);
        } else {
            return null;
        }
    }
}
