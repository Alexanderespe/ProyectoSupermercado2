package ec.edu.espe.proyectosupermercado.modelo;

import java.util.List;
import ec.edu.espe.proyectosupermercado.modelo.IProducto;
import ec.edu.espe.proyectosupermercado.modelo.ICliente;

public interface IFactura {
    void agregarProducto(IProducto producto);
    double calcularTotal();
    List<IProducto> getProductos();
    void imprimirFactura(ICliente cliente);
}
