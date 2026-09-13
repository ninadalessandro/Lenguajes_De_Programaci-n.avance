package policlinico;

// Importamos LocalDate para trabajar con fechas
import java.time.LocalDate;

// Importamos List y ArrayList para almacenar
// las diferentes atenciones del paciente
import java.util.ArrayList;
import java.util.List;

public class HistoriaClinica {

    // Datos principales de la Historia Clínica
    private int idHistoria;
    private LocalDate fechaApertura;
    private String antecedentes;

    // Lista que almacena las atenciones médicas
    // registradas en esta Historia Clínica
    private List<Atencion> atenciones;

    // Constructor de la clase HistoriaClinica
    public HistoriaClinica(
            int idHistoria,
            LocalDate fechaApertura,
            String antecedentes) {

        // Inicializamos los datos de la Historia Clínica
        this.idHistoria = idHistoria;
        this.fechaApertura = fechaApertura;
        this.antecedentes = antecedentes;

        // Creamos una lista vacía donde se almacenarán
        // las atenciones médicas del paciente
        atenciones = new ArrayList<>();
    }

    // Método que permite agregar una nueva atención
    // a la Historia Clínica
    public void agregarAtencion(Atencion atencion) {
        atenciones.add(atencion);
    }

    // Método que permite consultar toda la Historia Clínica
    public void consultarHistorial() {

        // Mostramos los datos generales de la Historia Clínica
        System.out.println("===== HISTORIA CLÍNICA =====");
        System.out.println("ID Historia: " + idHistoria);
        System.out.println("Fecha de apertura: " + fechaApertura);
        System.out.println("Antecedentes: " + antecedentes);

        System.out.println("\n===== ATENCIONES =====");

        // Recorremos todas las atenciones almacenadas
        // en la lista
        for (Atencion atencion : atenciones) {

            // Mostramos los detalles de cada atención
            atencion.mostrarDetalle();
        }
    }
}
