# Importamos date para poder trabajar con fechas
from datetime import date


# Esta clase representa una atención médica realizada a un paciente
class Atencion:

    # Constructor de la clase Atencion
    # Se ejecuta cuando creamos un nuevo objeto de tipo Atencion
    def __init__(
        self,
        id_atencion,
        motivo_consulta,
        diagnostico,
        observaciones
    ):
        # Guardamos el identificador de la atención
        self.__id_atencion = id_atencion

        # Obtenemos automáticamente la fecha actual
        self.__fecha = date.today()

        # Guardamos los datos correspondientes a la atención
        self.__motivo_consulta = motivo_consulta
        self.__diagnostico = diagnostico
        self.__observaciones = observaciones

    # Método que confirma que la atención fue registrada
    def registrar(self):
        print("Atención registrada correctamente.")

    # Método que muestra todos los datos de la atención médica
    def mostrar_detalle(self):
        print("===== ATENCIÓN =====")
        print(f"ID Atención: {self.__id_atencion}")
        print(f"Fecha: {self.__fecha}")
        print(f"Motivo: {self.__motivo_consulta}")
        print(f"Diagnóstico: {self.__diagnostico}")
        print(f"Observaciones: {self.__observaciones}")
