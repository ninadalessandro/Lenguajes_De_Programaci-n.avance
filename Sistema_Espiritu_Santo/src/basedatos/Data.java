package basedatos;

import java.util.ArrayList;

import Espiritu_Santo.Atencion;
import Espiritu_Santo.Cita;
import Espiritu_Santo.HistoriaClinica;
import Espiritu_Santo.Medicamento;
import Espiritu_Santo.Medico;
import Espiritu_Santo.Paciente;

public class Data {

    // Listas que almacenan temporalmente los datos del sistema

    public static ArrayList<Paciente> lstPacientes =
            new ArrayList<Paciente>();

    public static ArrayList<Medico> lstMedicos =
            new ArrayList<Medico>();

    public static ArrayList<Cita> lstCitas =
            new ArrayList<Cita>();

    public static ArrayList<HistoriaClinica> lstHistorias =
            new ArrayList<HistoriaClinica>();

    public static ArrayList<Atencion> lstAtenciones =
            new ArrayList<Atencion>();

    public static ArrayList<Medicamento> lstMedicamentos =
            new ArrayList<Medicamento>();
}