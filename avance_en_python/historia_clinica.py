# Esta clase representa la Historia Clínica de un paciente
class HistoriaClinica:

    # Constructor de la clase HistoriaClinica
    # Recibe los datos necesarios para crear una historia clínica
    def __init__(
        self,
        id_historia,
        fecha_apertura,
        antecedentes
    ):
        # Guardamos los datos principales de la Historia Clínica
        self.__id_historia = id_historia
        self.__fecha_apertura = fecha_apertura
        self.__antecedentes = antecedentes

        # Creamos una lista vacía donde se almacenarán
        # las diferentes atenciones médicas del paciente
        self.__atenciones = []

    # Método que permite agregar una nueva atención
    # a la lista de la Historia Clínica
    def agregar_atencion(self, atencion):
        self.__atenciones.append(atencion)

    # Método que permite consultar toda la Historia Clínica
    def consultar_historial(self):

        # Mostramos los datos generales de la Historia Clínica
        print("===== HISTORIA CLÍNICA =====")
        print(f"ID Historia: {self.__id_historia}")
        print(f"Fecha de apertura: {self.__fecha_apertura}")
        print(f"Antecedentes: {self.__antecedentes}")

        print("\n===== ATENCIONES =====")

        # Verificamos si la lista de atenciones está vacía
        if len(self.__atenciones) == 0:
            print("No hay atenciones registradas.")

        # Si existen atenciones, recorremos la lista
        else:
            for atencion in self.__atenciones:

                # Cada objeto Atencion muestra sus propios detalles
                atencion.mostrar_detalle()
