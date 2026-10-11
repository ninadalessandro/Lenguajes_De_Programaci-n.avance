package Espiritu_Santo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Atencion {

    // ATRIBUTOS
    private int idAtencion;
    private LocalDate fecha;
    private String motivo;
    private String diagnostico;
    private String observaciones;

    // Una atencion puede tener varios medicamentos
    private ArrayList<Medicamento> medicamentos;


    // =====================================================
    // CONSTRUCTOR VACIO
    // =====================================================

    public Atencion() {

        medicamentos = new ArrayList<>();
    }


    // =====================================================
    // CONSTRUCTOR CON PARAMETROS
    // =====================================================

    public Atencion(int idAtencion,
                    LocalDate fecha,
                    String motivo,
                    String diagnostico,
                    String observaciones) {

        this.idAtencion = idAtencion;
        this.fecha = fecha;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.observaciones = observaciones;

        medicamentos = new ArrayList<>();
    }


    // =====================================================
    // GETTERS Y SETTERS
    // =====================================================

    public int getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(int idAtencion) {
        this.idAtencion = idAtencion;
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }


    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }


    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }


    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }


    // =====================================================
    // METODOS PARA MEDICAMENTOS
    // =====================================================

    public void agregarMedicamento(Medicamento medicamento) {

        medicamentos.add(medicamento);
    }


    public void eliminarMedicamento(Medicamento medicamento) {

        medicamentos.remove(medicamento);
    }
}