package policlinico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistoriaClinica {

    private int idHistoria;
    private LocalDate fechaApertura;
    private String antecedentes;

    private List<Atencion> atenciones;

    public HistoriaClinica(
            int idHistoria,
            LocalDate fechaApertura,
            String antecedentes) {

        this.idHistoria = idHistoria;
        this.fechaApertura = fechaApertura;
        this.antecedentes = antecedentes;

        atenciones = new ArrayList<>();
    }

    public void agregarAtencion(Atencion atencion) {
        atenciones.add(atencion);
    }

    public void consultarHistorial() {

        System.out.println("===== HISTORIA CLÍNICA =====");
        System.out.println("ID Historia: " + idHistoria);
        System.out.println("Fecha de apertura: " + fechaApertura);
        System.out.println("Antecedentes: " + antecedentes);

        System.out.println("\n===== ATENCIONES =====");

        for (Atencion atencion : atenciones) {
            atencion.mostrarDetalle();
        }
    }
}