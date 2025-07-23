package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import clases.Conexion;
import javax.swing.JOptionPane;

public class Login extends JFrame 
{
	public static String usuario = "";
	String password = "";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel jlabel_logo;
	private JTextField text_usuario;
	private JPasswordField text_password;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/icono.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 550);
		setResizable(false);
		setTitle("Login PCITMovil"); 
		setBounds(100, 100, 400, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreadoPorMatias = new JLabel("Creado por Matias Del Pup mientras practicaba");
		lblCreadoPorMatias.setBounds(65, 486, 276, 14);
		contentPane.add(lblCreadoPorMatias);
		
		JButton boton_entrar = new JButton("Entrar");
		boton_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				usuario = text_usuario.getText().trim();
				password = text_password.getText().trim();
				
				if(!usuario.equals("") || !password.equals("")) 
				{
					try 
					{
						Connection con = Conexion.conexion();
						PreparedStatement prs = con.prepareStatement("SELECT tipo_nivel, status from usuarios WHERE username = '" +  usuario + "' AND password = '" + password + "'");
						ResultSet rs = prs.executeQuery();
						if(rs.next()) 
						{
							String tipo_nivel = rs.getString("tipo_nivel");
							String status = rs.getString("status");
							
							if (tipo_nivel.equals("Tecnico") && status.equals("Activo")) {
								new Tecnico().setVisible(true);
								dispose();
							} else if (tipo_nivel.equals("Operador") && status.equals("Activo")) {
								new Operador().setVisible(true);
								dispose();
							} else if (tipo_nivel.equals("Administrador") && status.equals("Activo")) {
								new Admin().setVisible(true);
								dispose();
							} else {
								JOptionPane.showMessageDialog(null, "Usuario inactivo o sin permisos.", "Error",
										JOptionPane.ERROR_MESSAGE);
								text_usuario.setText("");
								text_password.setText("");
							}
						} else 
						{
							JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
							text_usuario.setText("");
							text_password.setText("");
						}
					} catch(SQLException ex) 
					{
						System.err.println("Error al conectar a la base de datos: " + ex.getMessage());
						JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos. Por favor, contacte al administrador del programa.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else 
				{
					JOptionPane.showMessageDialog(null, "Por favor, completar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		boton_entrar.setBorder(null);
		boton_entrar.setFont(new Font("Arial Black", Font.PLAIN, 18));
		boton_entrar.setForeground(new Color(255, 255, 255));
		boton_entrar.setBackground(new Color(153, 153, 255));
		boton_entrar.setBounds(95, 420, 210, 35);
		contentPane.add(boton_entrar);
		
		text_password = new JPasswordField();
		text_password.setHorizontalAlignment(SwingConstants.CENTER);
		text_password.setFont(new Font("Arial", Font.PLAIN, 18));
		text_password.setBackground(new Color(153, 153, 255));
		text_password.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		text_password.setForeground(new Color(255, 255, 255));
		text_password.setBounds(95, 370, 210, 20);
		contentPane.add(text_password);
		
		text_usuario = new JTextField();
		text_usuario.setAlignmentX(Component.LEFT_ALIGNMENT);
		text_usuario.setHorizontalAlignment(SwingConstants.CENTER);
		text_usuario.setFont(new Font("Arial", Font.PLAIN, 18));
		text_usuario.setBackground(new Color(153, 153, 255));
		text_usuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		text_usuario.setForeground(new Color(255, 255, 255));
		text_usuario.setBounds(95, 330, 210, 20);
		contentPane.add(text_usuario);
		text_usuario.setColumns(10);
		
		jlabel_logo = new JLabel("");
		jlabel_logo.setBounds(22, 11, 352, 270);
		contentPane.add(jlabel_logo);
		
		JLabel jlabel_Wallpaper = new JLabel("");
		jlabel_Wallpaper.setBounds(0, 0, 384, 511);
		contentPane.add(jlabel_Wallpaper);
		
		ImageIcon wallpaper = new ImageIcon(getClass().getResource("/background.jpg"));
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jlabel_Wallpaper.getWidth(),jlabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT ));
		jlabel_Wallpaper.setIcon(icono);
		this.repaint();
		
		
		ImageIcon wallpaper_logo = new ImageIcon(getClass().getResource("/pcitmovil.png"));
		Icon icono_logo = new ImageIcon(wallpaper_logo.getImage().getScaledInstance(jlabel_logo.getWidth(),jlabel_logo.getHeight() ,Image.SCALE_DEFAULT ));
		jlabel_logo.setIcon(icono_logo);
		this.repaint();
		setLocationRelativeTo(null);
	}
	
}
