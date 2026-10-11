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

public class FrmHistoriaClinica extends JFrame {

    private JTextField txtId;
    private JTextField txtFechaApertura;

    private JTextArea txtAntecedentes;

    private JComboBox<String> cboPaciente;

    private JTable tablaHistorias;
    private DefaultTableModel modeloTabla;

    public FrmHistoriaClinica() {

        // =====================================================
        // CONFIGURACIÓN DE LA VENTANA
        // =====================================================

        setTitle("Sistema Espiritu Santo - Historias Clinicas");
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

        JLabel lblTitulo = new JLabel("HISTORIA CLINICA");
        lblTitulo.setForeground(new Color(0, 100, 75));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(220, 0, 660, 80);
        panelEncabezado.add(lblTitulo);


        // =====================================================
        // INFORMACIÓN DE LA HISTORIA
        // =====================================================

        JLabel lblSeccionHistoria =
                crearTituloSeccion("INFORMACION DE LA HISTORIA CLINICA");

        lblSeccionHistoria.setBounds(30, 100, 820, 25);
        getContentPane().add(lblSeccionHistoria);


        // ID
        JLabel lblId = new JLabel("ID Historia");
        lblId.setBounds(40, 140, 150, 20);
        getContentPane().add(lblId);

        txtId = new JTextField();
        txtId.setBounds(40, 163, 350, 30);
        getContentPane().add(txtId);


        // Fecha apertura
        JLabel lblFecha =
                new JLabel("Fecha de apertura (AAAA-MM-DD)");

        lblFecha.setBounds(460, 140, 250, 20);
        getContentPane().add(lblFecha);

        txtFechaApertura = new JTextField();
        txtFechaApertura.setBounds(460, 163, 350, 30);
        getContentPane().add(txtFechaApertura);


        // =====================================================
        // PACIENTE
        // =====================================================

        JLabel lblPacienteSeccion =
                crearTituloSeccion("PACIENTE");

        lblPacienteSeccion.setBounds(30, 215, 400, 25);
        getContentPane().add(lblPacienteSeccion);


        JLabel lblPaciente = new JLabel("Seleccione al paciente");
        lblPaciente.setBounds(40, 255, 200, 20);
        getContentPane().add(lblPaciente);

        cboPaciente = new JComboBox<>();
        cboPaciente.setBounds(40, 278, 350, 30);
        getContentPane().add(cboPaciente);


        // =====================================================
        // ANTECEDENTES
        // =====================================================

        JLabel lblAntecedentesSeccion =
                crearTituloSeccion("ANTECEDENTES");

        lblAntecedentesSeccion.setBounds(450, 215, 400, 25);
        getContentPane().add(lblAntecedentesSeccion);


        JLabel lblAntecedentes =
                new JLabel("Antecedentes del paciente");

        lblAntecedentes.setBounds(460, 255, 200, 20);
        getContentPane().add(lblAntecedentes);


        txtAntecedentes = new JTextArea();
        txtAntecedentes.setLineWrap(true);
        txtAntecedentes.setWrapStyleWord(true);

        JScrollPane scrollAntecedentes =
                new JScrollPane(txtAntecedentes);

        scrollAntecedentes.setBounds(460, 278, 350, 75);
        getContentPane().add(scrollAntecedentes);


        // =====================================================
        // BOTONES
        // =====================================================

        JButton btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(245, 385, 120, 35);
        getContentPane().add(btnGuardar);

        JButton btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBounds(380, 385, 120, 35);
        getContentPane().add(btnLimpiar);

        JButton btnVolver = new JButton("VOLVER");
        btnVolver.setBounds(515, 385, 120, 35);
        getContentPane().add(btnVolver);


        // =====================================================
        // TABLA DE HISTORIAS
        // =====================================================

        JLabel lblHistorias =
                crearTituloSeccion("HISTORIAS CLINICAS REGISTRADAS");

        lblHistorias.setBounds(30, 450, 820, 25);
        getContentPane().add(lblHistorias);


        String[] columnas = {
                "ID",
                "Fecha Apertura",
                "Paciente",
                "DNI",
                "Antecedentes"
        };


        modeloTabla = new DefaultTableModel(columnas, 0) {

            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };


        tablaHistorias = new JTable(modeloTabla);

        JScrollPane scrollTabla =
                new JScrollPane(tablaHistorias);

        scrollTabla.setBounds(30, 485, 820, 115);
        getContentPane().add(scrollTabla);


        // =====================================================
        // CARGAR INFORMACIÓN
        // =====================================================

        cargarPacientes();
        actualizarTabla();


        // =====================================================
        // EVENTOS
        // =====================================================

        btnGuardar.addActionListener(e -> guardarHistoria());

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
                    + " - DNI: "
                    + paciente.getDni()
            );
        }
    }


    // =========================================================
    // GUARDAR HISTORIA CLÍNICA
    // =========================================================

    private void guardarHistoria() {

        try {

            // Primero debe existir por lo menos un paciente
            if (Data.lstPacientes.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Primero debe registrar un paciente."
                );

                return;
            }


            // Validamos campos
            if (txtId.getText().isEmpty()
                    || txtFechaApertura.getText().isEmpty()
                    || txtAntecedentes.getText().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Complete todos los campos."
                );

                return;
            }


            int id =
                    Integer.parseInt(txtId.getText());


            LocalDate fechaApertura =
                    LocalDate.parse(txtFechaApertura.getText());


            String antecedentes =
                    txtAntecedentes.getText();


            // Obtenemos el paciente seleccionado
            int indicePaciente =
                    cboPaciente.getSelectedIndex();


            Paciente paciente =
                    Data.lstPacientes.get(indicePaciente);


            // Comprobamos si el paciente ya tiene historia
            if (paciente.getHistoriaClinica() != null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Este paciente ya tiene una historia clinica."
                );

                return;
            }


            // Creamos la historia clínica
            HistoriaClinica historia =
                    new HistoriaClinica(
                            id,
                            fechaApertura,
                            antecedentes
                    );


            // Guardamos la historia en Data
            Data.lstHistorias.add(historia);


            // Relacionamos la historia con el paciente
            paciente.setHistoriaClinica(historia);


            actualizarTabla();
            limpiarCampos();


            JOptionPane.showMessageDialog(
                    this,
                    "Historia clinica registrada correctamente."
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
         * Recorremos los pacientes porque cada paciente
         * mantiene la referencia a su HistoriaClinica.
         */
        for (Paciente paciente : Data.lstPacientes) {

            HistoriaClinica historia =
                    paciente.getHistoriaClinica();


            if (historia != null) {

                Object[] fila = {

                        historia.getIdHistoria(),

                        historia.getFechaApertura(),

                        paciente.getNombre(),

                        paciente.getDni(),

                        historia.getAntecedentes()
                };


                modeloTabla.addRow(fila);
            }
        }
    }


    // =========================================================
    // LIMPIAR CAMPOS
    // =========================================================

    private void limpiarCampos() {

        txtId.setText("");
        txtFechaApertura.setText("");
        txtAntecedentes.setText("");


        if (cboPaciente.getItemCount() > 0) {

            cboPaciente.setSelectedIndex(0);
        }


        txtId.requestFocus();
    }


    // =========================================================
    // TÍTULOS DE LAS SECCIONES
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
                new Font("Tahoma", Font.BOLD, 12)
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