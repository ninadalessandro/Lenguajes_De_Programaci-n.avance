package Espiritu_Santo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Paciente extends Persona {

    // Atributos propios del paciente
    private LocalDate fechaNacimiento;
    private String direccion;

    // Relación con HistoriaClinica
    private HistoriaClinica historiaClinica;

    // Un paciente puede tener varias citas
    private ArrayList<Cita> citas;


    // Constructor vacío
    public Paciente() {
        citas = new ArrayList<>();
    }


    // Constructor con parámetros
    public Paciente(int id, String nombre, String dni, String telefono,
                    LocalDate fechaNacimiento, String direccion) {

        // Llama al constructor de Persona
        super(id, nombre, dni, telefono);

        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;

        citas = new ArrayList<>();
    }


    // Getters y Setters

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }


    // Agregar una cita al paciente
    public void agregarCita(Cita cita) {
        citas.add(cita);
    }
}