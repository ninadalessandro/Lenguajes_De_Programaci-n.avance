package Espiritu_Santo;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import basedatos.Data;

public class FrmAtencion extends JFrame {

    private JTextField txtId;
    private JTextField txtFecha;
    private JTextField txtMotivo;
    private JTextField txtDiagnostico;

    private JTextArea txtObservaciones;

    private JComboBox<String> cboPaciente;
    private JComboBox<String> cboMedicamento;

    private JTable tablaAtenciones;
    private DefaultTableModel modeloTabla;

    public FrmAtencion() {

        // =====================================================
        // CONFIGURACION DE LA VENTANA
        // =====================================================

        setTitle("Sistema Espiritu Santo - Atenciones");
        setSize(950, 720);
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
        panelEncabezado.setBounds(0, 0, 950, 80);
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


        JLabel lblTitulo = new JLabel("REGISTRO DE ATENCION");
        lblTitulo.setForeground(new Color(0, 100, 75));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(220, 0, 710, 80);
        panelEncabezado.add(lblTitulo);


        // =====================================================
        // INFORMACION DE LA ATENCION
        // =====================================================

        JLabel lblInformacion =
                crearTituloSeccion("INFORMACION DE LA ATENCION");

        lblInformacion.setBounds(30, 100, 870, 25);
        getContentPane().add(lblInformacion);


        // ID
        JLabel lblId = new JLabel("ID Atencion");
        lblId.setBounds(40, 140, 150, 20);
        getContentPane().add(lblId);

        txtId = new JTextField();
        txtId.setBounds(40, 163, 390, 30);
        getContentPane().add(txtId);


        // Fecha
        JLabel lblFecha = new JLabel("Fecha (AAAA-MM-DD)");
        lblFecha.setBounds(500, 140, 200, 20);
        getContentPane().add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(500, 163, 390, 30);
        getContentPane().add(txtFecha);


        // Motivo
        JLabel lblMotivo = new JLabel("Motivo de la atencion");
        lblMotivo.setBounds(40, 205, 200, 20);
        getContentPane().add(lblMotivo);

        txtMotivo = new JTextField();
        txtMotivo.setBounds(40, 228, 390, 30);
        getContentPane().add(txtMotivo);


        // Diagnóstico
        JLabel lblDiagnostico = new JLabel("Diagnostico");
        lblDiagnostico.setBounds(500, 205, 200, 20);
        getContentPane().add(lblDiagnostico);

        txtDiagnostico = new JTextField();
        txtDiagnostico.setBounds(500, 228, 390, 30);
        getContentPane().add(txtDiagnostico);


        // =====================================================
        // PACIENTE Y MEDICAMENTO
        // =====================================================

        JLabel lblRelacion =
                crearTituloSeccion("PACIENTE Y MEDICAMENTO");

        lblRelacion.setBounds(30, 280, 870, 25);
        getContentPane().add(lblRelacion);


        // Paciente
        JLabel lblPaciente =
                new JLabel("Paciente con historia clinica");

        lblPaciente.setBounds(40, 320, 250, 20);
        getContentPane().add(lblPaciente);

        cboPaciente = new JComboBox<>();
        cboPaciente.setBounds(40, 343, 390, 30);
        getContentPane().add(cboPaciente);


        // Medicamento
        JLabel lblMedicamento =
                new JLabel("Medicamento");

        lblMedicamento.setBounds(500, 320, 200, 20);
        getContentPane().add(lblMedicamento);

        cboMedicamento = new JComboBox<>();
        cboMedicamento.setBounds(500, 343, 390, 30);
        getContentPane().add(cboMedicamento);


        // =====================================================
        // OBSERVACIONES
        // =====================================================

        JLabel lblObservaciones =
                new JLabel("Observaciones");

        lblObservaciones.setBounds(40, 390, 200, 20);
        getContentPane().add(lblObservaciones);


        txtObservaciones = new JTextArea();
        txtObservaciones.setLineWrap(true);
        txtObservaciones.setWrapStyleWord(true);

        JScrollPane scrollObservaciones =
                new JScrollPane(txtObservaciones);

        scrollObservaciones.setBounds(40, 415, 850, 60);
        getContentPane().add(scrollObservaciones);


        // =====================================================
        // BOTONES
        // =====================================================

        JButton btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(270, 495, 120, 35);
        getContentPane().add(btnGuardar);

        JButton btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBounds(405, 495, 120, 35);
        getContentPane().add(btnLimpiar);

        JButton btnVolver = new JButton("VOLVER");
        btnVolver.setBounds(540, 495, 120, 35);
        getContentPane().add(btnVolver);


        // =====================================================
        // TABLA
        // =====================================================

        JLabel lblRegistradas =
                crearTituloSeccion("ATENCIONES REGISTRADAS");

        lblRegistradas.setBounds(30, 550, 870, 25);
        getContentPane().add(lblRegistradas);


        String[] columnas = {
                "ID",
                "Fecha",
                "Paciente",
                "Motivo",
                "Diagnostico",
                "Medicamento"
        };


        modeloTabla = new DefaultTableModel(columnas, 0) {

            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };


        tablaAtenciones = new JTable(modeloTabla);

        JScrollPane scrollTabla =
                new JScrollPane(tablaAtenciones);

        scrollTabla.setBounds(30, 585, 870, 80);
        getContentPane().add(scrollTabla);


        // =====================================================
        // CARGAR DATOS
        // =====================================================

        cargarPacientes();
        cargarMedicamentos();
        actualizarTabla();


        // =====================================================
        // EVENTOS
        // =====================================================

        btnGuardar.addActionListener(e -> guardarAtencion());

        btnLimpiar.addActionListener(e -> limpiarCampos());

        btnVolver.addActionListener(e -> dispose());
    }


    // =========================================================
    // CARGAR PACIENTES CON HISTORIA CLINICA
    // =========================================================

    private void cargarPacientes() {

        cboPaciente.removeAllItems();


        for (Paciente paciente : Data.lstPacientes) {

            // Solo mostramos pacientes que ya tengan historia clinica
            if (paciente.getHistoriaClinica() != null) {

                cboPaciente.addItem(
                        paciente.getId()
                        + " - "
                        + paciente.getNombre()
                );
            }
        }
    }


    // =========================================================
    // CARGAR MEDICAMENTOS
    // =========================================================

    private void cargarMedicamentos() {

        cboMedicamento.removeAllItems();


        for (Medicamento medicamento : Data.lstMedicamentos) {

            cboMedicamento.addItem(
                    medicamento.getIdMedicamento()
                    + " - "
                    + medicamento.getNombre()
                    + " - Stock: "
                    + medicamento.getStock()
            );
        }
    }


    // =========================================================
    // OBTENER PACIENTE SELECCIONADO
    // =========================================================

    private Paciente obtenerPacienteSeleccionado() {

        int posicion = 0;


        for (Paciente paciente : Data.lstPacientes) {

            if (paciente.getHistoriaClinica() != null) {

                if (posicion == cboPaciente.getSelectedIndex()) {

                    return paciente;
                }

                posicion++;
            }
        }


        return null;
    }


    // =========================================================
    // GUARDAR ATENCION
    // =========================================================

    private void guardarAtencion() {

        try {

            // Debe existir un paciente con historia clinica
            if (cboPaciente.getItemCount() == 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Primero debe registrar un paciente con historia clinica."
                );

                return;
            }


            // Debe existir un medicamento
            if (Data.lstMedicamentos.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Primero debe registrar un medicamento."
                );

                return;
            }


            // Validamos campos
            if (txtId.getText().isEmpty()
                    || txtFecha.getText().isEmpty()
                    || txtMotivo.getText().isEmpty()
                    || txtDiagnostico.getText().isEmpty()
                    || txtObservaciones.getText().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Complete todos los campos."
                );

                return;
            }


            // =================================================
            // OBTENEMOS LOS DATOS
            // =================================================

            int id =
                    Integer.parseInt(txtId.getText());


            LocalDate fecha =
                    LocalDate.parse(txtFecha.getText());


            String motivo =
                    txtMotivo.getText();


            String diagnostico =
                    txtDiagnostico.getText();


            String observaciones =
                    txtObservaciones.getText();


            // =================================================
            // OBTENEMOS EL PACIENTE
            // =================================================

            Paciente paciente =
                    obtenerPacienteSeleccionado();


            if (paciente == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "No se pudo obtener el paciente."
                );

                return;
            }


            // Obtenemos su historia clínica
            HistoriaClinica historia =
                    paciente.getHistoriaClinica();


            // =================================================
            // OBTENEMOS EL MEDICAMENTO
            // =================================================

            int indiceMedicamento =
                    cboMedicamento.getSelectedIndex();


            Medicamento medicamento =
                    Data.lstMedicamentos.get(
                            indiceMedicamento
                    );


            // =================================================
            // VALIDAMOS STOCK
            // =================================================

            if (medicamento.getStock() <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "El medicamento seleccionado no tiene stock."
                );

                return;
            }


            // =================================================
            // CREAMOS LA ATENCION
            // =================================================

            Atencion atencion =
                    new Atencion(
                            id,
                            fecha,
                            motivo,
                            diagnostico,
                            observaciones
                    );


            // =================================================
            // GUARDAMOS LAS RELACIONES
            // =================================================

            // Guardamos en Data
            Data.lstAtenciones.add(atencion);


            // Agregamos la atención a la historia clínica
            historia.agregarAtencion(atencion);


            // Agregamos el medicamento a la atención
            atencion.agregarMedicamento(medicamento);


            // Agregamos la atención al medicamento
            medicamento.agregarAtencion(atencion);


            // Restamos una unidad del stock
            medicamento.setStock(
                    medicamento.getStock() - 1
            );


            // =================================================
            // ACTUALIZAMOS
            // =================================================

            actualizarTabla();
            cargarMedicamentos();
            limpiarCampos();


            JOptionPane.showMessageDialog(
                    this,
                    "Atencion registrada correctamente."
            );


        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "El ID debe ser un numero."
            );


        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "La fecha debe tener el formato AAAA-MM-DD.\n"
                    + "Ejemplo: 2026-09-26"
            );
        }
    }


    // =========================================================
    // ACTUALIZAR TABLA
    // =========================================================

    private void actualizarTabla() {

        modeloTabla.setRowCount(0);


        /*
         * Recorremos los pacientes para poder conocer
         * a que paciente pertenece cada atencion.
         */
        for (Paciente paciente : Data.lstPacientes) {

            HistoriaClinica historia =
                    paciente.getHistoriaClinica();


            if (historia != null) {

                for (Atencion atencion :
                        historia.getAtenciones()) {


                    String medicamento = "Sin medicamento";


                    if (!atencion.getMedicamentos().isEmpty()) {

                        medicamento =
                                atencion
                                .getMedicamentos()
                                .get(0)
                                .getNombre();
                    }


                    Object[] fila = {

                            atencion.getIdAtencion(),

                            atencion.getFecha(),

                            paciente.getNombre(),

                            atencion.getMotivo(),

                            atencion.getDiagnostico(),

                            medicamento
                    };


                    modeloTabla.addRow(fila);
                }
            }
        }
    }


    // =========================================================
    // LIMPIAR CAMPOS
    // =========================================================

    private void limpiarCampos() {

        txtId.setText("");
        txtFecha.setText("");
        txtMotivo.setText("");
        txtDiagnostico.setText("");
        txtObservaciones.setText("");


        if (cboPaciente.getItemCount() > 0) {
            cboPaciente.setSelectedIndex(0);
        }


        if (cboMedicamento.getItemCount() > 0) {
            cboMedicamento.setSelectedIndex(0);
        }


        txtId.requestFocus();
    }


    // =========================================================
    // TITULOS VERDES
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