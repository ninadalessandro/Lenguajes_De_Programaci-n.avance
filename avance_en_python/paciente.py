# Importamos date para trabajar con fechas
from datetime import date

# Importamos las clases que Paciente necesita utilizar
from persona import Persona
from historia_clinica import HistoriaClinica


# Paciente hereda de la clase Persona
class Paciente(Persona):

    # Constructor de la clase Paciente
    def __init__(
        self,
        id,
        nombre,
        dni,
        telefono,
        fecha_nacimiento,
        direccion
    ):
        # Llamamos al constructor de la clase padre Persona
        # para inicializar id, nombre, dni y telefono
        super().__init__(id, nombre, dni, telefono)

        # Guardamos los atributos propios del paciente
        self.__fecha_nacimiento = fecha_nacimiento
        self.__direccion = direccion

        # Al crear un paciente también creamos
        # automáticamente su Historia Clínica
        self.__historia_clinica = HistoriaClinica(
            id,
            date.today(),
            "Sin antecedentes"
        )

    # Método para mostrar los datos del paciente
    def mostrar_datos_paciente(self):
        print("===== DATOS DEL PACIENTE =====")

        # obtener_datos() es un método heredado de Persona
        print(self.obtener_datos())

        # Mostramos los atributos propios de Paciente
        print(f"Fecha de nacimiento: {self.__fecha_nacimiento}")
        print(f"Dirección: {self.__direccion}")

    # Método para consultar la Historia Clínica del paciente
    def consultar_historial(self):

        # Llamamos al método consultar_historial()
        # del objeto HistoriaClinica
        self.__historia_clinica.consultar_historial()

    # Método que devuelve la Historia Clínica del paciente
    def get_historia_clinica(self):
        return self.__historia_clinica
