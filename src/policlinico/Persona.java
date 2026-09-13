package policlinico;

// Persona es una clase abstracta.
// Funciona como clase padre para compartir datos comunes.
public abstract class Persona {

    // Atributos privados para aplicar encapsulamiento.
    // Solo pueden accederse directamente dentro de esta clase.
    private int id;
    private String nombre;
    private String dni;
    private String telefono;

    // Constructor de Persona.
    // Recibe los datos y los almacena en los atributos del objeto.
    public Persona(int id, String nombre, String dni, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
    }

    // Método público que devuelve los datos de la persona.
    public String obtenerDatos() {
        return "ID: " + id +
               ", Nombre: " + nombre +
               ", DNI: " + dni +
               ", Teléfono: " + telefono;
    }

    // Getter que permite obtener el nombre de la persona.
    public String getNombre() {
        return nombre;
    }
}

