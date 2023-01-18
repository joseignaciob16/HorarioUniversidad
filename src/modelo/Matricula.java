/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;

public class Matricula {

    private Estudiante[] estudiantes;
    private Materia[] materiasmatriculadas, materiasDisponibles;
    private int i1, i2, i3;

    public Matricula(int numero_Estudiantes, int numero_Matriculas, int num_MateriasDisponibles) {
        this.estudiantes = new Estudiante[numero_Estudiantes];
        this.materiasmatriculadas = new Materia[numero_Matriculas];
        this.materiasDisponibles = new Materia[num_MateriasDisponibles];

        this.materiasDisponibles[0] = new Materia(22, 220, "Luis Mnedez", "Ingles I", (byte) (int) 220);
        this.materiasDisponibles[1] = new Materia(22, 730, "Jose Luis Roger", "Matematicas", (byte) (int) 20);
        this.materiasDisponibles[2] = new Materia(22, 982, "Marta Diaz", "Programacion I", (byte) (int) 0);
        this.materiasDisponibles[3] = new Materia(22, 220, "Luisa Fernandez", "Ingles II", (byte) (int) 0);
        this.materiasDisponibles[4] = new Materia(22, 394, "Pedro herazo", "Ingles III", (byte) (int) 0);
        this.materiasDisponibles[5] = new Materia(22, 435, "Luis Mnedez", "Programacion II", (byte) (int) 0);
        this.materiasDisponibles[6] = new Materia(22, 43, "Luis Mnedez", "Ingles IV", (byte) (int) 0);
        this.materiasDisponibles[7] = new Materia(22, 344, "Luis Mnedez", "Ingles V", (byte) (int) 0);
        this.materiasDisponibles[8] = new Materia(22, 534, "Luis Mnedez", "Frances I", (byte) (int) 0);
        this.materiasDisponibles[9] = new Materia(22, 4543, "Luis Mnedez", "Frances II", (byte) (int) 0);
        this.materiasDisponibles[10] = new Materia(22, 54644, "Luis Mnedez", "Frances III", (byte) (int) 0);
        this.materiasDisponibles[11] = new Materia(22, 434, "Luis Mnedez", "Programacion lineal", (byte) (int) 0);

        this.estudiantes[3] = new Estudiante("Manuel", "rosa@asdasdasd.com", "Las veredas", "Informatica", 56);

        this.i1 = 0;
        this.i2 = 0;
        this.i3 = 0;

    }

    public Materia getMateriaDisponible(int pos) {
        return this.materiasDisponibles[pos];
    }

    public Materia getMateriaMatriculada(int pos) {
        return this.materiasmatriculadas[pos];
    }

    public Materia getMateriaMatriculada(String nombreMateria, int codEstudiante) {
        for (Materia mat : materiasmatriculadas) {
            if (mat != null) {
                if (mat.getNombreMateira().equalsIgnoreCase(nombreMateria) && mat.getCodigoEstudiante() == codEstudiante) {
                    return mat;
                }
            }
        }
        return null;
    }

    public void matricularMateria(int codigoEstudiante, int codigoMateria, String nombreProfesor, String nombreMateria, byte periodoAcademico) {
        Materia mat = new Materia(codigoEstudiante, codigoMateria, nombreProfesor, nombreMateria, periodoAcademico);

        //Buscamos si la materia esta repetida, si lo esta, no le asignaremos nada y mostraremos un mensaje en pantalla
        if (verificarNoMatricularEstudianteRepetido(mat.getCodigoEstudiante(), mat.getCodigoMateria(), 1)) {
            materiasmatriculadas[i1] = mat;
            JOptionPane.showMessageDialog(null, "Materia matriculada");
            i1++;
        } else {
            JOptionPane.showMessageDialog(null, "Ya esta matriculad@ en esta materia");
        }
    }

    public boolean verificarNoMatricularEstudianteRepetido(int codigoEstudiante, int codigoMateria, int listaARecorrer) {
        if (listaARecorrer == 1) {
            for (Materia materia : materiasmatriculadas) {
                if (materia != null) {
                    if (materia.getCodigoEstudiante() == codigoEstudiante && materia.getCodigoMateria() == codigoMateria) {
                        return false;
                    }
                }
            }
        } else if (listaARecorrer == 2) {
            for (Materia materia : materiasDisponibles) {
                if (materia != null) {
                    if (materia.getCodigoEstudiante() == codigoEstudiante && materia.getCodigoMateria() == codigoMateria) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //METODO PARA LA SECCION MATRICULAR BUSCAR MATERIA
    public Materia[] buscarMaterias(String nombreDeMateria) {

        Materia[] materiasEncontradas = new Materia[5];
        int i = 0;
        for (Materia materiasDisponible : materiasDisponibles) {
            if (nombreDeMateria.length() >= 1) {
                if (materiasDisponible != null) {
                    if (nombreDeMateria.length() < materiasDisponible.getNombreMateira().length()){//Estructura de seleccion para verificar que el metodo subString no se ponga mas digitos que los que tiene el atributo nombre de la clase materia
                        if (nombreDeMateria.equalsIgnoreCase(materiasDisponible.getNombreMateira().substring(0, nombreDeMateria.length()))) {
                            materiasEncontradas[i] = materiasDisponible;
                            i++;
                        }
                    }
                }
            }
        }

        return materiasEncontradas;
    }

    public Materia buscarNotaMayorMateria(String materia) {

        double nota = 0;

        Materia mayor = null;
        for (Materia mat : materiasmatriculadas) {
            if (mat != null) {
                if (mat.getNombreMateira().equalsIgnoreCase(materia)) {
                    if (nota < mat.getNotaFinal()) {
                        nota = mat.getNotaFinal();
                        mayor = mat;
                    }
                }
            }
        }

        return mayor;
    }

    //Metodo para mostrar las materias que tiene un estudiante
    public Materia[] buscarMateriasDeEstudiante(int codigo) {
        Materia[] listaDeMaterias = new Materia[materiasmatriculadas.length];
        int i4 = 0;

        for (Materia materia : materiasmatriculadas) {
            if (materia != null) {
                if (materia.getCodigoEstudiante() == codigo) {
                    listaDeMaterias[i4] = materia;
                    i4++;
                }
            }
        }

        return listaDeMaterias;
    }

    public void eliminarTodasLasMateriasDeUnEstudiante(int codigo) {

        for (int i = 0; i < materiasmatriculadas.length; i++) {
            if (materiasmatriculadas[i] != null) {
                if (materiasmatriculadas[i].getCodigoEstudiante() == codigo) {
                    materiasmatriculadas[i] = null;
                }
            }
        }

    }

    public void agregarMateria(int codigoMateria, String nombreProfesor, String nombreMateria) {
        Materia mat = new Materia(0, codigoMateria, nombreProfesor, nombreMateria, (byte) (int) 0);

        if (verificarNoMatricularEstudianteRepetido(0, codigoMateria, 2)) {
            materiasDisponibles[i3] = mat;
            i3++;
            JOptionPane.showMessageDialog(null, "Materia agregada a la lista");
        } else {
            JOptionPane.showMessageDialog(null, "El código que intenta establecer ya lo tiene otra materia");
        }

    }

    public void agregarEstudiante(String nombre, int codigo, String correo, String municipio, String carrera) {
        Estudiante est = new Estudiante(nombre, correo, municipio, carrera, codigo);

        if (buscarEstudiante(est.getNombre()) == null && buscarEstudiante(est.getCodigoEstudiante()) == null) {
            estudiantes[i2] = est;
            i2++;
            JOptionPane.showMessageDialog(null, "Estudiante agregado");
        } else {
            JOptionPane.showMessageDialog(null, "El codigo o nombre del estudiante ya ha sido agregado");
        }
    }

    public Estudiante buscarEstudiante(String nomb) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante != null) {
                if (estudiante.getNombre().equalsIgnoreCase(nomb)) {
                    return estudiante;
                }
            }
        }
        return null;
    }

    public Estudiante buscarEstudiante(int cod) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante != null) {
                if (estudiante.getCodigoEstudiante() == cod) {
                    return estudiante;
                }
            }
        }
        return null;
    }

    public boolean eliminarEstudiante(int codigo) {
        boolean verificacion = false;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null) {
                if (estudiantes[i].getCodigoEstudiante() == codigo) {
                    estudiantes[i] = null;
                    eliminarTodasLasMateriasDeUnEstudiante(codigo);
                    verificacion = true;
                }
            }
        }
        return verificacion;
    }

}
