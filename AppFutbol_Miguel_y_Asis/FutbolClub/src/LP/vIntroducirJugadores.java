package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EXCEPCIONES.excepcionJugadorRepe;
import LN.clsGestor;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public class vIntroducirJugadores extends JFrame {
	private clsGestor objGestor;
	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtañonacimiento;
	private JTextField txtapellido;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public vIntroducirJugadores(clsGestor _objGestor) {
		objGestor = _objGestor;
		setBackground(Color.CYAN);
		setTitle("INTRODUCIR JUGADORES");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Industria 4.0\\Dropbox\\TKNS\\IconoJugador.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 173);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox cmbposicion = new JComboBox();
		cmbposicion.setModel(new DefaultComboBoxModel(new String[] { "DELANTERO", "MEDIO", "DEFENSA", "PORTERO" }));
		cmbposicion.setBounds(267, 44, 124, 20);
		contentPane.add(cmbposicion);

		txtnombre = new JTextField();
		txtnombre.setBounds(23, 44, 88, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);

		txtañonacimiento = new JTextField();
		txtañonacimiento.setColumns(10);
		txtañonacimiento.setBounds(23, 96, 88, 20);
		contentPane.add(txtañonacimiento);

		txtapellido = new JTextField();
		txtapellido.setColumns(10);
		txtapellido.setBounds(142, 44, 88, 20);
		contentPane.add(txtapellido);

		txtid = new JTextField();
		txtid.setColumns(10);
		txtid.setBounds(142, 96, 88, 20);
		contentPane.add(txtid);

		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(46, 26, 65, 14);
		contentPane.add(lblNombre);

		JLabel lblAoNacimiento = new JLabel("A\u00D1O NACIMIENTO\r\n");
		lblAoNacimiento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAoNacimiento.setBounds(23, 75, 101, 14);
		contentPane.add(lblAoNacimiento);

		JLabel lblApellido = new JLabel("APELLIDO\r\n");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido.setBounds(161, 26, 69, 14);
		contentPane.add(lblApellido);

		JLabel lblId = new JLabel("ID\r\n");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(165, 75, 46, 14);
		contentPane.add(lblId);

		JLabel lblPosicion = new JLabel("POSICION\r\n");
		lblPosicion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPosicion.setBounds(267, 26, 79, 14);
		contentPane.add(lblPosicion);

		JButton btnenviarjugador = new JButton("ENVIAR\r\n");
		btnenviarjugador.setBounds(267, 95, 124, 23);
		contentPane.add(btnenviarjugador);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		btnenviarjugador.addActionListener(new ActionListener() {

			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				try {
					objGestor.introducirJugadores(txtnombre.getText(), txtapellido.getText(), Integer.parseInt(txtañonacimiento.getText()), cmbposicion.getSelectedItem().toString(), Integer.parseInt(txtid.getText())); 
							
							
					dispose();
				} catch (Exception exc) {
					String m = exc.getMessage();
					System.err.println(m);
				}
			}
		});
	}
}
