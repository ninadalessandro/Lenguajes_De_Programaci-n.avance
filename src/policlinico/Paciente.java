package policlinico;

import java.time.LocalDate;

public class Paciente extends Persona {

    private LocalDate fechaNacimiento;
    private String direccion;
    private HistoriaClinica historiaClinica;

    public Paciente(
            int id,
            String nombre,
            String dni,
            String telefono,
            LocalDate fechaNacimiento,
            String direccion) {

        super(id, nombre, dni, telefono);

        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;

        historiaClinica = new HistoriaClinica(
                id,
                LocalDate.now(),
                "Sin antecedentes"
        );
    }

    public void mostrarDatosPaciente() {
        System.out.println("===== DATOS DEL PACIENTE =====");
        System.out.println(obtenerDatos());
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
        System.out.println("DirecciÃ³n: " + direccion);
    }

    public void consultarHistorial() {
        historiaClinica.consultarHistorial();
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }
}