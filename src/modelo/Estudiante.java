package modelo;

public class Estudiante {

    private int codigoEstudiante;
    private String nombre, correo, municipio, carrera;

    public Estudiante(String nom, String correo, String municipio, String carrera, int codigo) {
        this.nombre = nom;
        this.correo = correo;
        this.municipio = municipio;
        this.carrera = carrera;
        this.codigoEstudiante = codigo;
    }

    public void setCodigoEstudiante(int cod) {
        this.codigoEstudiante = cod;
    }

    public int getCodigoEstudiante() {
        return this.codigoEstudiante;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getMunicipio() {
        return this.municipio;
    }

    public void setCorrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCarrera() {
        return this.carrera;
    }
    
    

}
