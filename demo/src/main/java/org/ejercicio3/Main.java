package org.ejercicio3;
import java.util.ArrayList;
import java.util.Scanner;
import org.ejercicio3.entities.Contacto;
public class Main {
   
    public class GestionContactos {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            ArrayList<Contacto> listaContactos = new ArrayList<>();
    
            while (true) {
                System.out.println("1. Agregar contacto");
                System.out.println("2. Eliminar contacto");
                System.out.println("3. Buscar contacto");
                System.out.println("4. Mostrar todos los contactos");
                System.out.println("Seleccione una opción:");
    
                String opcion = scanner.nextLine();
    
                switch (opcion) {
                    case "1":
                        System.out.println("Nombre:");
                        String nombre = scanner.nextLine();
                        System.out.println("Teléfono:");
                        String telefono = scanner.nextLine();
                        System.out.println("Correo:");
                        String correo = scanner.nextLine();
                        listaContactos.add(new Contacto(nombre, telefono, correo));
                        System.out.println("Contacto agregado.");
                        break;
                    case "2":
                        if (listaContactos.isEmpty()) {
                            System.out.println("No hay contactos para eliminar.");
                            break;
                        }
                        System.out.println("Ingrese el nombre del contacto a eliminar:");
                        String nombreEliminar = scanner.nextLine();
                        listaContactos.removeIf(contacto -> contacto.getNombre().equalsIgnoreCase(nombreEliminar));
                        System.out.println("Contacto eliminado.");
                        break;
                    case "3":
                        if (listaContactos.isEmpty()) {
                            System.out.println("No hay contactos para buscar.");
                            break;
                        }
                        System.out.println("Ingrese el nombre del contacto a buscar:");
                        String nombreBuscar = scanner.nextLine();
                        listaContactos.stream()
                                .filter(contacto -> contacto.getNombre().equalsIgnoreCase(nombreBuscar))
                                .findFirst()
                                .ifPresentOrElse(
                                        System.out::println,
                                        () -> System.out.println("No se encontró el contacto.")
                                );
                        break;
                    case "4":
                        if (listaContactos.isEmpty()) {
                            System.out.println("No hay contactos para mostrar.");
                            break;
                        }
                        listaContactos.forEach(System.out::println);
                        scanner.close();
                        return;
                }
            }
        }
    }
    

}