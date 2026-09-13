# Importamos ABC para poder trabajar con una clase base abstracta
from abc import ABC


# Persona funciona como clase base o clase padre
class Persona(ABC):

    # Constructor de la clase Persona
    # Recibe los datos generales de una persona
    def __init__(self, id, nombre, dni, telefono):

        # Guardamos los datos recibidos como atributos del objeto
        # El doble guion bajo ayuda a restringir el acceso directo
        self.__id = id
        self.__nombre = nombre
        self.__dni = dni
        self.__telefono = telefono

    # Método que devuelve los datos principales de la persona
    def obtener_datos(self):
        return (
            f"ID: {self.__id}, "
            f"Nombre: {self.__nombre}, "
            f"DNI: {self.__dni}, "
            f"Teléfono: {self.__telefono}"
        )

    # Método getter que permite obtener el nombre
    def get_nombre(self):
        return self.__nombre
