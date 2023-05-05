package jdbc.views;

import jdbc.controller.HabitacionController;
import jdbc.modelo.Habitacion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.Format;

public class TipoHabitacion extends JFrame {

    private JPanel contentPane;
    private JTextField txtNombre;
    private JLabel labelAtras;
    private JLabel labelExit;
    private JTextField txtDireccion;
    private JComboBox<Format> txtHabitaciones;
    private HabitacionController habitacionController;
    int xtextfiles = 70;
    int xMouse,yMouse;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TipoHabitacion frame = new TipoHabitacion();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TipoHabitacion()
    {
        this.habitacionController = new HabitacionController();
        setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroHuesped.class.getResource("/jdbc/imagenes/lOGO-50PX.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 634);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.text);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setUndecorated(true);

        contentPane.setLayout(null);



        JPanel header = new JPanel();
        header.setBounds(0, 0, 910, 36);
        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                headerMouseDragged(e);

            }
        });
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                headerMousePressed(e);
            }
        });
        header.setLayout(null);
        header.setBackground(SystemColor.text);
        header.setOpaque(false);
        header.setBounds(0, 0, 910, 36);
        contentPane.add(header);

        //crear boton de atras
        JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario menuUsuario = new MenuUsuario();
                menuUsuario.setVisible(true);
                dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnAtras.setBackground(Color.white);
                labelAtras.setForeground(Color.black);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnAtras.setBackground(new Color(12, 138, 199));
                labelAtras.setForeground(Color.white);
            }
        });
        btnAtras.setLayout(null);
        btnAtras.setBackground(new Color(12, 138, 199));
        btnAtras.setBounds(0, 0, 53, 36);
        header.add(btnAtras);

        labelAtras = new JLabel("<");
        labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
        labelAtras.setForeground(Color.WHITE);
        labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
        labelAtras.setBounds(0, 0, 53, 36);
        btnAtras.add(labelAtras);

        // Componentes para dejar la interfaz con estilo Material Design
        JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuPrincipal principal = new MenuPrincipal();
                principal.setVisible(true);
                dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnexit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnexit.setBackground(new Color(12, 138, 199));
                labelExit.setForeground(Color.white);
            }
        });
        btnexit.setLayout(null);
        btnexit.setBackground(new Color(12, 138, 199));
        btnexit.setBounds(850, 0, 53, 36);
        header.add(btnexit);

        labelExit = new JLabel("X");
        labelExit.setForeground(Color.WHITE);
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));


        //titulo
        JLabel lblTitulo = new JLabel("HABITACIÓN");
        lblTitulo.setBounds(xtextfiles, 60, 219, 42);
        lblTitulo.setForeground(new Color(12, 138, 199));
        lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
        contentPane.add(lblTitulo);

        //label de fondo
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(428, 0, 482, 638);
        panel_1.setBackground(new Color(12, 138, 199));
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel logo = new JLabel("");
        logo.setBounds(197, 68, 104, 107);
        panel_1.add(logo);
        logo.setIcon(new ImageIcon(ReservasView.class.getResource("/jdbc/imagenes/Ha-100px.png")));

        JLabel imagenFondo = new JLabel("");
        imagenFondo.setBounds(0, 140, 500, 409);
        panel_1.add(imagenFondo);
        imagenFondo.setBackground(Color.WHITE);
        imagenFondo.setIcon(new ImageIcon(ReservasView.class.getResource("/jdbc/imagenes/reservas-img-3.png")));

        //textfiles
        JLabel lNombre = new JLabel("Nombre:");
        lNombre.setForeground(SystemColor.textInactiveText);
        lNombre.setBounds(xtextfiles,100,289,30);
        lNombre.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lNombre);

        txtNombre = new JTextField();
        txtNombre.setBackground(SystemColor.text);
        txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
        txtNombre.setForeground(Color.BLACK);
        txtNombre.setBounds(xtextfiles, 140, 289, 30);
        txtNombre.setEditable(true);
        txtNombre.setFont(new Font("Roboto Black", Font.BOLD, 17));
        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lHabitaciones = new JLabel("Habitaciones:");
        lHabitaciones.setForeground(SystemColor.textInactiveText);
        lHabitaciones.setBounds(xtextfiles,180,289,30);
        lHabitaciones.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lHabitaciones);

        txtHabitaciones = new JComboBox();
        txtHabitaciones.setBounds(xtextfiles, 220, 289, 30);
        txtHabitaciones.setBackground(SystemColor.text);
        txtHabitaciones.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtHabitaciones.setModel(new DefaultComboBoxModel(new String[] {"1","2","3","4","5"}));
        contentPane.add(txtHabitaciones);

        JLabel lDireccion = new JLabel("Direccion:");
        lDireccion.setForeground(SystemColor.textInactiveText);
        lDireccion.setBounds(xtextfiles,260,289,30);
        lDireccion.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBackground(SystemColor.text);
        txtDireccion.setHorizontalAlignment(SwingConstants.LEFT);
        txtDireccion.setForeground(Color.BLACK);
        txtDireccion.setBounds(xtextfiles, 300, 289, 30);
        txtDireccion.setEditable(true);
        txtDireccion.setFont(new Font("Roboto Black", Font.BOLD, 17));
        txtDireccion.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtDireccion);
        txtDireccion.setColumns(10);

        //rayas que separan
        JSeparator separator_1_2_1 = new JSeparator();
        separator_1_2_1.setBounds(xtextfiles, 330, 289, 2);
        separator_1_2_1.setForeground(new Color(12, 138, 199));
        separator_1_2_1.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_1);

        JSeparator separator_1_2_2 = new JSeparator();
        separator_1_2_2.setBounds(xtextfiles, 250, 289, 2);
        separator_1_2_2.setForeground(new Color(12, 138, 199));
        separator_1_2_2.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_2);

        JSeparator separator_1_2_3 = new JSeparator();
        separator_1_2_3.setBounds(xtextfiles, 170, 289, 2);
        separator_1_2_3.setForeground(new Color(12, 138, 199));
        separator_1_2_3.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_3);


        JLabel lblSiguiente = new JLabel("SIGUIENTE");
        lblSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
        lblSiguiente.setForeground(Color.WHITE);
        lblSiguiente.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblSiguiente.setBounds(0, 0, 122, 35);
        JPanel btnsiguiente = new JPanel();

        btnsiguiente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtNombre != null && txtDireccion != null) {
                    guardarHabitacion();

                } else {
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
                }
            }
        });
        btnsiguiente.setLayout(null);
        btnsiguiente.setBackground(SystemColor.textHighlight);
        btnsiguiente.setBounds(180, 450, 122, 35);
        contentPane.add(btnsiguiente);
        btnsiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsiguiente.add(lblSiguiente);

    }
    private void guardarHabitacion()
    {
        Habitacion habitacion = new Habitacion(txtNombre.getText(),Integer.parseInt(txtHabitaciones.getSelectedItem().toString()),txtDireccion.getText());
        this.habitacionController.guardar(habitacion);

        JOptionPane.showMessageDialog(null,"Habitación guardada con exito");
        ReservasView reservasView = new ReservasView(habitacion.getId());
        reservasView.setVisible(true);
        dispose();

    }

    //Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }

}
