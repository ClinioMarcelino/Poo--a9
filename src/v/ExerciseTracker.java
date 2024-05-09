package v;

import java.awt.EventQueue;
import java.awt.Window.Type;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import m.Exercise;
import m.ExerciseWriter;
import m.RockClimbing;
import m.RunWalk;
import m.Weightlifting;

import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import java.awt.Font;

public class ExerciseTracker extends JFrame {

	private static final long serialVersionUID = 1L;
	JFrame parent;
	JPanel contentPane;
	JTextField tfName;
	LoginFrame login = new LoginFrame();
	JComboBox cbType = new JComboBox();
	private JTextField tfDuration;
	private JTextField tfDistance;
	private JTextField tfAddComments;
	JFormattedTextField ftfDate;
	JButton btnAddExercise = new JButton("Add Exercise");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExerciseTracker frame = new ExerciseTracker();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExerciseTracker() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 348);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JLabel lblLogin = new JLabel("Log in");
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login.setVisible(true);

			}
		});
		mnFile.add(lblLogin);

		JLabel lblLogout = new JLabel("Log out");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cbType.setEnabled(false);
				tfName.setEnabled(false);
				ftfDate.setEnabled(false);
				tfDuration.setEnabled(false);
				tfDistance.setEnabled(false);
				tfAddComments.setEnabled(false);
				btnAddExercise.setEnabled(false);
			}
		});
		mnFile.add(lblLogout);

		JLabel lblSave = new JLabel("Save");
		lblSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				File f;
				if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					f = fileChooser.getSelectedFile();
					try {
						ExerciseWriter.writeFile(f);
						JOptionPane.showMessageDialog(lblSave, "File Saved succesfuly!");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// save to file
				}
			}
		});
		mnFile.add(lblSave);

		JLabel lblNewLabel = new JLabel("Exit");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(lblNewLabel);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfName = new JTextField();
		tfName.setEnabled(false);
		tfName.setBounds(93, 44, 158, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 45, 46, 14);
		contentPane.add(lblName);

		JLabel lblType = new JLabel("Type");
		lblType.setBounds(10, 11, 46, 14);
		contentPane.add(lblType);
		cbType.setModel(new DefaultComboBoxModel(new String[] { "", "Run Walk", "Weightlifting", "Rock Climbing" }));

		cbType.setEnabled(false);
		cbType.setBounds(93, 11, 158, 22);
		contentPane.add(cbType);

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(10, 76, 46, 14);
		contentPane.add(lblDate);

		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(10, 104, 73, 14);
		contentPane.add(lblDuration);

		tfDuration = new JTextField();
		tfDuration.setEnabled(false);
		tfDuration.setColumns(10);
		tfDuration.setBounds(93, 103, 158, 20);
		contentPane.add(tfDuration);

		JLabel lblDistance = new JLabel("Distance");
		lblDistance.setBounds(10, 132, 73, 14);
		contentPane.add(lblDistance);

		tfDistance = new JTextField();
		tfDistance.setEnabled(false);
		tfDistance.setColumns(10);
		tfDistance.setBounds(93, 131, 158, 20);
		contentPane.add(tfDistance);

		JLabel lblComents = new JLabel("Add Comments");
		lblComents.setBounds(10, 157, 163, 14);
		contentPane.add(lblComents);

		tfAddComments = new JTextField();
		tfAddComments.setEnabled(false);
		tfAddComments.setBounds(10, 174, 241, 54);
		contentPane.add(tfAddComments);
		tfAddComments.setColumns(10);

		JTextPane tpExercise = new JTextPane();
		tpExercise.setFont(new Font("Tahoma", Font.PLAIN, 9));
		tpExercise.setEditable(false);
		tpExercise.setBounds(298, 33, 450, 195);
		contentPane.add(tpExercise);

		JLabel lblExerciseSumary = new JLabel("Exercise Summary");
		lblExerciseSumary.setBounds(298, 11, 217, 14);
		contentPane.add(lblExerciseSumary);

		btnAddExercise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exercise type = null;
				try {
					if (ftfDate.getText().toString().equalsIgnoreCase("")){
						if (cbType.getSelectedItem().toString().equalsIgnoreCase("Run Walk"))
							type = new RunWalk(tfName.getText(),  Double.parseDouble(tfDuration.getText()),
									tfAddComments.getText(), Double.parseDouble(tfDistance.getText()));
						else if (cbType.getSelectedItem().toString().equalsIgnoreCase("Weightlifting"))
							type = new Weightlifting(tfName.getText(),
									Double.parseDouble(tfDuration.getText()), tfAddComments.getText(),
									Double.parseDouble(tfDistance.getText()));
						else if (cbType.getSelectedItem().toString().equalsIgnoreCase("Rock Climbing"))
							type = new RockClimbing(tfName.getText(), 
									Double.parseDouble(tfDuration.getText()), tfAddComments.getText(),
									Double.parseDouble(tfDistance.getText()), 2);
	
						ExerciseWriter.addToSummary(tpExercise.getText() + type.toString() + "\n");
						tpExercise.setText(ExerciseWriter.getSummary());
					}
					else{
				
						if (cbType.getSelectedItem().toString().equalsIgnoreCase("Run Walk"))
							type = new RunWalk(tfName.getText(), Exercise.verifyDate(ftfDate.getText()), Double.parseDouble(tfDuration.getText()),
									tfAddComments.getText(), Double.parseDouble(tfDistance.getText()));
						else if (cbType.getSelectedItem().toString().equalsIgnoreCase("Weightlifting"))
							type = new Weightlifting(tfName.getText(), Exercise.verifyDate(ftfDate.getText()),
									Double.parseDouble(tfDuration.getText()), tfAddComments.getText(),
									Double.parseDouble(tfDistance.getText()));
						else if (cbType.getSelectedItem().toString().equalsIgnoreCase("Rock Climbing"))
							type = new RockClimbing(tfName.getText(), Exercise.verifyDate(ftfDate.getText()),
									Double.parseDouble(tfDuration.getText()), tfAddComments.getText(),
									Double.parseDouble(tfDistance.getText()), 2);
	
						ExerciseWriter.addToSummary(tpExercise.getText() + type.toString() + "\n");
						tpExercise.setText(ExerciseWriter.getSummary());
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(lblExerciseSumary, ex.getMessage());
				}

				tfName.setText("");
				ftfDate.setText("");
				tfDuration.setText("");
				tfAddComments.setText("");
				tfDistance.setText("");
				repaint();
			}
		});

		btnAddExercise.setEnabled(false);
		btnAddExercise.setBounds(204, 253, 118, 23);
		contentPane.add(btnAddExercise);

		ftfDate = new JFormattedTextField("## / ## / ####");
		ftfDate.setEnabled(false);
		ftfDate.setToolTipText("## / ## / ####");
		ftfDate.setText("");
		ftfDate.setBounds(93, 75, 158, 20);
		contentPane.add(ftfDate);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

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

			JButton btnCancel = new JButton("Cancel");
			btnCancel.setBounds(168, 98, 89, 23);
			contentPane.add(btnCancel);

			btnLogin.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// note how we get the password text from JTextPassword
					String strPassword = String.valueOf(pfPassword.getPassword());

					String strUsername = tfusername.getText().trim();

					if (verifyLogin(strPassword, strUsername)) {
						setVisible(false);
						cbType.setEnabled(true);
						tfName.setEnabled(true);
						ftfDate.setEnabled(true);
						tfDuration.setEnabled(true);
						tfDistance.setEnabled(true);
						tfAddComments.setEnabled(true);
						btnAddExercise.setEnabled(true);
					} else {
						// play around with the options
						JOptionPane.showMessageDialog(null, "Incorrect username/password", "Login",
								JOptionPane.ERROR_MESSAGE);

					}
				}

				// AJUSTAR O LOGIN E SENHA!

				private boolean verifyLogin(String strPassword, String strUser) {
					if ("healthy".equalsIgnoreCase(strUser) && "donut".equalsIgnoreCase(strPassword))
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
					cbType.setEnabled(false);
					tfName.setEnabled(false);
					ftfDate.setEnabled(false);
					tfDuration.setEnabled(false);
					tfDistance.setEnabled(false);
					tfAddComments.setEnabled(false);
					btnAddExercise.setEnabled(false);
				}
			});
		}
	}
}
