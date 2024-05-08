package v;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

class LoginFrame extends JFrame {
	private JPanel contentPane;
	

	public LoginFrame() {
		setResizable(false);
		setTitle("Log in Window");
		setType(Type.POPUP);
		setBounds(100, 100, 299, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 337, 230);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(10, 11, 65, 14);
		contentPane.add(lblusername);
		
		JTextField tfusername = new JTextField();
		tfusername.setBounds(85, 8, 200, 20);
		contentPane.add(tfusername);
		tfusername.setColumns(10);
		
		JLabel lblPassword1 = new JLabel("Password");
		lblPassword1.setBounds(10, 59, 65, 14);
		contentPane.add(lblPassword1);
		
		JPasswordField pfPassword = new JPasswordField();
		pfPassword.setBounds(85, 56, 200, 20);
		contentPane.add(pfPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(59, 98, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Close");
		btnCancel.setBounds(168, 98, 89, 23);
		contentPane.add(btnCancel);

		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// note how we get the password text from JTextPassword
				String strPassword = String.valueOf(pfPassword.getPassword());
				String strUsername = tfusername.getText().trim();

				if (verifyLogin(strPassword, strPassword)) {
					setVisible(false);
				} else {
					// play around with the options
					JOptionPane.showMessageDialog(null, "Incorrect username/password", "Login",
							JOptionPane.ERROR_MESSAGE);

				}
			}

			private boolean verifyLogin(String strPassword, String strUser) {
				if ("1".equalsIgnoreCase(strUser) && "1".equalsIgnoreCase(strPassword))
					return true;
				return false;
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pfPassword.setText("");
				tfusername.setText("");
				setVisible(false);

			}
		});
	}
}