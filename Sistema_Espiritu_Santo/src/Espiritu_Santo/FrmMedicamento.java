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

public class FrmMedicamento extends JFrame {

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtStock;
    private JTextField txtFechaVencimiento;

    private JTable tablaMedicamentos;
    private DefaultTableModel modeloTabla;

    public FrmMedicamento() {

        // =====================================================
        // CONFIGURACION DE LA VENTANA
        // =====================================================

        setTitle("Sistema Espiritu Santo - Medicamentos");
        setSize(900, 620);
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


        JLabel lblTitulo = new JLabel("REGISTRO DE MEDICAMENTO");
        lblTitulo.setForeground(new Color(0, 100, 75));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(220, 0, 660, 80);
        panelEncabezado.add(lblTitulo);


        // =====================================================
        // INFORMACION DEL MEDICAMENTO
        // =====================================================

        JLabel lblSeccion =
                crearTituloSeccion("INFORMACION DEL MEDICAMENTO");

        lblSeccion.setBounds(30, 100, 820, 25);
        getContentPane().add(lblSeccion);


        // ID
        JLabel lblId = new JLabel("ID del medicamento");
        lblId.setBounds(40, 145, 180, 20);
        getContentPane().add(lblId);

        txtId = new JTextField();
        txtId.setBounds(40, 168, 350, 30);
        getContentPane().add(txtId);


        // Nombre
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(460, 145, 150, 20);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(460, 168, 350, 30);
        getContentPane().add(txtNombre);


        // Stock
        JLabel lblStock = new JLabel("Stock");
        lblStock.setBounds(40, 220, 150, 20);
        getContentPane().add(lblStock);

        txtStock = new JTextField();
        txtStock.setBounds(40, 243, 350, 30);
        getContentPane().add(txtStock);


        // Fecha de vencimiento
        JLabel lblFecha =
                new JLabel("Fecha de vencimiento (AAAA-MM-DD)");

        lblFecha.setBounds(460, 220, 270, 20);
        getContentPane().add(lblFecha);

        txtFechaVencimiento = new JTextField();
        txtFechaVencimiento.setBounds(460, 243, 350, 30);
        getContentPane().add(txtFechaVencimiento);


        // =====================================================
        // BOTONES
        // =====================================================

        JButton btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(245, 305, 120, 35);
        getContentPane().add(btnGuardar);

        JButton btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBounds(380, 305, 120, 35);
        getContentPane().add(btnLimpiar);

        JButton btnVolver = new JButton("VOLVER");
        btnVolver.setBounds(515, 305, 120, 35);
        getContentPane().add(btnVolver);


        // =====================================================
        // TABLA
        // =====================================================

        JLabel lblRegistrados =
                crearTituloSeccion("MEDICAMENTOS REGISTRADOS");

        lblRegistrados.setBounds(30, 375, 820, 25);
        getContentPane().add(lblRegistrados);


        String[] columnas = {
                "ID",
                "Nombre",
                "Stock",
                "Fecha de vencimiento"
        };


        modeloTabla = new DefaultTableModel(columnas, 0) {

            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };


        tablaMedicamentos = new JTable(modeloTabla);

        JScrollPane scrollTabla =
                new JScrollPane(tablaMedicamentos);

        scrollTabla.setBounds(30, 410, 820, 110);
        getContentPane().add(scrollTabla);


        // =====================================================
        // EVENTOS
        // =====================================================

        btnGuardar.addActionListener(e -> guardarMedicamento());

        btnLimpiar.addActionListener(e -> limpiarCampos());

        btnVolver.addActionListener(e -> dispose());


        // Mostramos los medicamentos existentes
        actualizarTabla();
    }


    // =========================================================
    // GUARDAR MEDICAMENTO
    // =========================================================

    private void guardarMedicamento() {

        try {

            // Verificamos campos vacios
            if (txtId.getText().isEmpty()
                    || txtNombre.getText().isEmpty()
                    || txtStock.getText().isEmpty()
                    || txtFechaVencimiento.getText().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Complete todos los campos."
                );

                return;
            }


            // Convertimos los datos numericos
            int id =
                    Integer.parseInt(txtId.getText());

            int stock =
                    Integer.parseInt(txtStock.getText());


            // El stock no puede ser negativo
            if (stock < 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "El stock no puede ser negativo."
                );

                return;
            }


            String nombre =
                    txtNombre.getText();


            LocalDate fechaVencimiento =
                    LocalDate.parse(
                            txtFechaVencimiento.getText()
                    );


            // Creamos el medicamento
            Medicamento medicamento =
                    new Medicamento(
                            id,
                            nombre,
                            stock,
                            fechaVencimiento
                    );


            // Guardamos en Data
            Data.lstMedicamentos.add(medicamento);


            // Actualizamos la tabla
            actualizarTabla();


            // Limpiamos
            limpiarCampos();


            JOptionPane.showMessageDialog(
                    this,
                    "Medicamento registrado correctamente."
            );


        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "El ID y el stock deben ser numeros."
            );


        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "La fecha debe tener el formato AAAA-MM-DD.\n"
                    + "Ejemplo: 2027-12-31"
            );
        }
    }


    // =========================================================
    // ACTUALIZAR TABLA
    // =========================================================

    private void actualizarTabla() {

        modeloTabla.setRowCount(0);


        for (Medicamento medicamento : Data.lstMedicamentos) {

            Object[] fila = {

                    medicamento.getIdMedicamento(),

                    medicamento.getNombre(),

                    medicamento.getStock(),

                    medicamento.getFechaVencimiento()
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
        txtStock.setText("");
        txtFechaVencimiento.setText("");

        txtId.requestFocus();
    }


    // =========================================================
    // CREAR TITULOS DE SECCION
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
