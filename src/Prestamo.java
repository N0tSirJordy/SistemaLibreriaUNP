import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Prestamo {
    private Libro libro_pres;
    private Usuario usuario;
    private LocalDate fechaEntrega;
    //Constructor Prestamo
    public Prestamo(Libro libro, Usuario usuario) {
        this.libro_pres = libro_pres;
        this.usuario = usuario;
        this.fechaEntrega = LocalDate.now().plusDays(15);
    }
    //Se entrega un ticket al usuario
    public void imprimirTicket() {
        System.out.println("Libro: " + libro.getNombre() + " | Usuario: " + usuario.getNombre_Alum());
        System.out.println("Fecha límite de devolución: " + fechaEntrega);
    }
    //Se cobrara 50 centimos por cada dia que no se entregue el libro
    public void procesarCobroDevolucion() {
        LocalDate hoy ;
        long d_retraso; 
        double multaTotal;
        hoy = LocalDate.now();
        System.out.println("Libro: " + libro.getNombre());
        if (hoy.isAfter(fechaEntrega)) {
            d_retraso = ChronoUnit.DAYS.between(fechaEntrega, hoy);
            multaTotal = d_retraso * 0.5;
            System.out.println("ESTADO: Entrega fuera de tiempo.");
            System.out.println("Días de retraso: " + d_retraso);
            System.out.println("Total a pagar: S/ " + multaTotal);
        } else {
            System.out.println("Entrega a tiempo");
        }
    }
}