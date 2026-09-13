from datetime import date


class Atencion:

    def __init__(
        self,
        id_atencion,
        motivo_consulta,
        diagnostico,
        observaciones
    ):
        self.__id_atencion = id_atencion
        self.__fecha = date.today()
        self.__motivo_consulta = motivo_consulta
        self.__diagnostico = diagnostico
        self.__observaciones = observaciones

    def registrar(self):
        print("Atención registrada correctamente.")

    def mostrar_detalle(self):
        print("===== ATENCIÓN =====")
        print(f"ID Atención: {self.__id_atencion}")
        print(f"Fecha: {self.__fecha}")
        print(f"Motivo: {self.__motivo_consulta}")
        print(f"Diagnóstico: {self.__diagnostico}")
        print(f"Observaciones: {self.__observaciones}")
