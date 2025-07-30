package ec.edu.espe.proyectosupermercado.modelo;

import java.util.ArrayList;
import java.util.List;

// Asegúrate de que estas interfaces estén realmente en el paquete modelo
import ec.edu.espe.proyectosupermercado.modelo.ICliente;
import ec.edu.espe.proyectosupermercado.modelo.IFactura;
import ec.edu.espe.proyectosupermercado.modelo.IProducto;

public class Factura implements IFactura {
    private List<IProducto> productos;

    public Factura() {
        this.productos = new ArrayList<>();
    }

    @Override
    public void agregarProducto(IProducto producto) {
        productos.add(producto);
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (IProducto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    @Override
    public List<IProducto> getProductos() {
        return productos;
    }

    @Override
    public void imprimirFactura(ICliente cliente) {
        System.out.println("********** FACTURA **********");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Dirección: " + cliente.getDireccion());
        System.out.println("Productos Comprados:");
        for (IProducto p : productos) {
            System.out.println("- " + p.getNombre() + ": $" + p.getPrecio());
        }

        double subtotal = calcularTotal();
        double iva = subtotal * 0.12; // IVA del 12%
        double total = subtotal + iva;

        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("IVA (12%%): $%.2f%n", iva);
        System.out.printf("Total: $%.2f%n", total);
}
    }