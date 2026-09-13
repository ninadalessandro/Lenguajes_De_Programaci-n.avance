package policlinico;

// Importamos LocalDate para trabajar con fechas
import java.time.LocalDate;

// La clase Paciente hereda de la clase Persona
public class Paciente extends Persona {

    // Atributos propios del paciente
    private LocalDate fechaNacimiento;
    private String direccion;

    // Cada paciente tiene una Historia Clínica
    private HistoriaClinica historiaClinica;

    // Constructor de la clase Paciente
    public Paciente(
            int id,
            String nombre,
            String dni,
            String telefono,
            LocalDate fechaNacimiento,
            String direccion) {

        // Llamamos al constructor de la clase padre Persona
        // para inicializar id, nombre, dni y telefono
        super(id, nombre, dni, telefono);

        // Inicializamos los atributos propios de Paciente
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;

        // Al crear un paciente, también se crea su Historia Clínica
        // Usamos el mismo id del paciente,
        // la fecha actual y un valor inicial para antecedentes
        historiaClinica = new HistoriaClinica(
                id,
                LocalDate.now(),
                "Sin antecedentes"
        );
    }

    // Método para mostrar los datos principales del paciente
    public void mostrarDatosPaciente() {

        System.out.println("===== DATOS DEL PACIENTE =====");

        // Este método viene heredado de la clase Persona
        System.out.println(obtenerDatos());

        // Mostramos los datos propios de Paciente
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
        System.out.println("Dirección: " + direccion);
    }

    // Método para consultar la Historia Clínica del paciente
    public void consultarHistorial() {

        // Llamamos al método consultarHistorial()
        // del objeto historiaClinica
        historiaClinica.consultarHistorial();
    }

    // Método que devuelve la Historia Clínica del paciente
    // Esto permite trabajar con ella desde otras partes del programa
    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }
}

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }
}
