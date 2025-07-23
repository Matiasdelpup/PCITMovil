package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.*;
import clases.Conexion;
import java.awt.Toolkit;

public class Admin extends JFrame {
	
	String usuario, nombreusuario;
	public static int sesion_usuario;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Admin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Admin.class.getResource("/icono.png")));
		usuario = Login.usuario;
		sesion_usuario = 1;
		setSize(650, 430);
		setResizable(false);
		setTitle("Admin PCITMovil" + " - " + usuario);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Creado y modificado a gusto por Matias Del Pup");
		lblNewLabel_1.setBounds(174, 377, 317, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPanelVistaTecnico = new JLabel("Panel vista Tecnico");
		lblPanelVistaTecnico.setForeground(Color.WHITE);
		lblPanelVistaTecnico.setBounds(280, 340, 110, 14);
		contentPane.add(lblPanelVistaTecnico);
		
		JLabel lblPanelVistaOperador = new JLabel("Panel vista Operador");
		lblPanelVistaOperador.setForeground(Color.WHITE);
		lblPanelVistaOperador.setBounds(40, 340, 120, 14);
		contentPane.add(lblPanelVistaOperador);
		
		JLabel lblCreatividad = new JLabel("Creatividad");
		lblCreatividad.setForeground(Color.WHITE);
		lblCreatividad.setBounds(500, 170, 120, 14);
		contentPane.add(lblCreatividad);
		
		JLabel lblGestionarUsuarios = new JLabel("Gestionar usuarios");
		lblGestionarUsuarios.setForeground(Color.WHITE);
		lblGestionarUsuarios.setBounds(280, 170, 110, 14);
		contentPane.add(lblGestionarUsuarios);
		
		JLabel lblAcercaDe = new JLabel("Acerca de");
		lblAcercaDe.setForeground(Color.WHITE);
		lblAcercaDe.setBounds(500, 340, 120, 14);
		contentPane.add(lblAcercaDe);
		
		JLabel lblNewLabel = new JLabel("Registrar usuarios");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(50, 170, 110, 14);
		contentPane.add(lblNewLabel);
		
		JButton boton_operador = new JButton("");
		boton_operador.setIcon(new ImageIcon(Admin.class.getResource("/operador.png")));
		boton_operador.setBounds(40, 240, 120, 100);
		contentPane.add(boton_operador);
		
		JButton boton_tecnico = new JButton("");
		boton_tecnico.setIcon(new ImageIcon(Admin.class.getResource("/tecnicoo.gif")));
		boton_tecnico.setBounds(270, 240, 120, 100);
		contentPane.add(boton_tecnico);
		
		JButton boton_acercade = new JButton("");
		boton_acercade.setIcon(new ImageIcon(Admin.class.getResource("/pcitmovil_icono.png")));
		boton_acercade.setBounds(500, 240, 120, 100);
		contentPane.add(boton_acercade);
		
		JButton boton_creatividad = new JButton("");
		boton_creatividad.setIcon(new ImageIcon(Admin.class.getResource("/creatividad.png")));
		boton_creatividad.setBounds(500, 70, 120, 100);
		contentPane.add(boton_creatividad);
		
		JButton boton_gestionarusuarios = new JButton("");
		boton_gestionarusuarios.setIcon(new ImageIcon(Admin.class.getResource("/informacion.gif")));
		boton_gestionarusuarios.setBounds(270, 70, 120, 100);
		contentPane.add(boton_gestionarusuarios);
		
		JButton boton_registrar = new JButton("");
		boton_registrar.setIcon(new ImageIcon(Admin.class.getResource("/agregarUsuario.gif")));
		boton_registrar.setBounds(40, 70, 120, 100);
		contentPane.add(boton_registrar);
		
		JLabel label_nombreusuario = new JLabel("New label");
		label_nombreusuario.setFont(new Font("Arial", Font.BOLD, 20));
		label_nombreusuario.setForeground(new Color(255, 255, 255));
		label_nombreusuario.setBounds(10, 20, 290, 39);
		contentPane.add(label_nombreusuario);
		
		JLabel label_wallpaper = new JLabel("");
		label_wallpaper.setBounds(0, 0, 634, 391);
		contentPane.add(label_wallpaper);
		ImageIcon wallpaper = new ImageIcon(getClass().getResource("/background.jpg"));
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(),label_wallpaper.getHeight(), Image.SCALE_DEFAULT ));
		label_wallpaper.setIcon(icono);
		this.repaint();
		
		try 
		{
			Connection con = Conexion.conexion();
			PreparedStatement prs = con.prepareStatement("SELECT nombre_usuario FROM usuarios WHERE username = '" + usuario + "'");
			ResultSet rs = prs.executeQuery();
			if (rs.next()) {
				nombreusuario = rs.getString("nombre_usuario");
				label_nombreusuario.setText("Bienvenido, " + nombreusuario);
			} else {
				label_nombreusuario.setText("Usuario no encontrado");
			}
		} catch (Exception e) {
			System.err.println("Error al obtener el nombre de usuario: " + e.getMessage());
			label_nombreusuario.setText("Error al cargar nombre");
		}
	}
	
}
