package Espiritu_Santo;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import basedatos.Data;

public class FrmCita extends JFrame {

    private JTextField txtId;
    private JTextField txtFecha;
    private JTextField txtHora;

    private JComboBox<String> cboEstado;
    private JComboBox<String> cboPaciente;
    private JComboBox<String> cboMedico;

    private JTable tablaCitas;
    private DefaultTableModel modeloTabla;

    public FrmCita() {

        // =====================================================
        // CONFIGURACIÓN DE LA VENTANA
        // =====================================================

        setTitle("Sistema Espiritu Santo - Citas");
        setSize(900, 680);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        // =====================================================
        // ENCABEZADO
        // =====================================================

        JPanel panelEncabezado = new JPanel();
        panelEncabezado.setLayout(null);
        panelEncabezado.setBounds(0, 0, 900, 80);
        panelEncabezado.setBackground(new Color(180, 235, 205));
        getContentPane().add(panelEncabezado);

        JLabel lblSistema = new JLabel("ESPIRITU SANTO");
        lblSistema.setOpaque(true);
        lblSistema.setBackground(new Color(0, 110, 85));
        lblSistema.setForeground(Color.WHITE);
        lblSistema.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblSistema.setHorizontalAlignment(SwingConstants.CENTER);
        lblSistema.setBounds(0, 0, 220, 80);
        panelEncabezado.add(lblSistema);

        JLabel lblTitulo = new JLabel("REGISTRO DE CITA");
        lblTitulo.setForeground(new Color(0, 100, 75));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(220, 0, 660, 80);
        panelEncabezado.add(lblTitulo);


        // =====================================================
        // INFORMACIÓN DE LA CITA
        // =====================================================

        JLabel lblSeccionCita =
                crearTituloSeccion("INFORMACION DE LA CITA");

        lblSeccionCita.setBounds(30, 100, 820, 25);
        getContentPane().add(lblSeccionCita);


        // ID
        JLabel lblId = new JLabel("ID de la cita");
        lblId.setBounds(40, 140, 150, 20);
        getContentPane().add(lblId);

        txtId = new JTextField();
        txtId.setBounds(40, 163, 350, 30);
        getContentPane().add(txtId);


        // Estado
        JLabel lblEstado = new JLabel("Estado");
        lblEstado.setBounds(460, 140, 150, 20);
        getContentPane().add(lblEstado);

        cboEstado = new JComboBox<>();

        cboEstado.addItem("Pendiente");
        cboEstado.addItem("Confirmada");
        cboEstado.addItem("Atendida");
        cboEstado.addItem("Cancelada");

        cboEstado.setBounds(460, 163, 350, 30);
        getContentPane().add(cboEstado);


        // Fecha
        JLabel lblFecha = new JLabel("Fecha (AAAA-MM-DD)");
        lblFecha.setBounds(40, 205, 200, 20);
        getContentPane().add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(40, 228, 350, 30);
        getContentPane().add(txtFecha);


        // Hora
        JLabel lblHora = new JLabel("Hora (HH:MM)");
        lblHora.setBounds(460, 205, 150, 20);
        getContentPane().add(lblHora);

        txtHora = new JTextField();
        txtHora.setBounds(460, 228, 350, 30);
        getContentPane().add(txtHora);


        // =====================================================
        // PACIENTE Y MÉDICO
        // =====================================================

        JLabel lblRelacion =
                crearTituloSeccion("PACIENTE Y MEDICO");

        lblRelacion.setBounds(30, 280, 820, 25);
        getContentPane().add(lblRelacion);


        // Paciente
        JLabel lblPaciente = new JLabel("Paciente");
        lblPaciente.setBounds(40, 320, 150, 20);
        getContentPane().add(lblPaciente);

        cboPaciente = new JComboBox<>();
        cboPaciente.setBounds(40, 343, 350, 30);
        getContentPane().add(cboPaciente);


        // Médico
        JLabel lblMedico = new JLabel("Medico");
        lblMedico.setBounds(460, 320, 150, 20);
        getContentPane().add(lblMedico);

        cboMedico = new JComboBox<>();
        cboMedico.setBounds(460, 343, 350, 30);
        getContentPane().add(cboMedico);


        // =====================================================
        // BOTONES
        // =====================================================

        JButton btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(245, 400, 120, 35);
        getContentPane().add(btnGuardar);

        JButton btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBounds(380, 400, 120, 35);
        getContentPane().add(btnLimpiar);

        JButton btnVolver = new JButton("VOLVER");
        btnVolver.setBounds(515, 400, 120, 35);
        getContentPane().add(btnVolver);


        // =====================================================
        // TABLA
        // =====================================================

        JLabel lblCitas =
                crearTituloSeccion("CITAS REGISTRADAS");

        lblCitas.setBounds(30, 465, 820, 25);
        getContentPane().add(lblCitas);


        String[] columnas = {
                "ID",
                "Fecha",
                "Hora",
                "Estado",
                "Paciente",
                "Medico"
        };


        modeloTabla = new DefaultTableModel(columnas, 0) {

            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };


        tablaCitas = new JTable(modeloTabla);

        JScrollPane scrollTabla =
                new JScrollPane(tablaCitas);

        scrollTabla.setBounds(30, 500, 820, 105);
        getContentPane().add(scrollTabla);


        // =====================================================
        // CARGAMOS DATOS
        // =====================================================

        cargarPacientes();
        cargarMedicos();
        actualizarTabla();


        // =====================================================
        // EVENTOS
        // =====================================================

        btnGuardar.addActionListener(e -> guardarCita());

        btnLimpiar.addActionListener(e -> limpiarCampos());

        btnVolver.addActionListener(e -> dispose());
    }


    // =========================================================
    // CARGAR PACIENTES
    // =========================================================

    private void cargarPacientes() {

        cboPaciente.removeAllItems();

        for (Paciente paciente : Data.lstPacientes) {

            cboPaciente.addItem(
                    paciente.getId()
                    + " - "
                    + paciente.getNombre()
            );
        }
    }


    // =========================================================
    // CARGAR MÉDICOS
    // =========================================================

    private void cargarMedicos() {

        cboMedico.removeAllItems();

        for (Medico medico : Data.lstMedicos) {

            cboMedico.addItem(
                    medico.getId()
                    + " - "
                    + medico.getNombre()
                    + " - "
                    + medico.getEspecialidad()
            );
        }
    }


    // =========================================================
    // GUARDAR CITA
    // =========================================================

    private void guardarCita() {

        try {

            // Verificamos primero que existan pacientes y médicos
            if (Data.lstPacientes.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Primero debe registrar un paciente."
                );

                return;
            }


            if (Data.lstMedicos.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Primero debe registrar un medico."
                );

                return;
            }


            // Validamos campos
            if (txtId.getText().isEmpty()
                    || txtFecha.getText().isEmpty()
                    || txtHora.getText().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Complete todos los campos."
                );

                return;
            }


            int id =
                    Integer.parseInt(txtId.getText());


            LocalDate fecha =
                    LocalDate.parse(txtFecha.getText());


            LocalTime hora =
                    LocalTime.parse(txtHora.getText());


            String estado =
                    cboEstado.getSelectedItem().toString();


            // Obtenemos los objetos seleccionados
            int indicePaciente =
                    cboPaciente.getSelectedIndex();

            int indiceMedico =
                    cboMedico.getSelectedIndex();


            Paciente paciente =
                    Data.lstPacientes.get(indicePaciente);


            Medico medico =
                    Data.lstMedicos.get(indiceMedico);


            // Creamos la cita
            Cita cita = new Cita(
                    id,
                    fecha,
                    hora,
                    estado,
                    paciente,
                    medico
            );


            // Guardamos la cita en Data
            Data.lstCitas.add(cita);


            // También relacionamos la cita
            // con el paciente y con el médico
            paciente.agregarCita(cita);
            medico.agregarCita(cita);


            // Actualizamos tabla
            actualizarTabla();


            // Limpiamos
            limpiarCampos();


            JOptionPane.showMessageDialog(
                    this,
                    "Cita registrada correctamente."
            );


        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "El ID debe ser un numero."
            );


        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Verifique la fecha y la hora.\n"
                    + "Fecha: AAAA-MM-DD\n"
                    + "Hora: HH:MM"
            );
        }
    }


    // =========================================================
    // ACTUALIZAR TABLA
    // =========================================================

    private void actualizarTabla() {

        modeloTabla.setRowCount(0);


        for (Cita cita : Data.lstCitas) {

            Object[] fila = {

                    cita.getIdCita(),

                    cita.getFecha(),

                    cita.getHora(),

                    cita.getEstado(),

                    cita.getPaciente().getNombre(),

                    cita.getMedico().getNombre()
            };


            modeloTabla.addRow(fila);
        }
    }


    // =========================================================
    // LIMPIAR
    // =========================================================

    private void limpiarCampos() {

        txtId.setText("");
        txtFecha.setText("");
        txtHora.setText("");

        cboEstado.setSelectedIndex(0);


        if (cboPaciente.getItemCount() > 0) {
            cboPaciente.setSelectedIndex(0);
        }


        if (cboMedico.getItemCount() > 0) {
            cboMedico.setSelectedIndex(0);
        }


        txtId.requestFocus();
    }


    // =========================================================
    // TÍTULOS VERDES
    // =========================================================

    private JLabel crearTituloSeccion(String texto) {

        JLabel titulo =
                new JLabel("   " + texto);

        titulo.setOpaque(true);

        titulo.setBackground(
                new Color(0, 110, 85)
        );

        titulo.setForeground(Color.WHITE);

        titulo.setFont(
                new Font(
                        "Tahoma",
                        Font.BOLD,
                        12
                )
        );

        titulo.setBorder(
                BorderFactory.createEmptyBorder(
                        0,
                        5,
                        0,
                        0
                )
        );

        return titulo;
    }
}