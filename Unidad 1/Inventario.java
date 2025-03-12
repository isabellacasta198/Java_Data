import java.util.ArrayList;

public class Inventario {

    // Clase Producto que representa un producto en el inventario
    static class Producto {
        String nombre;
        int cantidad;

        public Producto(String nombre, int cantidad) {
            this.nombre = nombre;
            this.cantidad = cantidad;
        }

        public String getNombre() {
            return nombre;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void reducirCantidad(int cantidadVendida) {
            if (cantidad >= cantidadVendida) {
                cantidad -= cantidadVendida;
            }
        }

        @Override
        public String toString() {
            return nombre + " (Cantidad: " + cantidad + ")";
        }
    }

    // Lista de productos del inventario
    private ArrayList<Producto> productos;

    // Constructor del inventario
    public Inventario() {
        this.productos = new ArrayList<>();
    }

    // Método para agregar un producto al inventario
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Método para eliminar un producto (reducir cantidad) si tiene cantidad > 0
    public boolean eliminarProducto(String nombreProducto) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombreProducto) && producto.getCantidad() > 0) {
                producto.reducirCantidad(1);
                System.out.println("Producto vendido: " + producto.getNombre());
                return true;
            }
        }
        System.out.println("No se puede vender el producto " + nombreProducto + " porque no hay stock disponible.");
        return false;
    }

    // Mostrar inventario
    public void mostrarInventario() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("Inventario actual:");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        // Agregar productos al inventario
        inventario.agregarProducto(new Producto("Producto 1", 5));
        inventario.agregarProducto(new Producto("Producto 2", 10));
        inventario.agregarProducto(new Producto("Producto 3", 3));

        // Mostrar inventario
        inventario.mostrarInventario();

        // Vender productos (eliminar de la lista de inventario)
        inventario.eliminarProducto("Producto 1");
        inventario.eliminarProducto("Producto 2");

        // Mostrar inventario después de las ventas
        inventario.mostrarInventario();

        // Intentar vender un p
    }
}
