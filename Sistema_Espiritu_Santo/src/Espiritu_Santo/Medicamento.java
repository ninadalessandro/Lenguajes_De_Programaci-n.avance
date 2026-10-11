package Espiritu_Santo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Medicamento {

    private int idMedicamento;
    private String nombre;
    private int stock;
    private LocalDate fechaVencimiento;

    // Relación con las atenciones
    private ArrayList<Atencion> atenciones;

    // Constructor vacío
    public Medicamento() {
        atenciones = new ArrayList<>();
    }

    // Constructor con parámetros
    public Medicamento(int idMedicamento,
                       String nombre,
                       int stock,
                       LocalDate fechaVencimiento) {

        this.idMedicamento = idMedicamento;
        this.nombre = nombre;
        this.stock = stock;
        this.fechaVencimiento = fechaVencimiento;

        atenciones = new ArrayList<>();
    }

    // Getters y Setters

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public ArrayList<Atencion> getAtenciones() {
        return atenciones;
    }

    public void setAtenciones(ArrayList<Atencion> atenciones) {
        this.atenciones = atenciones;
    }

    public void agregarAtencion(Atencion atencion) {
        atenciones.add(atencion);
    }

    public void eliminarAtencion(Atencion atencion) {
        atenciones.remove(atencion);
    }
}