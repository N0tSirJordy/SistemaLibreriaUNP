import java.util.ArrayList;
import java.util.Scanner;
public class Main{
  public static void main(String[] args){
    Main ap;
    ArrayList<Libro> biblioteca;
    ap= new Main();
    biblioteca=ap.generarLibros();
  }
  public Usuario ingresarUsuario(){
        Scanner sc;
        Usuario person;
        String dni;
        String nombre;
        sc = new Scanner(System.in);
        System.out.print("Nombre del usuario: ");
        nombre = sc.nextLine();
        System.out.print("DNI: ");
        dni = sc.nextLine();
        person = new Usuario(nombre,dni);
        return person;
    }
  public ArrayList<Libro> generarLibro(){
      ArrayList <Libro> biblio;
      Scanner teclado;
      int cantidad;
      Libro lib;
      biblio = new ArrayList<>();
      teclado = new Scanner(System.in);
      System.out.print("¿Cuántos libros desea ingresar?: ");
      cantidad = teclado.nextInt();
      for (int i = 0; i < cantidad; i++) {    
          lib = ingresarLibro(); 
          biblio.add(lib);
      }
      return biblio;
  }
    //Metodo para ingresar los datos de un libro
  public Libro ingresarLibro(){
    Scanner teclado;
    Libro nuev_libro;
    String titulo;
    String autor;
    String editorial;
    String codigo;
    teclado=new Scanner(System.in);
    //Ingreso de titulo
    System.out.print("Título: ");
    titulo = teclado.nextLine();
    //Ingreso de autor  
    System.out.print("Autor: ");
    autor= teclado.nextLine();
    //Ingreso de la editorial del libro 
    System.out.print("Editorial: ");
    editorial= teclado.nextLine();
    //Ingreso de codgio identificador del libro 
    System.out.print("Codigo: ");
    codigo= teclado.nextLine();
    nuev_libro = new Libro(titulo,autor,editorial ,codigo,"Disponible");
    return nuev_libro;
  }
  public Libro ingresarLib_Usuario(){
        Scanner teclado;
        String titulo;
        String autor;
        Libro busLibro;
        teclado= new Scanner(System.in);
        System.out.print("INGRESE EL LIBRO QUE BUSCA:");
        titulo=teclado.nextLine();
        System.out.print("INGRESE AUTOR");
        autor=teclado.nextLine();
        busLibro= new Libro(titulo,autor," ");
        return busLibro;
  }
  public void transaccionLibro(Usuario persona,Libro libro_busqueda , ArrayList<Libro> biblioteca){
      String titulo;
      Prestamo transaccion;
      titulo=libro_busqueda.getAutor();
      for(Libro libro:biblioteca){
          if(libro.getNombre().equals(titulo)){
              if (libro.getEstado().equalsIgnoreCase("Disponible")) {
                  libro.setEstado("Prestado"); 
                  transaccion= new Prestamo(libro, persona);
                  System.out.println("--- PROCESANDO PRÉSTAMO ---");
                  transaccion.imprimirTicket();
              } else {
                  System.out.println("¡ERROR! El libro '" + libro.getNombre() + "' no está disponible.");
            }
          }
      }
  }
  public void procesarDevolucion(Usuario persona,Libro libro_dev,ArrayList<Libro> biblioteca) {
    String titulo ;
    Prestamo trans;
    titulo = libro_dev.getNombre();
      for(Libro libro:biblioteca){
          if(libro.getNombre().equals(titulo)){
              if (libro.getEstado().equalsIgnoreCase("Prestado")) {
                  libro.setEstado("Disponible"); 
                  trans = new Prestamo(libro,null);
              }
          }
      }
  }
}
