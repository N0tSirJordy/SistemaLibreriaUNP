import java.util.ArrayList;
import java.util.Scanner;
public class Main{
  public static void main(String[] args){
    Main ap;
    ArrayList<Libro> biblioteca;
    int opcion;
    Usuario persona;
    Libro libroaux;
    biblioteca=null;
    ap =new Main();
    do{
      opcion=ap.opcionesBiblio();
      if(opcion==1){
        biblioteca=ap.genListaLibros();
      }else if(opcion==2){
        //se debe saber el nombre de la Persona que quiere un libro
        persona = ap.ingresarUsuario() ;
        //El libro que quiere
        libroaux=ap.ingresarLib_Usuario();
        /* Se procede a encontrar el libro en el arreglo y
        hacer el debido proceso*/
        ap.transaccionLibro(persona,libroaux,biblioteca);
      } else{
        persona = ap.ingresarUsuario() ;
        libroaux=ap.ingresarLib_Usuario();
        ap.procesarDevolucion(persona,libroaux,biblioteca);
      }
    }while(opcion!=0);
  }
  //Menu de opciones para el encargado
  public int opcionesBiblio(){
    Scanner teclado;
    int opcion;
    teclado= new Scanner(System.in);
    System.out.print("-------MENU-------");
    System.out.print("1. INGRESAR LIBROS");
    System.out.print("2. PRESTAR LIBRO ");
    System.out.print("3. DEVOLUCION DE LIBRO");
    System.out.print("0. SALIR");
    do{
        opcion=teclado.nextInt();
    }while(opcion>=0||opcion<=3);
    return opcion;
  }
  //Se ingresan los datos de la persona que requiere el libro
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
  /*-Se genera un Arraylist donde se guardaran los libros que se  encuentren en la biblioteca
    -Se llama al metodo ingresarLibro */ 
  public ArrayList<Libro> genListaLibros(){
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
  /*Metodo para ingresar los datos de un libro:
  -Nombre del libro
  -Autor 
  -Editorial
  -Codigo del libro 
  -Estado("Disponible o Prestado")
  */
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
  /*-Ingreso de datos del libro que se busca
    -El ususario no sabe si el libro esta disponible o no asi que se le pone vacio en estado*/
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
  //Transaccion de libros
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
  //Devolucion de libros 
  public void procesarDevolucion(Usuario persona,Libro libro_dev,ArrayList<Libro> biblioteca) {
    String titulo ;
    Prestamo transac;
    titulo = libro_dev.getNombre();
      for(Libro libro:biblioteca){
          if(libro.getNombre().equals(titulo)){
              if(libro.getEstado().equalsIgnoreCase("Prestado")) {
                  libro.setEstado("Disponible"); 
                  transac = new Prestamo(libro,null);
              }
          }
      }
  }
}
