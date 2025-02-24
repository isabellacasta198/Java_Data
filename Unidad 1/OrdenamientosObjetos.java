import java.util.Arrays;

class Persona implements Comparable<Persona> {
    private int edad;
    private String nombre;

    // Constructor
    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    // Getters
    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    // Implementación de compareTo para comparar por edad
    @Override
    public int compareTo(Persona otraPersona) {
        return Integer.compare(this.edad, otraPersona.edad);
    }

    // Método para imprimir la persona en formato de cadena
    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }
}

public class OrdenamientosObjetos {
    public static void main(String[] args) {
        // Crear algunas personas para la comparación
        Persona persona1 = new Persona(62, "Diego");
        Persona persona2 = new Persona(63, "Fabiola");

        // Comparar los dos objetos usando compareTo (Comparable)
        if (persona1.compareTo(persona2) > 0)
            System.out.println("La persona 1 es mayor que la persona 2 (por el atributo que se compara)");
        else if (persona1.compareTo(persona2) < 0)
            System.out.println("La persona 1 es menor que la persona 2 (por el atributo que se compara)");
        else
            System.out.println("La persona 1 es igual que la persona 2 (por el atributo que se compara)");

        // Crear arreglo desordenado de 10 objetos de la clase Persona
        Persona[] personas = {
            new Persona(25, "Ana"),
            new Persona(30, "Juan"),
            new Persona(22, "Carlos"),
            new Persona(28, "Maria"),
            new Persona(20, "Luis"),
            new Persona(35, "Isabel"),
            new Persona(40, "Pedro"),
            new Persona(18, "Marta"),
            new Persona(33, "Javier"),
            new Persona(27, "Lucia")
        };

        // Mostrar arreglo original
        System.out.println("\nArreglo original:");
        for (Persona p : personas) {
            System.out.println(p);
        }

        // Ordenar el arreglo usando Arrays.sort()
        Arrays.sort(personas);

        // Mostrar el arreglo ordenado
        System.out.println("\nArreglo ordenado por edad:");
        for (Persona p : personas) {
            System.out.println(p);
        }
    }
}

