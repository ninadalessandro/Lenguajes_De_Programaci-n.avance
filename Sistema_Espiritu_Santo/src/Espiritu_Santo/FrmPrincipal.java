package Espiritu_Santo;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FrmPrincipal {

    private JFrame frame;


    // =========================================================
    // INICIO DEL PROGRAMA
    // =========================================================

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    FrmPrincipal window =
                            new FrmPrincipal();

                    window.frame.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        });
    }


    // Constructor
    public FrmPrincipal() {

        initialize();
    }


    // =========================================================
    // CREACIÓN DE LA VENTANA
    // =========================================================

    private void initialize() {

        frame = new JFrame();

        frame.setTitle("Sistema Espiritu Santo");

        frame.setBounds(
                100,
                100,
                600,
                550
        );

        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.getContentPane().setLayout(null);


        // =====================================================
        // TÍTULO
        // =====================================================

        JLabel lblTitulo =
                new JLabel("SISTEMA ESPIRITU SANTO");

        lblTitulo.setFont(
                new Font(
                        "Tahoma",
                        Font.BOLD,
                        22
                )
        );

        lblTitulo.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        lblTitulo.setBounds(
                100,
                30,
                380,
                50
        );

        frame.getContentPane().add(lblTitulo);


        // =====================================================
        // PACIENTES
        // =====================================================

        JButton btnPacientes =
                new JButton("Pacientes");

        btnPacientes.setBounds(
                190,
                110,
                200,
                45
        );

        frame.getContentPane().add(btnPacientes);


        // Abrir formulario de pacientes
        btnPacientes.addActionListener(e -> {

            FrmPaciente ventanaPaciente =
                    new FrmPaciente();

            ventanaPaciente.setVisible(true);
        });


        // =====================================================
        // MÉDICOS
        // =====================================================

        JButton btnMedicos =
                new JButton("Medicos");

        btnMedicos.setBounds(
                190,
                165,
                200,
                45
        );
        
        btnMedicos.addActionListener(e -> {

            FrmMedico ventanaMedico = new FrmMedico();
            ventanaMedico.setVisible(true);

        });
        

        frame.getContentPane().add(btnMedicos);


     // =====================================================
     // CITAS
     // =====================================================

     JButton btnCitas =
             new JButton("Citas");

     btnCitas.setBounds(
             190,
             220,
             200,
             45
     );

     frame.getContentPane().add(btnCitas);

     btnCitas.addActionListener(e -> {

         FrmCita ventanaCita = new FrmCita();
         ventanaCita.setVisible(true);

     });


  // =====================================================
  // HISTORIAS CLÍNICAS
  // =====================================================

  JButton btnHistorias =
          new JButton("Historias Clinicas");

  btnHistorias.setBounds(
          190,
          275,
          200,
          45
  );

  frame.getContentPane().add(btnHistorias);


  // Abrir formulario
  btnHistorias.addActionListener(e -> {

      FrmHistoriaClinica ventanaHistoria =
              new FrmHistoriaClinica();

      ventanaHistoria.setVisible(true);

  });


//=====================================================
//ATENCIONES
//=====================================================

JButton btnAtenciones =
       new JButton("Atenciones");

btnAtenciones.setBounds(
       190,
       330,
       200,
       45
);

frame.getContentPane().add(btnAtenciones);


//Abrir formulario de atenciones
btnAtenciones.addActionListener(e -> {

   FrmAtencion ventanaAtencion =
           new FrmAtencion();

   ventanaAtencion.setVisible(true);

});
        frame.getContentPane().add(btnAtenciones);


     // =====================================================
     // MEDICAMENTOS
     // =====================================================

     JButton btnMedicamentos =
             new JButton("Medicamentos");

     btnMedicamentos.setBounds(
             190,
             385,
             200,
             45
     );

     frame.getContentPane().add(btnMedicamentos);

     // Abrir formulario de medicamentos
     btnMedicamentos.addActionListener(e -> {

         FrmMedicamento ventanaMedicamento =
                 new FrmMedicamento();

         ventanaMedicamento.setVisible(true);

     });

         }

     }