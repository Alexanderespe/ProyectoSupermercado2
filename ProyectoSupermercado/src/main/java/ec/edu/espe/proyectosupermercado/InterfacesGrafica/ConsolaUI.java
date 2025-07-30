package ec.edu.espe.proyectosupermercado.interfacesgrafica;

import ec.edu.espe.proyectosupermercado.modelo.Cliente;
import ec.edu.espe.proyectosupermercado.modelo.Factura;
import ec.edu.espe.proyectosupermercado.modelo.ICategoria;
import ec.edu.espe.proyectosupermercado.modelo.IProducto;
import ec.edu.espe.proyectosupermercado.servicio.Supermercado;

import java.util.Scanner;

public class ConsolaUI {
    private final Supermercado supermercado = new Supermercado();
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("--------- SUPERMERCADO (NOMBRE INVENTADO) -------");
            System.out.println("1. Ingresar Producto");
            System.out.println("2. Mostrar Productos");
            System.out.println("3. Actualizar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Imprimir Factura");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> ingresarProducto();
                case 2 -> supermercado.mostrarProductos();
                case 3 -> actualizarProducto();
                case 4 -> eliminarProducto();
                case 5 -> imprimirFactura();
                case 6 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }

            System.out.println();
        } while (opcion != 6);
    }

    private void ingresarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = Double.parseDouble(scanner.nextLine());

        mostrarCategorias();
        int indexCategoria = Integer.parseInt(scanner.nextLine());

        if (indexCategoria < 0 || indexCategoria >= supermercado.getCategorias().size()) {
            System.out.println("Índice de categoría inválido.");
            return;
        }

        ICategoria categoria = supermercado.getCategorias().get(indexCategoria);
        supermercado.agregarProducto(nombre, precio, categoria);
    }

    private void actualizarProducto() {
        System.out.print("Ingrese el índice del producto a actualizar: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (supermercado.getProducto(index) == null) {
            System.out.println("Índice de producto inválido.");
            return;
        }

        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo precio: ");
        double nuevoPrecio = Double.parseDouble(scanner.nextLine());

        mostrarCategorias();
        int indexCategoria = Integer.parseInt(scanner.nextLine());

        if (indexCategoria < 0 || indexCategoria >= supermercado.getCategorias().size()) {
            System.out.println("Índice de categoría inválido.");
            return;
        }

        ICategoria categoria = supermercado.getCategorias().get(indexCategoria);
        supermercado.actualizarProducto(index, nuevoNombre, nuevoPrecio, categoria);
    }

    private void eliminarProducto() {
        System.out.print("Ingrese el índice del producto a eliminar: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (supermercado.getProducto(index) == null) {
            System.out.println("Índice de producto inválido.");
            return;
        }

        supermercado.eliminarProducto(index);
    }

    private void imprimirFactura() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese la dirección del cliente: ");
        String direccion = scanner.nextLine();
        Cliente cliente = new Cliente(nombreCliente, direccion);
        Factura factura = new Factura();

        while (true) {
            supermercado.mostrarProductos();
            System.out.println("Seleccione producto (índice, -1 para terminar): ");
            int index = Integer.parseInt(scanner.nextLine());

            if (index == -1) break;

            IProducto producto = supermercado.getProducto(index);
            if (producto != null) {
                factura.agregarProducto(producto);
            } else {
                System.out.println("Índice no válido.");
            }
        }

        factura.imprimirFactura(cliente);
    }

    private void mostrarCategorias() {
        System.out.println("Seleccione una categoría:");
        for (int i = 0; i < supermercado.getCategorias().size(); i++) {
            System.out.println(i + ". " + supermercado.getCategorias().get(i).getNombre());
        }
    }
}
