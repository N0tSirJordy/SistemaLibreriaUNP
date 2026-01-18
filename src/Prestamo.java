public class Prestamo{
    class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaEntrega;
    //Constructor Prestamo
    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaEntrega = LocalDate.now().plusDays(15);
    }
    public void imprimirTicket() {
        System.out.println("Libro: " + libro.getNombre() + " | Usuario: " + usuario.getNombre_Alum());
        System.out.println("Fecha límite de devolución: " + fechaEntrega);
    }
    }
}