
package ec.edu.espe.proyectosupermercado.modelo;

// Clase para representar una categoría de productos

public class Categoria implements ICategoria {
    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}










/*
-clase prinicpal:Proyecto supermercado
-clase categoria:



*/





















