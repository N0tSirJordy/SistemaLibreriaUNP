class Libro{
    private String nombre;
    private String editorial;
    private String autor;
    private String codigo;
    private String estado;
    //Constructor 
    public Libro (String nombre,String autor,String editorial,String codigo,String estado){
        this.nombre=nombre;
        this.autor=autor;
        this.estado=estado;
    }
    public Libro(String nombre,String autor,String estado){
        this.nombre=nombre;
        this.autor=autor;
        this.estado=estado;
    }
    //Geters y Seters de la clase Libro 
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre= nombre;
    }
    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor=autor;
    }
    public String getEditorial(){
        return editorial;
    }
    public void setEditorial(String editorial){
        this.editorial= editorial;
    }
    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo=codigo;
    }
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado=estado;
    }
}