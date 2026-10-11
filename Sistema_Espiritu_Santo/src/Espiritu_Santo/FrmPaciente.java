package Espiritu_Santo;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;

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

public class FrmPaciente extends JFrame {

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtDni;
    private JTextField txtTelefono;
    private JTextField txtFechaNacimiento;
    private JTextField txtDireccion;

    private JTable tablaPacientes;
    private DefaultTableModel modeloTabla;

    public FrmPaciente() {

        // =====================================================
        // CONFIGURACIÓN DE LA VENTANA
        // =====================================================

        setTitle("Sistema Espiritu Santo - Pacientes");
        setSize(900, 650);
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

        JLabel lblTitulo = new JLabel("REGISTRO DE PACIENTE");
        lblTitulo.setForeground(new Color(0, 100, 75));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(220, 0, 660, 80);
        panelEncabezado.add(lblTitulo);


        // =====================================================
        // INFORMACIÓN DEL PACIENTE
        // =====================================================

        JLabel lblSeccionPaciente =
                crearTituloSeccion("INFORMACION DEL PACIENTE");

        lblSeccionPaciente.setBounds(30, 100, 820, 25);
        getContentPane().add(lblSeccionPaciente);


        // ID
        JLabel lblId = new JLabel("ID del paciente");
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
        // INFORMACIÓN PERSONAL
        // =====================================================

        JLabel lblSeccionPersonal =
                crearTituloSeccion("INFORMACION PERSONAL");

        lblSeccionPersonal.setBounds(30, 280, 400, 25);
        getContentPane().add(lblSeccionPersonal);


        JLabel lblFecha = new JLabel("Fecha de nacimiento (AAAA-MM-DD)");
        lblFecha.setBounds(40, 320, 250, 20);
        getContentPane().add(lblFecha);

        txtFechaNacimiento = new JTextField();
        txtFechaNacimiento.setBounds(40, 343, 350, 30);
        getContentPane().add(txtFechaNacimiento);


        // =====================================================
        // DATOS DE CONTACTO
        // =====================================================

        JLabel lblSeccionContacto =
                crearTituloSeccion("DATOS DE CONTACTO");

        lblSeccionContacto.setBounds(450, 280, 400, 25);
        getContentPane().add(lblSeccionContacto);


        JLabel lblDireccion = new JLabel("Direccion");
        lblDireccion.setBounds(460, 320, 150, 20);
        getContentPane().add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(460, 343, 350, 30);
        getContentPane().add(txtDireccion);


        // =====================================================
        // BOTONES
        // =====================================================

        JButton btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(245, 395, 120, 35);
        getContentPane().add(btnGuardar);

        JButton btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBounds(380, 395, 120, 35);
        getContentPane().add(btnLimpiar);

        JButton btnVolver = new JButton("VOLVER");
        btnVolver.setBounds(515, 395, 120, 35);
        getContentPane().add(btnVolver);


        // =====================================================
        // TABLA DE PACIENTES
        // =====================================================

        JLabel lblPacientes =
                crearTituloSeccion("PACIENTES REGISTRADOS");

        lblPacientes.setBounds(30, 450, 820, 25);
        getContentPane().add(lblPacientes);


        // Columnas de nuestra tabla
        String[] columnas = {
                "ID",
                "Nombre",
                "DNI",
                "Telefono",
                "Fecha Nacimiento",
                "Direccion"
        };


        modeloTabla = new DefaultTableModel(columnas, 0) {

            // Evita que el usuario escriba directamente en la tabla
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };


        tablaPacientes = new JTable(modeloTabla);

        JScrollPane scrollTabla =
                new JScrollPane(tablaPacientes);

        scrollTabla.setBounds(30, 485, 820, 100);

        getContentPane().add(scrollTabla);


        // =====================================================
        // BOTÓN GUARDAR
        // =====================================================

        btnGuardar.addActionListener(e -> guardarPaciente());


        // =====================================================
        // BOTÓN LIMPIAR
        // =====================================================

        btnLimpiar.addActionListener(e -> limpiarCampos());


        // =====================================================
        // BOTÓN VOLVER
        // =====================================================

        btnVolver.addActionListener(e -> dispose());


        // Si ya existen pacientes, los mostramos
        actualizarTabla();
    }


    // =========================================================
    // GUARDAR PACIENTE
    // =========================================================

    private void guardarPaciente() {

        try {

            // Verificamos que no existan campos vacíos
            if (txtId.getText().isEmpty()
                    || txtNombre.getText().isEmpty()
                    || txtDni.getText().isEmpty()
                    || txtTelefono.getText().isEmpty()
                    || txtFechaNacimiento.getText().isEmpty()
                    || txtDireccion.getText().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Complete todos los campos."
                );

                return;
            }


            // Convertimos el ID ingresado a número
            int id = Integer.parseInt(txtId.getText());


            // Obtenemos los demás datos
            String nombre = txtNombre.getText();
            String dni = txtDni.getText();
            String telefono = txtTelefono.getText();

            LocalDate fechaNacimiento =
                    LocalDate.parse(txtFechaNacimiento.getText());

            String direccion = txtDireccion.getText();


            // Creamos un objeto Paciente
            Paciente paciente = new Paciente(
                    id,
                    nombre,
                    dni,
                    telefono,
                    fechaNacimiento,
                    direccion
            );


            // Guardamos el paciente en nuestra clase Data
            Data.lstPacientes.add(paciente);


            // Actualizamos la tabla
            actualizarTabla();


            // Limpiamos los campos
            limpiarCampos();


            // Confirmación
            JOptionPane.showMessageDialog(
                    this,
                    "Paciente registrado correctamente."
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
                    + "Ejemplo: 2003-08-15"
            );
        }
    }


    // =========================================================
    // ACTUALIZAR TABLA
    // =========================================================

    private void actualizarTabla() {

        // Borramos lo que actualmente muestra la tabla
        modeloTabla.setRowCount(0);


        // Recorremos la lista de pacientes
        for (Paciente paciente : Data.lstPacientes) {

            Object[] fila = {

                    paciente.getId(),

                    paciente.getNombre(),

                    paciente.getDni(),

                    paciente.getTelefono(),

                    paciente.getFechaNacimiento(),

                    paciente.getDireccion()
            };


            // Agregamos cada paciente a la tabla
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
        txtFechaNacimiento.setText("");
        txtDireccion.setText("");

        // Colocamos nuevamente el cursor en ID
        txtId.requestFocus();
    }


    // =========================================================
    // CREAR ENCABEZADOS VERDES
    // =========================================================

    private JLabel crearTituloSeccion(String texto) {

        JLabel titulo = new JLabel("   " + texto);

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