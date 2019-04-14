package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import LN.clsGestor;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

public class probandoCmbx extends JFrame {
	public probandoCmbx() {
		getContentPane().setLayout(null);
		
		txtapellido = new JTextField();
		txtapellido.setBounds(129, 118, 86, 20);
		getContentPane().add(txtapellido);
		txtapellido.setColumns(10);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(129, 32, 86, 20);
		getContentPane().add(txtnombre);
		txtnombre.setColumns(10);
		
		txtanio = new JTextField();
		txtanio.setBounds(129, 177, 86, 20);
		getContentPane().add(txtanio);
		txtanio.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clsGestor objGestor=new clsGestor();
				try {
				objGestor.introducirJugadores(txtnombre.getText(),txtapellido.getText(), Integer.parseInt(txtanio.getText()), cbposicion.getSelectedItem().toString(), Integer.parseInt(txtid.getText()));
				System.out.println("entro aqui");
				dispose();
				}catch(Exception exc) {
				exc.printStackTrace();
			}
		}
		});
		btnNewButton.setBounds(233, 206, 89, 23);
		getContentPane().add(btnNewButton);
		
		cbposicion = new JComboBox();
		cbposicion.setModel(new DefaultComboBoxModel(new String[] {"delantero", "medio", "defensa", "portero"}));
		cbposicion.setBounds(233, 118, 114, 20);
		getContentPane().add(cbposicion);
		
		txtid = new JTextField();
		txtid.setBounds(265, 32, 86, 20);
		getContentPane().add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setBounds(58, 35, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("APELLIDO\r\n");
		lblNewLabel_1.setBounds(58, 121, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("A\u00D1O DE NACIMIENTO\r\n");
		lblNewLabel_2.setBounds(58, 180, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID\r\n");
		lblNewLabel_3.setBounds(276, 11, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("POSICION\r\n");
		lblNewLabel_4.setBounds(265, 96, 46, 14);
		getContentPane().add(lblNewLabel_4);
	}

	private static JPanel contentPane;
	private JTextField txtapellido;
	private JTextField txtnombre;
	private JTextField txtanio;
	private JTextField txtid;
	private JComboBox cbposicion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					probandoCmbx frame = new probandoCmbx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	}
