import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Clase Producto
class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(int codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", " + nombre + " - $" + precio + " - Cantidad: " + cantidad;
    }
}

// Clase para manejar la lista de productos
public class ListasDeProductos {
    private static ArrayList<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {
        // Agregar productos
        productos.add(new Producto(101, "Laptop", 850.50, 5))ç;
        productos.add(new Producto(103, "Teclado", 45.90, 20));
        productos.add(new Producto(104, "Monitor", 300.00, 10));
        productos.add(new Producto(105, "Impresora", 150.30, 8));
        productos.add(new Producto(106, "Tablet", 200.50, 12));
        productos.add(new Producto(107, "Smartphone", 600.80, 15));
        productos.add(new Producto(108, "Auriculares", 35.40, 25));
    

        // Mostrar productos originales
        System.out.println("\nLista de productos original:");
        mostrarProductos();

        // Ordenar por precio usando Comparator
        productos.sort(Comparator.comparingDouble(Producto::getPrecio));
        System.out.println("\nLista ordenada por precio:");
        mostrarProductos();

        // Ordenar por cantidad usando Comparator
        productos.sort(Comparator.comparingInt(Producto::getCantidad));
        System.out.println("\nLista ordenada por cantidad:");
        mostrarProductos();

        // Buscar un producto por código
        int codigoBuscado = 104;
        Producto encontrado = buscarPorCodigo(codigoBuscado);
        System.out.println("\nBúsqueda de producto con código " + codigoBuscado + ": " + (encontrado != null ? encontrado : "No encontrado"));
    }

    // Mostrar productos
    public static void mostrarProductos() {
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    // Búsqueda secuencial por código
    public static Producto buscarPorCodigo(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }
}

