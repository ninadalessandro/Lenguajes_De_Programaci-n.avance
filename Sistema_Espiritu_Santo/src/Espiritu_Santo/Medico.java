package Espiritu_Santo;

import java.util.ArrayList;

public class Medico extends Persona {

    private String especialidad;
    private String numeroColegiatura;
    private String turno;

    // Un médico puede tener varias citas
    private ArrayList<Cita> citas;

    // Constructor vacío
    public Medico() {
        citas = new ArrayList<>();
    }

    // Constructor con parámetros
    public Medico(int id, String nombre, String dni, String telefono,
                  String especialidad, String numeroColegiatura,
                  String turno) {

        super(id, nombre, dni, telefono);

        this.especialidad = especialidad;
        this.numeroColegiatura = numeroColegiatura;
        this.turno = turno;

        citas = new ArrayList<>();
    }

    // Getters y Setters

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNumeroColegiatura() {
        return numeroColegiatura;
    }

    public void setNumeroColegiatura(String numeroColegiatura) {
        this.numeroColegiatura = numeroColegiatura;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }

    public void agregarCita(Cita cita) {
        citas.add(cita);
    }
}