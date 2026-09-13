package policlinico;

// Importamos LocalDate para trabajar con fechas
import java.time.LocalDate;

// Esta clase representa una atención médica realizada a un paciente
public class Atencion {

    // Datos que se registran en cada atención médica
    private int idAtencion;
    private LocalDate fecha;
    private String motivoConsulta;
    private String diagnostico;
    private String observaciones;

    // Constructor de la clase Atencion
    public Atencion(
            int idAtencion,
            String motivoConsulta,
            String diagnostico,
            String observaciones) {

        // Inicializamos los datos recibidos
        this.idAtencion = idAtencion;

        // La fecha se obtiene automáticamente con la fecha actual
        this.fecha = LocalDate.now();

        this.motivoConsulta = motivoConsulta;
        this.diagnostico = diagnostico;
        this.observaciones = observaciones;
    }

    // Método que muestra toda la información
    // correspondiente a una atención médica
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
