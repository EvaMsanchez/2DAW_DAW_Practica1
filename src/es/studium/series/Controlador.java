package es.studium.series;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;

public class Controlador implements WindowListener, ActionListener
{
	Modelo modelo;
	Vista vista;
	
	public Controlador(Modelo m, Vista v)
	{
		this.modelo = m;
		this.vista = v;
		
		//Añadir Listeners.
		v.addWindowListener(this);
		v.btnAnterior.addActionListener(this);
		v.btnSiguiente.addActionListener(this);
		
		//Aparezca el registro nada más abrir el programa.
		actualizar(modelo.mostrarInformacion());
	}

	
	@Override
	public void windowOpened(WindowEvent e){}
	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	@Override
	public void windowClosed(WindowEvent e){}
	@Override
	public void windowIconified(WindowEvent e){}
	@Override
	public void windowDeiconified(WindowEvent e){}
	@Override
	public void windowActivated(WindowEvent e){}
	@Override
	public void windowDeactivated(WindowEvent e){}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(vista.btnSiguiente))
		{
			String resultado = modelo.siguienteRegistro();
			actualizar(resultado);	
		}
		
		else if(e.getSource().equals(vista.btnAnterior))
		{
			String resultado = modelo.anteriorRegistro();
			actualizar(resultado);
		}
	}
	
	
	//Método ACTUALIZAR.
	public void actualizar(String resultado)
	{
		//Esta condición es para que no se meta aquí si el resultado es nulo y no de error en consola.
		if(resultado != null)
		{
			String datos[] = resultado.split("-");
			vista.txtNombre.setText(datos[0]);
			vista.txtAnio.setText("Año: " + datos[1]);
			vista.txtDirector.setText("Director/a: " + datos[2]);
			vista.txtTemporadas.setText("Temporadas: " + datos[3]);
			vista.areaTexto.setText("Descripción: \n" + datos[4]);
			
			String nombreImagen = datos[5];
			//System.out.println(nombreImagen);
			
			// Cargar la imagen.
		    ImageIcon rutaImagen = new ImageIcon("./img/" + nombreImagen);
		    
		    //Pasar la ruta a imagen para poder ponerla a escala.
		    //System.out.println(rutaImagen);
		    Image imagen = rutaImagen.getImage();
		    	
			
			//Escalar la imagen.
			int anchoDeseado = vista.jlImagen.getWidth(); //Así se obtiene el ancho del JLabel.
			int altoDeseado = vista.jlImagen.getHeight(); //Así se obtiene el alto del JLabel.
		    
			Image imagenEscalada = imagen.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
			ImageIcon imagenFinal = new ImageIcon(imagenEscalada);
			
			//Añadir al JLabel.
			vista.jlImagen.setIcon(imagenFinal);
		}
	}
}

