package Espiritu_Santo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {

    private int idCita;
    private LocalDate fecha;
    private LocalTime hora;
    private String estado;

    private Paciente paciente;
    private Medico medico;

    // Constructor vacío
    public Cita() {
    }

    // Constructor con parámetros
    public Cita(int idCita,
                LocalDate fecha,
                LocalTime hora,
                String estado,
                Paciente paciente,
                Medico medico) {

        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.paciente = paciente;
        this.medico = medico;
    }

    // Getters y Setters

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}