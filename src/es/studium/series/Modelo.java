package es.studium.series;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modelo
{
	// En esta clase todo lo relacionado a la conexión con la base de datos y la lógica.

	// Constructor para luego crear objetos de esta clase.
	// Para conectar JAVA con MYSQL.
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/series"; // Aquí nombre de la base de datos.
	String login = "evaM";
	String password = "evaM";
	String sentencia = "SELECT * FROM series"; 

	Connection connection = null; // Objeto "connection", para conectarnos a la base de datos.
	Statement statement = null; // Objeto, permite ejecutar sentencias SQL.
	ResultSet rs; // Objeto, para guardar toda la información que nos devuelve la base de datos.

	String resultado = "";
	
	public Modelo()
	{
		connection = this.conectar();
	}

	
	//Método CONECTAR.
	public Connection conectar()
	{
		// Aquí la conexión con la base de datos.
		try
		{
			// Cargar los controladores para el acceso a la BD.
			Class.forName(driver);

			// Aquí se conectan.
			// Establecer la conexión con la BD Empresa.
			return (DriverManager.getConnection(url, login, password)); // Devolver un objeto de la clase conexión.
		}

		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1-" + cnfe.getMessage());
		}

		catch (SQLException sqle)
		{
			System.out.println("Error 2-" + sqle.getMessage());
		}

		return null; // Si no conseguimos conectarnos, no devuelve una conexión nula, no se conecta.
	}
	
	
	//Método MOSTRAR INFORMACIÓN.
	public String mostrarInformacion()
	{
		try
		{
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			//Crear un objeto ResultSet para guardar lo obtenido y ejecutar la sentencia SQL.
			rs = statement.executeQuery(sentencia);
			
			rs.next();
			
			resultado = rs.getString("nombreSerie")+"-"+ rs.getString("anioSerie")+"-"+ rs.getString("directorSerie")+"-"+ 
					rs.getString("temporadasSerie")+"-"+ rs.getString("descripcionSerie")+"-"+ rs.getString("imagenSerie");
		}	
		catch (SQLException sqle)
		{
			System.out.println("Error 3-"+sqle.getMessage());
		}
		
		return resultado;
	}
	
	
	//Método SIGUIENTE.
	public String siguienteRegistro()
	{
		 try
		 {
			 if (!rs.isLast())
			 {
				 rs.next();
	                
				 return resultado = rs.getString("nombreSerie")+"-"+ rs.getString("anioSerie")+"-"+ rs.getString("directorSerie")+"-"+ 
	    					rs.getString("temporadasSerie")+"-"+ rs.getString("descripcionSerie")+"-"+ rs.getString("imagenSerie");
	         }
	         else
	         {
	        	 return resultado; //Para que siga mostrando el último registro.
	         }  
	     }
		 catch (SQLException sqle)
		 {
			 System.out.println("Error 4-" + sqle.getMessage());
	     }
		 
		 return null;
	}
	
	
	//Método ANTERIOR.
	public String anteriorRegistro() 
	{
        try
        {
        	if (!rs.isFirst())
        	{
                rs.previous();
                
                return resultado = rs.getString("nombreSerie")+"-"+ rs.getString("anioSerie")+"-"+ rs.getString("directorSerie")+"-"+ 
    					rs.getString("temporadasSerie")+"-"+ rs.getString("descripcionSerie")+"-"+ rs.getString("imagenSerie");
            }
            else
            {
            	return resultado; //Para que siga mostrando el primer registro.
            	
            }
        }
        catch (SQLException sqle)
        {
            System.out.println("Error 5-" + sqle.getMessage());
        }
        
		return null;
    }
}




	/* Para comprobar que se realiza la conexión con la base de datos.
	
	public static void main(String[] args)
	{
		Modelo modelo = new Modelo();
		
		if(modelo.conectar() != null
		{
			System.out.println("Conexión realizada a la base de datos");
		}
		else
		{
			System.out.println("Error al conectar a la base de datos");
		}
	}
	
	*/