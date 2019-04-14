package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EXCEPCIONES.excepcionStaffRepe;
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

public class vIntroducirStaffs extends JFrame {

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtañonacimiento;
	private JTextField txtapellido;
	private JTextField txtid;
	private JTextField txtsueldo;
	private clsGestor objGestor;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public vIntroducirStaffs(clsGestor _objGestor) {
		objGestor = _objGestor;
		setBackground(Color.CYAN);
		setTitle("INTRODUCIR STAFFS");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Industria 4.0\\Desktop\\TKNS\\AppFutbol_Miguel_y_Asis\\IconoStaff.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 211);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cmbtipo = new JComboBox();
		cmbtipo.setModel(new DefaultComboBoxModel(new String[] {"PERSONAL LIMPIEZA", "ADMINISTRACION", "DIRECCION", "OJEADORES"}));
		cmbtipo.setBounds(258, 43, 147, 20);
		contentPane.add(cmbtipo);
		
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
		lblNombre.setBounds(33, 26, 65, 14);
		contentPane.add(lblNombre);
		
		JLabel lblAoNacimiento = new JLabel("A\u00D1O NACIMIENTO\r\n");
		lblAoNacimiento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAoNacimiento.setBounds(258, 74, 101, 14);
		contentPane.add(lblAoNacimiento);
		
		JLabel lblApellido = new JLabel("APELLIDO\r\n");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido.setBounds(161, 26, 69, 14);
		contentPane.add(lblApellido);
		
		JLabel lblId = new JLabel("ID\r\n");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(165, 75, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblTipo = new JLabel("TIPO STAFF\r\n");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipo.setBounds(267, 26, 88, 14);
		contentPane.add(lblTipo);
		
		JButton btnenviarjugador = new JButton("ENVIAR\r\n");
		btnenviarjugador.setBounds(142, 138, 124, 23);
		contentPane.add(btnenviarjugador);
		
		JLabel labelSueldo = new JLabel("SUELDO");
		labelSueldo.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelSueldo.setBounds(33, 75, 46, 14);
		contentPane.add(labelSueldo);
		
		txtsueldo = new JTextField();
		txtsueldo.setColumns(10);
		txtsueldo.setBounds(258, 97, 88, 20);
		contentPane.add(txtsueldo);

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
				objGestor.introducirStaffs(txtnombre.getText(), txtapellido.getText(), Integer.parseInt(txtañonacimiento.getText()), Integer.parseInt(txtsueldo.getText()), cmbtipo.getSelectedItem().toString(),Integer.parseInt(txtid.getText()));
				dispose();
				}catch(Exception exc) {
					String m = exc.getMessage();
					System.err.println(m);
			}
		}
		});
	}
}
