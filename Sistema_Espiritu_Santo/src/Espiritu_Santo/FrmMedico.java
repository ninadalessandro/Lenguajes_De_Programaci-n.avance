package Espiritu_Santo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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

public class FrmMedico extends JFrame {

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtDni;
    private JTextField txtTelefono;
    private JTextField txtEspecialidad;
    private JTextField txtColegiatura;
    private JTextField txtTurno;

    private JTable tablaMedicos;
    private DefaultTableModel modeloTabla;

    public FrmMedico() {

        // =====================================================
        // CONFIGURACIÓN DE LA VENTANA
        // =====================================================

        setTitle("Sistema Espiritu Santo - Medicos");
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

        JLabel lblTitulo = new JLabel("REGISTRO DE MEDICO");
        lblTitulo.setForeground(new Color(0, 100, 75));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(220, 0, 660, 80);
        panelEncabezado.add(lblTitulo);


        // =====================================================
        // INFORMACIÓN DEL MÉDICO
        // =====================================================

        JLabel lblSeccionMedico =
                crearTituloSeccion("INFORMACION DEL MEDICO");

        lblSeccionMedico.setBounds(30, 100, 820, 25);
        getContentPane().add(lblSeccionMedico);


        // ID
        JLabel lblId = new JLabel("ID del medico");
        lblId.setBounds(40, 140, 150, 20);
        getContentPane().add(lblId);

        txtId = new JTextField();
        txtId.setBounds(40, 163, 350, 30);
        getContentPane().add(txtId);


        // Nombre
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(460, 140, 150, 20);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(460, 163, 350, 30);
        getContentPane().add(txtNombre);


        // DNI
        JLabel lblDni = new JLabel("DNI");
        lblDni.setBounds(40, 205, 150, 20);
        getContentPane().add(lblDni);

        txtDni = new JTextField();
        txtDni.setBounds(40, 228, 350, 30);
        getContentPane().add(txtDni);


        // Teléfono
        JLabel lblTelefono = new JLabel("Telefono");
        lblTelefono.setBounds(460, 205, 150, 20);
        getContentPane().add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(460, 228, 350, 30);
        getContentPane().add(txtTelefono);


        // =====================================================
        // INFORMACIÓN PROFESIONAL
        // =====================================================

        JLabel lblProfesional =
                crearTituloSeccion("INFORMACION PROFESIONAL");

        lblProfesional.setBounds(30, 280, 820, 25);
        getContentPane().add(lblProfesional);


        // Especialidad
        JLabel lblEspecialidad = new JLabel("Especialidad");
        lblEspecialidad.setBounds(40, 320, 150, 20);
        getContentPane().add(lblEspecialidad);

        txtEspecialidad = new JTextField();
        txtEspecialidad.setBounds(40, 343, 350, 30);
        getContentPane().add(txtEspecialidad);


        // Número de colegiatura
        JLabel lblColegiatura =
                new JLabel("Numero de colegiatura");

        lblColegiatura.setBounds(460, 320, 180, 20);
        getContentPane().add(lblColegiatura);

        txtColegiatura = new JTextField();
        txtColegiatura.setBounds(460, 343, 350, 30);
        getContentPane().add(txtColegiatura);


        // Turno
        JLabel lblTurno = new JLabel("Turno");
        lblTurno.setBounds(40, 385, 150, 20);
        getContentPane().add(lblTurno);

        txtTurno = new JTextField();
        txtTurno.setBounds(40, 408, 350, 30);
        getContentPane().add(txtTurno);


        // =====================================================
        // BOTONES
        // =====================================================

        JButton btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(460, 403, 110, 35);
        getContentPane().add(btnGuardar);

        JButton btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBounds(580, 403, 110, 35);
        getContentPane().add(btnLimpiar);

        JButton btnVolver = new JButton("VOLVER");
        btnVolver.setBounds(700, 403, 110, 35);
        getContentPane().add(btnVolver);


        // =====================================================
        // TABLA DE MÉDICOS
        // =====================================================

        JLabel lblMedicos =
                crearTituloSeccion("MEDICOS REGISTRADOS");

        lblMedicos.setBounds(30, 465, 820, 25);
        getContentPane().add(lblMedicos);


        String[] columnas = {
                "ID",
                "Nombre",
                "DNI",
                "Telefono",
                "Especialidad",
                "Colegiatura",
                "Turno"
        };


        modeloTabla = new DefaultTableModel(columnas, 0) {

            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };


        tablaMedicos = new JTable(modeloTabla);

        JScrollPane scrollTabla =
                new JScrollPane(tablaMedicos);

        scrollTabla.setBounds(30, 500, 820, 105);
        getContentPane().add(scrollTabla);


        // =====================================================
        // EVENTOS
        // =====================================================

        btnGuardar.addActionListener(e -> guardarMedico());

        btnLimpiar.addActionListener(e -> limpiarCampos());

        btnVolver.addActionListener(e -> dispose());


        // Mostramos médicos que ya estén registrados
        actualizarTabla();
    }


    // =========================================================
    // GUARDAR MÉDICO
    // =========================================================

    private void guardarMedico() {

        try {

            // Verificamos que ningún campo esté vacío
            if (txtId.getText().isEmpty()
                    || txtNombre.getText().isEmpty()
                    || txtDni.getText().isEmpty()
                    || txtTelefono.getText().isEmpty()
                    || txtEspecialidad.getText().isEmpty()
                    || txtColegiatura.getText().isEmpty()
                    || txtTurno.getText().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Complete todos los campos."
                );

                return;
            }


            // Convertimos el ID a entero
            int id = Integer.parseInt(txtId.getText());


            // Obtenemos los datos del formulario
            String nombre = txtNombre.getText();
            String dni = txtDni.getText();
            String telefono = txtTelefono.getText();
            String especialidad = txtEspecialidad.getText();
            String colegiatura = txtColegiatura.getText();
            String turno = txtTurno.getText();


            // Creamos el objeto Medico
            Medico medico = new Medico(
                    id,
                    nombre,
                    dni,
                    telefono,
                    especialidad,
                    colegiatura,
                    turno
            );


            // Guardamos el médico en Data
            Data.lstMedicos.add(medico);


            // Actualizamos la tabla
            actualizarTabla();


            // Limpiamos el formulario
            limpiarCampos();


            JOptionPane.showMessageDialog(
                    this,
                    "Medico registrado correctamente."
            );


        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "El ID debe ser un numero."
            );
        }
    }


    // =========================================================
    // ACTUALIZAR TABLA
    // =========================================================

    private void actualizarTabla() {

        modeloTabla.setRowCount(0);

        for (Medico medico : Data.lstMedicos) {

            Object[] fila = {

                    medico.getId(),

                    medico.getNombre(),

                    medico.getDni(),

                    medico.getTelefono(),

                    medico.getEspecialidad(),

                    medico.getNumeroColegiatura(),

                    medico.getTurno()
            };

            modeloTabla.addRow(fila);
        }
    }


    // =========================================================
    // LIMPIAR CAMPOS
    // =========================================================

    private void limpiarCampos() {

        txtId.setText("");
        txtNombre.setText("");
        txtDni.setText("");
        txtTelefono.setText("");
        txtEspecialidad.setText("");
        txtColegiatura.setText("");
        txtTurno.setText("");

        txtId.requestFocus();
    }


    // =========================================================
    // TÍTULOS VERDES
    // =========================================================

    private JLabel crearTituloSeccion(String texto) {

        JLabel titulo = new JLabel("   " + texto);

        titulo.setOpaque(true);
        titulo.setBackground(new Color(0, 110, 85));
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