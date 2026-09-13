package policlinico;

	public abstract class Persona {

	    private int id;
	    private String nombre;
	    private String dni;
	    private String telefono;

	    public Persona(int id, String nombre, String dni, String telefono) {
	        this.id = id;
	        this.nombre = nombre;
	        this.dni = dni;
	        this.telefono = telefono;
	    }

	    public String obtenerDatos() {
	        return "ID: " + id +
	               ", Nombre: " + nombre +
	               ", DNI: " + dni +
	               ", TelÃ©fono: " + telefono;
	    }

	    public String getNombre() {
	        return nombre;
	    }
	}

