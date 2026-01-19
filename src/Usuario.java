public class Usuario{
    private String nombre_Alum;
    private String dni;
    public Usuario(String nombre_Alum,String dni){
        this.nombre_Alum=nombre_Alum;
        this.dni=dni;
    }
    public String getNombre_Alum(){
        return nombre_Alum;
    }
    public String getDNI(){
        return dni;
    }
}
