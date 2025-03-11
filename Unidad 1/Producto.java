import java.util.*;

// Clase Producto que implementa Comparable y Comparator
class Producto implements Comparable<Producto> {
    private String codigo;
    private String descripcion;
    private int cantidad;
    private double precio;

    public Producto(String codigo, String descripcion, int cantidad, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int compareTo(Producto otro) {
        return this.codigo.compareTo(otro.codigo);
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", " + descripcion + " - Cantidad: " + cantidad + " - Precio: $" + precio;
    }
}

// Comparator para ordenar por precio
class ComparadorPorPrecio implements Comparator<Producto> {
    @Override
    public int compare(Producto p1, Producto p2) {
        return Double.compare(p1.getPrecio(), p2.getPrecio());
    }
}

// Comparator para ordenar por descripción
class ComparadorPorDescripcion implements Comparator<Producto> {
    @Override
    public int compare(Producto p1, Producto p2) {
        return p1.getDescripcion().compareTo(p2.getDescripcion());
    }
}

// Clase Lista Enlazada con QuickSort y MergeSort
class ListaEnlazada {
    private List<Producto> productos;

    public ListaEnlazada() {
        productos = new LinkedList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String codigo) {
        productos.removeIf(p -> p.getCodigo().equals(codigo));
    }

    public Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    public void ordenarPorCodigoQuickSort() {
        quickSort(0, productos.size() - 1);
    }

    private void quickSort(int inicio, int fin) {
        if (inicio < fin) {
            int pivoteIndex = particion(inicio, fin);
            quickSort(inicio, pivoteIndex - 1);
            quickSort(pivoteIndex + 1, fin);
        }
    }

    private int particion(int inicio, int fin) {
        Producto pivote = productos.get(fin);
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (productos.get(j).compareTo(pivote) < 0) {
                i++;
                Collections.swap(productos, i, j);
            }
        }
        Collections.swap(productos, i + 1, fin);
        return i + 1;
    }

    public void ordenarPorPrecioMergeSort() {
        productos = mergeSort(productos);
    }

    private List<Producto> mergeSort(List<Producto> lista) {
        if (lista.size() <= 1) {
            return lista;
        }
        int medio = lista.size() / 2;
        List<Producto> izquierda = mergeSort(new ArrayList<>(lista.subList(0, medio)));
        List<Producto> derecha = mergeSort(new ArrayList<>(lista.subList(medio, lista.size())));
        return merge(izquierda, derecha);
    }

    private List<Producto> merge(List<Producto> izquierda, List<Producto> derecha) {
        List<Producto> resultado = new ArrayList<>();
        int i = 0, j = 0;
        while (i < izquierda.size() && j < derecha.size()) {
            if (izquierda.get(i).getPrecio() < derecha.get(j).getPrecio()) {
                resultado.add(izquierda.get(i++));
            } else {
                resultado.add(derecha.get(j++));
            }
        }
        while (i < izquierda.size()) resultado.add(izquierda.get(i++));
        while (j < derecha.size()) resultado.add(derecha.get(j++));
        return resultado;
    }

    public void mostrarProductos() {
        for (Producto p : productos) {
            System.out.println(p);
        }
    }
}

// Clase Inventario con Pilas y Colas
class Inventario {
    private ListaEnlazada listaProductos;
    private Stack<Producto> devoluciones;
    private Queue<Producto> reposiciones;

    public Inventario() {
        listaProductos = new ListaEnlazada();
        devoluciones = new Stack<>();
        reposiciones = new LinkedList<>();
    }

    public void agregarProducto(Producto p) {
        listaProductos.agregarProducto(p);
    }

    public void ordenarPorCodigo() {
        listaProductos.ordenarPorCodigoQuickSort();
    }

    public void ordenarPorPrecio() {
        listaProductos.ordenarPorPrecioMergeSort();
    }

    public void devolverProducto(Producto p) {
        devoluciones.push(p);
    }

    public Producto procesarDevolucion() {
        return devoluciones.isEmpty() ? null : devoluciones.pop();
    }

    public void reponerProducto(Producto p) {
        reposiciones.add(p);
    }

    public Producto procesarReposicion() {
        return reposiciones.poll();
    }

    public void mostrarInventario() {
        listaProductos.mostrarProductos();
    }
}

// Clase Main para probar el sistema
class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        // Agregar productos
        inventario.agregarProducto(new Producto("P001", "Laptop", 10, 1200.99));
        inventario.agregarProducto(new Producto("P002", "Mouse", 50, 25.75));
        inventario.agregarProducto(new Producto("P003", "Teclado", 30, 45.90));

        System.out.println("Inventario inicial:");
        inventario.mostrarInventario();

        // Ordenar por código con QuickSort
        System.out.println("\nOrdenando por código con QuickSort...");
        inventario.ordenarPorCodigo();
        inventario.mostrarInventario();

        // Ordenar por precio con MergeSort
        System.out.println("\nOrdenando por precio con MergeSort...");
        inventario.ordenarPorPrecio();
        inventario.mostrarInventario();
    }
}

