import tkinter as tk
from tkinter import ttk, messagebox


# =========================================================
# CLASE PERSONA
# =========================================================

class Persona:

    def __init__(self, id, nombre, dni, telefono):
        self.id = id
        self.nombre = nombre
        self.dni = dni
        self.telefono = telefono


# =========================================================
# CLASE PACIENTE
# =========================================================

class Paciente(Persona):

    def __init__(self, id, nombre, dni, telefono,
                 fecha_nacimiento, direccion):

        super().__init__(id, nombre, dni, telefono)

        self.fecha_nacimiento = fecha_nacimiento
        self.direccion = direccion
        self.historia_clinica = None
        self.citas = []


# =========================================================
# CLASE MEDICO
# =========================================================

class Medico(Persona):

    def __init__(self, id, nombre, dni, telefono,
                 especialidad, numero_colegiatura, turno):

        super().__init__(id, nombre, dni, telefono)

        self.especialidad = especialidad
        self.numero_colegiatura = numero_colegiatura
        self.turno = turno
        self.citas = []


# =========================================================
# CLASE CITA
# =========================================================

class Cita:

    def __init__(self, id_cita, fecha, hora,
                 estado, paciente, medico):

        self.id_cita = id_cita
        self.fecha = fecha
        self.hora = hora
        self.estado = estado
        self.paciente = paciente
        self.medico = medico


# =========================================================
# CLASE HISTORIA CLINICA
# =========================================================

class HistoriaClinica:

    def __init__(self, id_historia, fecha_apertura,
                 antecedentes):

        self.id_historia = id_historia
        self.fecha_apertura = fecha_apertura
        self.antecedentes = antecedentes
        self.atenciones = []

    def agregar_atencion(self, atencion):
        self.atenciones.append(atencion)


# =========================================================
# CLASE ATENCION
# =========================================================

class Atencion:

    def __init__(self, id_atencion, fecha, motivo,
                 diagnostico, observaciones):

        self.id_atencion = id_atencion
        self.fecha = fecha
        self.motivo = motivo
        self.diagnostico = diagnostico
        self.observaciones = observaciones
        self.medicamentos = []

    def agregar_medicamento(self, medicamento):
        self.medicamentos.append(medicamento)


# =========================================================
# CLASE MEDICAMENTO
# =========================================================

class Medicamento:

    def __init__(self, id_medicamento, nombre,
                 stock, fecha_vencimiento):

        self.id_medicamento = id_medicamento
        self.nombre = nombre
        self.stock = stock
        self.fecha_vencimiento = fecha_vencimiento
        self.atenciones = []


# =========================================================
# DATOS DEL SISTEMA
# =========================================================

pacientes = []
medicos = []
citas = []
historias = []
atenciones = []
medicamentos = []


# =========================================================
# FUNCIONES GENERALES
# =========================================================

def crear_ventana(titulo):

    ventana = tk.Toplevel()
    ventana.title(titulo)
    ventana.geometry("650x600")
    ventana.resizable(False, False)

    titulo_label = tk.Label(
        ventana,
        text=titulo.upper(),
        font=("Arial", 18, "bold")
    )

    titulo_label.pack(pady=20)

    return ventana


def crear_campo(contenedor, texto):

    frame = tk.Frame(contenedor)
    frame.pack(pady=5)

    label = tk.Label(
        frame,
        text=texto,
        width=20,
        anchor="w"
    )

    label.pack(side="left")

    entrada = tk.Entry(
        frame,
        width=35
    )

    entrada.pack(side="left")

    return entrada


# =========================================================
# FORMULARIO PACIENTE
# =========================================================

def formulario_paciente():

    ventana = crear_ventana("Registro de Paciente")

    id_paciente = crear_campo(ventana, "ID:")
    nombre = crear_campo(ventana, "Nombre:")
    dni = crear_campo(ventana, "DNI:")
    telefono = crear_campo(ventana, "Teléfono:")
    fecha = crear_campo(ventana, "Fecha nacimiento:")
    direccion = crear_campo(ventana, "Dirección:")

    def guardar():

        try:

            paciente = Paciente(
                int(id_paciente.get()),
                nombre.get(),
                dni.get(),
                telefono.get(),
                fecha.get(),
                direccion.get()
            )

            pacientes.append(paciente)

            messagebox.showinfo(
                "Paciente",
                "Paciente registrado correctamente"
            )

        except ValueError:

            messagebox.showerror(
                "Error",
                "El ID debe ser un número"
            )

    tk.Button(
        ventana,
        text="Guardar Paciente",
        width=25,
        command=guardar
    ).pack(pady=20)


# =========================================================
# FORMULARIO MEDICO
# =========================================================

def formulario_medico():

    ventana = crear_ventana("Registro de Médico")

    id_medico = crear_campo(ventana, "ID:")
    nombre = crear_campo(ventana, "Nombre:")
    dni = crear_campo(ventana, "DNI:")
    telefono = crear_campo(ventana, "Teléfono:")
    especialidad = crear_campo(ventana, "Especialidad:")
    colegiatura = crear_campo(ventana, "N° Colegiatura:")
    turno = crear_campo(ventana, "Turno:")

    def guardar():

        try:

            medico = Medico(
                int(id_medico.get()),
                nombre.get(),
                dni.get(),
                telefono.get(),
                especialidad.get(),
                colegiatura.get(),
                turno.get()
            )

            medicos.append(medico)

            messagebox.showinfo(
                "Médico",
                "Médico registrado correctamente"
            )

        except ValueError:

            messagebox.showerror(
                "Error",
                "El ID debe ser un número"
            )

    tk.Button(
        ventana,
        text="Guardar Médico",
        width=25,
        command=guardar
    ).pack(pady=20)


# =========================================================
# FORMULARIO CITA
# =========================================================

def formulario_cita():

    ventana = crear_ventana("Registro de Cita")

    id_cita = crear_campo(ventana, "ID Cita:")
    fecha = crear_campo(ventana, "Fecha:")
    hora = crear_campo(ventana, "Hora:")
    estado = crear_campo(ventana, "Estado:")

    tk.Label(
        ventana,
        text="Paciente:"
    ).pack()

    combo_paciente = ttk.Combobox(
        ventana,
        state="readonly",
        width=35
    )

    combo_paciente["values"] = [
        paciente.nombre for paciente in pacientes
    ]

    combo_paciente.pack(pady=5)

    tk.Label(
        ventana,
        text="Médico:"
    ).pack()

    combo_medico = ttk.Combobox(
        ventana,
        state="readonly",
        width=35
    )

    combo_medico["values"] = [
        medico.nombre for medico in medicos
    ]

    combo_medico.pack(pady=5)

    def guardar():

        if combo_paciente.current() == -1:
            messagebox.showerror(
                "Error",
                "Seleccione un paciente"
            )
            return

        if combo_medico.current() == -1:
            messagebox.showerror(
                "Error",
                "Seleccione un médico"
            )
            return

        try:

            paciente = pacientes[
                combo_paciente.current()
            ]

            medico = medicos[
                combo_medico.current()
            ]

            cita = Cita(
                int(id_cita.get()),
                fecha.get(),
                hora.get(),
                estado.get(),
                paciente,
                medico
            )

            citas.append(cita)

            paciente.citas.append(cita)
            medico.citas.append(cita)

            messagebox.showinfo(
                "Cita",
                "Cita registrada correctamente"
            )

        except ValueError:

            messagebox.showerror(
                "Error",
                "El ID debe ser un número"
            )

    tk.Button(
        ventana,
        text="Guardar Cita",
        width=25,
        command=guardar
    ).pack(pady=20)


# =========================================================
# FORMULARIO HISTORIA CLINICA
# =========================================================

def formulario_historia():

    ventana = crear_ventana("Historia Clínica")

    id_historia = crear_campo(
        ventana,
        "ID Historia:"
    )

    fecha = crear_campo(
        ventana,
        "Fecha apertura:"
    )

    antecedentes = crear_campo(
        ventana,
        "Antecedentes:"
    )

    tk.Label(
        ventana,
        text="Paciente:"
    ).pack()

    combo = ttk.Combobox(
        ventana,
        state="readonly",
        width=35
    )

    combo["values"] = [
        paciente.nombre for paciente in pacientes
    ]

    combo.pack(pady=5)

    def guardar():

        if combo.current() == -1:

            messagebox.showerror(
                "Error",
                "Seleccione un paciente"
            )

            return

        try:

            historia = HistoriaClinica(
                int(id_historia.get()),
                fecha.get(),
                antecedentes.get()
            )

            paciente = pacientes[
                combo.current()
            ]

            paciente.historia_clinica = historia

            historias.append(historia)

            messagebox.showinfo(
                "Historia Clínica",
                "Historia clínica registrada"
            )

        except ValueError:

            messagebox.showerror(
                "Error",
                "El ID debe ser un número"
            )

    tk.Button(
        ventana,
        text="Guardar Historia",
        width=25,
        command=guardar
    ).pack(pady=20)


# =========================================================
# FORMULARIO ATENCION
# =========================================================

def formulario_atencion():

    ventana = crear_ventana("Registro de Atención")

    id_atencion = crear_campo(
        ventana,
        "ID Atención:"
    )

    fecha = crear_campo(
        ventana,
        "Fecha:"
    )

    motivo = crear_campo(
        ventana,
        "Motivo:"
    )

    diagnostico = crear_campo(
        ventana,
        "Diagnóstico:"
    )

    observaciones = crear_campo(
        ventana,
        "Observaciones:"
    )

    def guardar():

        try:

            atencion = Atencion(
                int(id_atencion.get()),
                fecha.get(),
                motivo.get(),
                diagnostico.get(),
                observaciones.get()
            )

            atenciones.append(atencion)

            messagebox.showinfo(
                "Atención",
                "Atención registrada correctamente"
            )

        except ValueError:

            messagebox.showerror(
                "Error",
                "El ID debe ser un número"
            )

    tk.Button(
        ventana,
        text="Guardar Atención",
        width=25,
        command=guardar
    ).pack(pady=20)


# =========================================================
# FORMULARIO MEDICAMENTO
# =========================================================

def formulario_medicamento():

    ventana = crear_ventana("Registro de Medicamento")

    id_medicamento = crear_campo(
        ventana,
        "ID Medicamento:"
    )

    nombre = crear_campo(
        ventana,
        "Nombre:"
    )

    stock = crear_campo(
        ventana,
        "Stock:"
    )

    vencimiento = crear_campo(
        ventana,
        "Fecha vencimiento:"
    )

    def guardar():

        try:

            medicamento = Medicamento(
                int(id_medicamento.get()),
                nombre.get(),
                int(stock.get()),
                vencimiento.get()
            )

            medicamentos.append(medicamento)

            messagebox.showinfo(
                "Medicamento",
                "Medicamento registrado correctamente"
            )

        except ValueError:

            messagebox.showerror(
                "Error",
                "ID y stock deben ser números"
            )

    tk.Button(
        ventana,
        text="Guardar Medicamento",
        width=25,
        command=guardar
    ).pack(pady=20)


# =========================================================
# VENTANA PRINCIPAL
# =========================================================

ventana = tk.Tk()

ventana.title(
    "Sistema Espíritu Santo"
)

ventana.geometry(
    "600x550"
)

ventana.resizable(
    False,
    False
)


titulo = tk.Label(
    ventana,
    text="SISTEMA ESPÍRITU SANTO",
    font=("Arial", 20, "bold")
)

titulo.pack(
    pady=35
)


tk.Button(
    ventana,
    text="Pacientes",
    width=30,
    height=2,
    command=formulario_paciente
).pack(pady=5)


tk.Button(
    ventana,
    text="Médicos",
    width=30,
    height=2,
    command=formulario_medico
).pack(pady=5)


tk.Button(
    ventana,
    text="Citas",
    width=30,
    height=2,
    command=formulario_cita
).pack(pady=5)


tk.Button(
    ventana,
    text="Historias Clínicas",
    width=30,
    height=2,
    command=formulario_historia
).pack(pady=5)


tk.Button(
    ventana,
    text="Atenciones",
    width=30,
    height=2,
    command=formulario_atencion
).pack(pady=5)


tk.Button(
    ventana,
    text="Medicamentos",
    width=30,
    height=2,
    command=formulario_medicamento
).pack(pady=5)


ventana.mainloop()
