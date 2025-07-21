package clases;

import java.sql.*;


public class Conexion 
{
	//Conexion local a base de datos
	public static Connection conexion() 
	{
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bd_pcitmovil", "root", "");
			return con;
		} catch (SQLException e) 
		{
			System.out.println("Error de conexion: " + e);
		}
		return (null);
	}
}
