/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 * Modelo que representa un producto de la tienda.
 *
 * En este proyecto cada producto es un disco de vinilo. La clase guarda los
 * datos principales que se muestran en la interfaz y que se usan para calcular
 * las ventas: id, nombre del album, artista, precio y stock disponible.
 */
public class Producto {

    // Esta es una variable de tipo int que guarda el identificador unico del producto.
    private int id;

    // Esta es una variable de tipo String que guarda el nombre del album o disco.
    private String nombre;

    // Esta es una variable de tipo String que guarda el nombre del artista.
    private String artista;

    // Esta es una variable de tipo double que guarda el precio unitario del producto.
    private double precio;

    // Esta es una variable de tipo int que guarda la cantidad disponible en inventario.
    private int stock;

    /**
     * Constructor de Producto.
     *
     * Recibe todos los datos necesarios y los guarda en los atributos del
     * objeto. Se usa al precargar productos y tambien al agregar nuevos desde
     * la ventana CRUD.
     */
    public Producto(int id, String nombre,
            String artista, double precio,
            int stock) {

        this.id = id;
        this.nombre = nombre;
        this.artista = artista;
        this.precio = precio;
        this.stock = stock;
    }

    // Los metodos get permiten consultar los valores privados del objeto.
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getArtista() {
        return artista;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    // Los metodos set permiten modificar los datos editables del producto.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
