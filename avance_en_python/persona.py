from abc import ABC


class Persona(ABC):

    def __init__(self, id, nombre, dni, telefono):
        self.__id = id
        self.__nombre = nombre
        self.__dni = dni
        self.__telefono = telefono

    def obtener_datos(self):
        return (
            f"ID: {self.__id}, "
            f"Nombre: {self.__nombre}, "
            f"DNI: {self.__dni}, "
            f"Teléfono: {self.__telefono}"
        )

    def get_nombre(self):
        return self.__nombre
