package es.studium.series;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Vista extends Frame //Hereda de Frame.
{
	private static final long serialVersionUID = 1L; //Por haber heredado de la clase Frame.
	
	//Crear los objetos.
	TextField txtNombre = new TextField();
	TextField txtAnio = new TextField();
	TextField txtDirector= new TextField();
	TextField txtTemporadas = new TextField();	
	JTextArea areaTexto = new JTextArea(""); //"": vacío, alto y ancho.
	JLabel jlImagen = new JLabel();
	
	Button btnAnterior = new Button("Anterior");
	Button btnSiguiente = new Button("Siguiente");
	
	public Vista()
	{
		setLayout(null);
		setTitle("Series");
		
		setSize(490, 480);
		
		txtNombre.setBounds(280, 50, 180, 25);
		add(txtNombre);
		txtAnio.setBounds(280, 80, 180, 25);
		add(txtAnio);
		txtDirector.setBounds(280, 110, 180, 25);
		add(txtDirector);
		txtTemporadas.setBounds(280, 140, 180, 25);
		add(txtTemporadas);
		
		areaTexto.setWrapStyleWord(true); //No se corten las palabras.
	    areaTexto.setLineWrap(true); //Para que se coloque texto en varias líneas.
	    
		areaTexto.setBounds(280, 170, 180, 220);
		add(areaTexto);
		
	    jlImagen.setBounds(30, 50, 225, 350);
		add(jlImagen);
		
		btnAnterior.setBounds(50, 420, 90, 30); //Horizontal y vertical, ancho y alto.
		add(btnAnterior);
		btnSiguiente.setBounds(350, 420, 90, 30);
		add(btnSiguiente);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
