import java.util.Arrays;

// Clase Producto implementando Comparable para ordenar por precio
class Producto implements Comparable<Producto> {
    private int codigo;
    private String nombre;
    private double precio;

    // Constructor
    public Producto(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    // Implementación de compareTo para comparar por precio
    @Override
    public int compareTo(Producto otroProducto) {
        return Double.compare(this.precio, otroProducto.precio);
    }

    // Método para imprimir el producto en formato de cadena
    @Override
    public String toString() {
        return "Código: " + codigo + ", " + nombre + " - $" + precio;
    }
}

public class OrdenamientosProductos {
    public static void main(String[] args) {
        // Crear un arreglo de productos desordenado
        Producto[] productos = {
            new Producto(101, "Laptop", 850.50),
            new Producto(102, "Mouse", 25.75),
            new Producto(103, "Teclado", 45.90),
            new Producto(104, "Monitor", 300.00),
            new Producto(105, "Impresora", 150.30),
            new Producto(106, "Tablet", 200.50),
            new Producto(107, "Smartphone", 600.80),
            new Producto(108, "Auriculares", 35.40),
            new Producto(109, "Cámara", 500.00),
            new Producto(110, "Router", 75.99)
        };

        // Mostrar arreglo original
        System.out.println("\nArreglo original:");
        for (Producto p : productos) {
            System.out.println(p);
        }

        // Ordenar usando Bubble Sort
        bubbleSort(productos);
        System.out.println("\nArreglo ordenado por precio con Bubble Sort:");
        for (Producto p : productos) {
            System.out.println(p);
        }

        // Volver a desordenar los productos para probar Insertion Sort
        Producto[] productosDesordenados = {
            new Producto(101, "Laptop", 100.000),
            new Producto(102, "Mouse", 25.000),
            new Producto(103, "Teclado", 45.900),
            new Producto(104, "Monitor", 300.000),
            new Producto(105, "Impresora", 150.300),
            new Producto(106, "Tablet", 200.500),
            new Producto(107, "Smartphone", 600.800),
            new Producto(108, "Auriculares", 35.409),
            new Producto(109, "Cámara", 500.090),
            new Producto(110, "Router", 75.990)
        };

        // Ordenar usando Insertion Sort
        insertionSort(productosDesordenados);
        System.out.println("\nArreglo ordenado por precio con Insertion Sort:");
        for (Producto p : productosDesordenados) {
            System.out.println(p);
        }
    }

    // Método de ordenamiento Burbuja (Bubble Sort) por precio
    public static void bubbleSort(Producto[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Intercambio de productos
                    Producto temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Método de ordenamiento por Inserción (Insertion Sort) por precio
    public static void insertionSort(Producto[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Producto key = arr[i];
            int j = i - 1;

            // Mover los elementos mayores a la derecha
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}

