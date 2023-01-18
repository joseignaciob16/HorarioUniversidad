/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author sjaes
 * @grupo Expression grupo is undefined on line 13, column 13 in
 * Templates/Classes/Class.java.
 * @FechaDeIniciacion Expression fecha is undefined on line 14, column 25 in
 * Templates/Classes/Class.java.
 */
public class Materia {

    private int codigoEstudiante,codigoMateria;
    private String nombreMateria,nombreProfesor;
    private double notaFinal;
    private byte peridoAcademico;

    public Materia(int codigoEstudiante,int codigoMateria,String nombreProfesor, String nombreMateria, byte periodoAcademico) {
        this.codigoEstudiante = codigoEstudiante;
        this.nombreProfesor = nombreProfesor;
        this.nombreMateria = nombreMateria;
        this.codigoMateria = codigoMateria;
        this.notaFinal = 0;
        this.peridoAcademico = periodoAcademico;
    }

    public int getCodigoEstudiante() {
        return this.codigoEstudiante;
    }

    public void setNombreMateria(String nombre) {
        this.nombreMateria = nombre;
    }
    
    public String getNombreProfesor() {
        return nombreProfesor;
    }
    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getNombreMateira() {
        return this.nombreMateria;
    }

    public void setNotaFinal(double nota) {
        this.notaFinal = nota;
    }

    public double getNotaFinal() {
        return this.notaFinal;
    }

    public void setPeriodoAcademico(byte periodo) {
        this.peridoAcademico = periodo;
    }

    public byte getPeriodoAcademico() {
        return this.peridoAcademico;
    }
    public int getCodigoMateria() {
        return codigoMateria;
    }


}
