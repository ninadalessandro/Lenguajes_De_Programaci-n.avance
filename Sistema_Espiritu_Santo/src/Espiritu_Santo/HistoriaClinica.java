package Espiritu_Santo;

import java.time.LocalDate;
import java.util.ArrayList;

public class HistoriaClinica {

    private int idHistoria;
    private LocalDate fechaApertura;
    private String antecedentes;

    // Una historia clínica puede contener varias atenciones
    private ArrayList<Atencion> atenciones;

    // Constructor vacío
    public HistoriaClinica() {
        atenciones = new ArrayList<>();
    }

    // Constructor con parámetros
    public HistoriaClinica(int idHistoria,
                           LocalDate fechaApertura,
                           String antecedentes) {

        this.idHistoria = idHistoria;
        this.fechaApertura = fechaApertura;
        this.antecedentes = antecedentes;

        atenciones = new ArrayList<>();
    }

    // Getters y Setters

    public int getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(int idHistoria) {
        this.idHistoria = idHistoria;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
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