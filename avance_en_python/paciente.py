from datetime import date

from persona import Persona
from historia_clinica import HistoriaClinica


class Paciente(Persona):

    def __init__(
        self,
        id,
        nombre,
        dni,
        telefono,
        fecha_nacimiento,
        direccion
    ):
        super().__init__(id, nombre, dni, telefono)

        self.__fecha_nacimiento = fecha_nacimiento
        self.__direccion = direccion

        self.__historia_clinica = HistoriaClinica(
            id,
            date.today(),
            "Sin antecedentes"
        )

    def mostrar_datos_paciente(self):
        print("===== DATOS DEL PACIENTE =====")
        print(self.obtener_datos())
        print(f"Fecha de nacimiento: {self.__fecha_nacimiento}")
        print(f"Dirección: {self.__direccion}")

    def consultar_historial(self):
        self.__historia_clinica.consultar_historial()

    def get_historia_clinica(self):
        return self.__historia_clinica
