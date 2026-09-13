package policlinico;

import java.time.LocalDate;

public class Atencion {

    private int idAtencion;
    private LocalDate fecha;
    private String motivoConsulta;
    private String diagnostico;
    private String observaciones;

    public Atencion(
            int idAtencion,
            String motivoConsulta,
            String diagnostico,
            String observaciones) {

        this.idAtencion = idAtencion;
        this.fecha = LocalDate.now();
        this.motivoConsulta = motivoConsulta;
        this.diagnostico = diagnostico;
        this.observaciones = observaciones;
    }

    public void mostrarDetalle() {
        System.out.println(
            "ID Atención: " + idAtencion +
            "\nFecha: " + fecha +
            "\nMotivo: " + motivoConsulta +
            "\nDiagnóstico: " + diagnostico +
            "\nObservaciones: " + observaciones
            );
     }
}