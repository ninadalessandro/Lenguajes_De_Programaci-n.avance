class HistoriaClinica:

    def __init__(
        self,
        id_historia,
        fecha_apertura,
        antecedentes
    ):
        self.__id_historia = id_historia
        self.__fecha_apertura = fecha_apertura
        self.__antecedentes = antecedentes

        self.__atenciones = []

    def agregar_atencion(self, atencion):
        self.__atenciones.append(atencion)

    def consultar_historial(self):
        print("===== HISTORIA CLÍNICA =====")
        print(f"ID Historia: {self.__id_historia}")
        print(f"Fecha de apertura: {self.__fecha_apertura}")
        print(f"Antecedentes: {self.__antecedentes}")

        print("\n===== ATENCIONES =====")

        if len(self.__atenciones) == 0:
            print("No hay atenciones registradas.")
        else:
            for atencion in self.__atenciones:
                atencion.mostrar_detalle()
